package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(TaskCreateException.class)
	public ErrorMessage taskCreateException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(TaskReadException.class)
	public ErrorMessage taskReadException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(TaskUpdateException.class)
	public ErrorMessage taskUpdateException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(TaskDeleteException.class)
	public ErrorMessage taskDeleteException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}
}