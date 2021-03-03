package com.vinlen.cloudStore.service;

import com.vinlen.cloudStore.common.AppException;
import com.vinlen.cloudStore.common.ExceptionEnum;
import com.vinlen.cloudStore.mapper.CategoryMapper;
import com.vinlen.cloudStore.mapper.Category_BrandMapper;
import com.vinlen.cloudStore.pojo.Brand;
import com.vinlen.cloudStore.pojo.Category;
import com.vinlen.cloudStore.pojo.Category_Brand;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

	@Resource
	CategoryMapper categoryMapper;

	@Resource
	Category_BrandMapper category_brandMapper;

	public List<Category> queryListByParent(Long pid){
		Category category = new Category();
		category.setParentId(pid);
		List<Category> list = categoryMapper.select(category);
		if(CollectionUtils.isEmpty(list))
			throw new AppException(ExceptionEnum.CATEGORY_NOT_FOUND);
		return list;
	}

	public List<Category> queryListByBrand(Long bid){
		Category_Brand category_brand = new Category_Brand();
		category_brand.setBrand_id(bid);
		List<Category_Brand> list = category_brandMapper.select(category_brand);
		List<Long> categoryIds = list.stream().map(Category_Brand::getCategory_id).collect(Collectors.toList());
		Category category = new Category();
		Example example = new Example(Brand.class);
		example.createCriteria().andIn("id",categoryIds);
		List<Category> categories = categoryMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(categories))
			throw new AppException(ExceptionEnum.CATEGORY_NOT_FOUND);
		return categories;
	}
}
