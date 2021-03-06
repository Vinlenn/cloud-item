package com.vinlen.cloudStore.controller;

import com.vinlen.cloudStore.pojo.Category;
import com.vinlen.cloudStore.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	/**
	 * 根据父节点查询商品类目
	 *
	 * @param pid
	 * @return
	 */
	@GetMapping("category/of/parent")
	public ResponseEntity<List<Category>> queryByParentId(
			@RequestParam(value = "pid", defaultValue = "0") Long pid) {
		return ResponseEntity.ok(categoryService.queryListByParent(pid));
	}

	@GetMapping("category/of/brand")
	public ResponseEntity<List<Category>> queryByBrandId(
			@RequestParam(value = "bid") Long bid) {
		return ResponseEntity.ok(categoryService.queryListByBrand(bid));
	}
}
