package com.vinlen.cloudStore.controller;

import com.vinlen.cloudStore.common.AppException;
import com.vinlen.cloudStore.common.ExceptionEnum;
import com.vinlen.cloudStore.pojo.Item;
import com.vinlen.cloudStore.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ItemController {

	@Resource
	private ItemService itemService;

	@PostMapping("item")
	public ResponseEntity <Item> saveItem(Item item){
		// 如果价格为空，则抛出异常，返回400状态码，请求参数有误
		if(item.getPrice() == null){
			throw new AppException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
		}
		Item result = itemService.saveItem(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
}
