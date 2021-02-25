package com.vinlen.cloudStore.common;

import lombok.Getter;
import org.joda.time.DateTime;


@Getter
 class ExceptionResult {
	private int status;
	private String message;
	private String timestamp;

	 ExceptionResult(AppException e) {
		this.status = e.getStatus();
		this.message = e.getMessage();
		this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
	}
}
