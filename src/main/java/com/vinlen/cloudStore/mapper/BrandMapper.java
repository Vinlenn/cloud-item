package com.vinlen.cloudStore.mapper;

import com.vinlen.cloudStore.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {

	int insertCategoryBrand(@Param("bid") Long bid, @Param("ids") List<Long> ids);

	@Delete("DELETE from tb_category_brand WHERE brand_id = #{bid}")
	int deleteCategoryBrand(@Param("bid") Long bid);
}
