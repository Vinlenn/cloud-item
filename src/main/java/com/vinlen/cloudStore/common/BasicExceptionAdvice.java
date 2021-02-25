package com.vinlen.cloudStore.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class BasicExceptionAdvice {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<ExceptionResult> handleLyException(AppException e) {
		return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
		return ResponseEntity.status(500).body(e.getMessage());
	}
}