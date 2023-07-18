package com.test.models;

public class DeleteUserErrorPOJO {
	
	public DeleteUserErrorPOJO() {}
	public DeleteUserErrorPOJO(String status, String message) {

		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String status;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	private int code;
	private String errors;
	

}
