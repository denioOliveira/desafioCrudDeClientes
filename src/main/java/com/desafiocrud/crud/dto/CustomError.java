package com.desafiocrud.crud.dto;

import java.time.Instant;

public class CustomError {
	
	private Instant timstamp;
	private Integer status;
	private String error;
	private String trace;
	private String message;
	private String path;
	
	
	public CustomError(Instant timstamp, Integer status, String error, String trace, String message, String path) {
		this.timstamp = timstamp;
		this.status = status;
		this.error = error;
		this.trace = trace;
		this.message = message;
		this.path = path;
	}
	public CustomError(Instant timstamp, Integer status, String error, String path) {
		this.timstamp = timstamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}

	public Instant getTimstamp() {
		return timstamp;
	}

	public void setTimstamp(Instant timstamp) {
		this.timstamp = timstamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}