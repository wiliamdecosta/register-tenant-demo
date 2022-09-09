package com.justclick.tenantregistration.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.justclick.tenantregistration.exceptions.DuplicateValueException;
import com.justclick.tenantregistration.models.outputs.ResponseError;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseError handleInvalidArgument(MethodArgumentNotValidException ex) {

		ResponseError errorResponse = new ResponseError();
		errorResponse.setMessage("Validation error");

		Map<String, List<String>> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			List<String> errorString = new ArrayList<>();
			errorString.add(error.getDefaultMessage());
			errorMap.put(error.getField(), errorString);
		});

		errorResponse.setErrors(errorMap);
		return errorResponse;
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DuplicateValueException.class)
	public ResponseError handleDuplicateValue(DuplicateValueException ex) {

		ResponseError errorResponse = new ResponseError();
		errorResponse.setMessage("Validation error");

		Map<String, List<String>> errorMap = new HashMap<>();
		List<String> errorString = new ArrayList<>();
		errorString.add(ex.getMessage());

		errorMap.put(ex.getFieldName(), errorString);
		errorResponse.setErrors(errorMap);
		return errorResponse;
	}
	
}
