package com.vinlen.cloudStore.mapper;

import com.vinlen.cloudStore.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

	@Select("SELECT tc.id, tc.`name`, tc.parent_id, tc.is_parent, tc.sort FROM tb_category_brand tcb LEFT JOIN tb_category tc ON tcb.category_id = tc.id WHERE tcb.brand_id = #{id}")
	List<Category> queryByBrandId(@Param("id") Long id);
}
