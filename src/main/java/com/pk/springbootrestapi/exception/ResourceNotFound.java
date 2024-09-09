package com.pk.springbootrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	private String msg;

	public ResourceNotFound(String msg) {
		super(msg);
	}
	
}
