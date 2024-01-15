package com.example.twitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.twitter.dto.APIResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException ex){
		String message=ex.getMessage();
		APIResponse response=new APIResponse(message,false);
		return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
	}

}