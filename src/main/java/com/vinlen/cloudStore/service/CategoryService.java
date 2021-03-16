package com.vinlen.cloudStore.service;

import com.vinlen.cloudStore.common.AppException;
import com.vinlen.cloudStore.common.ExceptionEnum;
import com.vinlen.cloudStore.mapper.CategoryMapper;
import com.vinlen.cloudStore.pojo.Category;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

	@Resource
	CategoryMapper categoryMapper;

	public List<Category> queryListByParent(Long pid){
		Category category = new Category();
		category.setParentId(pid);
		List<Category> list = categoryMapper.select(category);
		if(CollectionUtils.isEmpty(list))
			throw new AppException(ExceptionEnum.CATEGORY_NOT_FOUND);
		return list;
	}

	public List<Category> queryListByBrand(Long bid){
		List<Category> list = categoryMapper.queryByBrandId(bid);
		// 判断结果
		if(CollectionUtils.isEmpty(list)){
			throw new AppException(ExceptionEnum.CATEGORY_NOT_FOUND);
		}
		return list;
	}
}
