package com.vinlen.cloudStore.common;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
	private int status;

	public AppException(ExceptionEnum em) {
		super(em.getMessage());
		this.status = em.getStatus();
	}

}
