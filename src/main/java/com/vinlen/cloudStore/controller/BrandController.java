package com.vinlen.cloudStore.controller;

import com.vinlen.cloudStore.common.PageResult;
import com.vinlen.cloudStore.pojo.Brand;
import com.vinlen.cloudStore.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BrandController {

	@Resource
	BrandService brandService;

	@GetMapping("/brand/list")
	public ResponseEntity<PageResult<Brand>> queryBrandByPage(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "5") Integer rows,
			@RequestParam(value = "key", required = false) String key,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "desc", defaultValue = "false") Boolean desc
	) {
		return ResponseEntity.ok(brandService.queryBrandByPage(page, rows, key, sortBy, desc));
	}

	@PutMapping("/brand/update")
	public ResponseEntity<Void> updateBrand(Brand brand, @RequestParam("cids") List<Long> ids){
		brandService.updateBrand(brand, ids);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


}
