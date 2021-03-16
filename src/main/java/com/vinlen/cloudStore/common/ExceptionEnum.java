package com.vinlen.cloudStore.common;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
	PRICE_CANNOT_BE_NULL(400, "价格不能为空！"),
	CATEGORY_NOT_FOUND(400,"种类数据为空") ,
	BRAND_NOT_FOUND(400,"品牌数据为空") ,
	UPDATE_OPERATION_FAIL(400,"保存失败") ,
	INSERT_OPERATION_FAIL(400,"插入失败") ;


	private int status;
	private String message;

	ExceptionEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
}