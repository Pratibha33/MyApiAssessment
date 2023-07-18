package com.test.models;

public class DeleteUserPOJO {
	
	public DeleteUserPOJO() {}
	public DeleteUserPOJO(String status, String message) {

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

}
