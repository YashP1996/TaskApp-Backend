package com.example.demo.exception;

public class TaskCreateException extends Exception {

	private static final long serialVersionUID = 1L;

	public TaskCreateException(String message) {
		super(message);
	}
}