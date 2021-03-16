package com.vinlen.cloudStore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vinlen.cloudStore.common.AppException;
import com.vinlen.cloudStore.common.ExceptionEnum;
import com.vinlen.cloudStore.common.PageResult;
import com.vinlen.cloudStore.mapper.BrandMapper;
import com.vinlen.cloudStore.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandService {

	@Resource
	BrandMapper brandMapper;

	public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String key, String sortBy, Boolean desc) {
		// 分页
		PageHelper.startPage(page, rows);
		// 过滤条件
		Example example = new Example(Brand.class);
		if (StringUtils.isNoneBlank(key)) {
			example.createCriteria().orLike("name", "%" + key + "%")
					.orEqualTo("letter", key.toUpperCase());
		}
		// 排序
		if (StringUtils.isNoneBlank(sortBy)) {
			String orderByClause = sortBy + (desc ? " DESC" : " ASC");
			example.setOrderByClause(orderByClause);// id desc
		}
		// 查询
		List<Brand> brands = brandMapper.selectByExample(example);

		// 判断是否为空
		if (CollectionUtils.isEmpty(brands)) {
			throw new AppException(ExceptionEnum.BRAND_NOT_FOUND);
		}

		// 解析分页结果
		PageInfo<Brand> info = new PageInfo<>(brands);

		// 返回
		return new PageResult<>(info.getTotal(), brands);
	}

	@Transactional
	public void updateBrand(Brand brand, List<Long> ids) {

		// 修改品牌
		int count = brandMapper.updateByPrimaryKeySelective(brand);
		if(count != 1){
			// 更新失败，抛出异常
			throw new AppException(ExceptionEnum.UPDATE_OPERATION_FAIL);
		}
		// 删除中间表数据
		brandMapper.deleteCategoryBrand(brand.getId());

		// 重新插入中间表数据
		count = brandMapper.insertCategoryBrand(brand.getId(), ids);
		if(count != ids.size()){
			// 新增失败，抛出异常
			throw new AppException(ExceptionEnum.INSERT_OPERATION_FAIL);
		}
	}

}
