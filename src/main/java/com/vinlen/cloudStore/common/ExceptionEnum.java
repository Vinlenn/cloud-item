package com.vinlen.cloudStore.common;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
	PRICE_CANNOT_BE_NULL(400, "价格不能为空！");
	;
	private int status;
	private String message;

	ExceptionEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
}