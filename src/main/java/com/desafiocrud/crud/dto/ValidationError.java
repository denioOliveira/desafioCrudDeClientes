package com.desafiocrud.crud.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
	

	public ValidationError(Instant timstamp, Integer status, String error, String path) {
		super(timstamp, status, error, path);
	}

	private List<FieldMessage> errors = new ArrayList<>();

	
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
