package com.example.demo.exception;

public class TaskReadException extends Exception {

	private static final long serialVersionUID = 1L;

	public TaskReadException(String message) {
		super(message);
	}
}