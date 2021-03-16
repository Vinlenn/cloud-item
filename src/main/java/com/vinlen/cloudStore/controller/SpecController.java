package com.vinlen.cloudStore.controller;

import com.vinlen.cloudStore.pojo.SpecGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecController {
	@GetMapping("/group/of/category")
	public ResponseEntity<List<SpecGroup>> queryGroupByCategory(@RequestParam("id") Long id){
		return ResponseEntity.ok(specService.queryGroupByCategory(id));
	}
}
