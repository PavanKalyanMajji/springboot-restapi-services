package com.pk.springbootrestapi.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pk.springbootrestapi.exception.ResourceNotFound;

@ControllerAdvice
public class GlobalExceptionConfig extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String,String> errors=new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String filedName=((FieldError)error).getField();
			String message= error.getDefaultMessage();
			errors.put(filedName, message);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<Object> employeeIdNotFoundException(ResourceNotFound exception) {
		return ResponseEntity.ok(exception.getMessage());
	}
}
