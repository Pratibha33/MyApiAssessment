package com.test.models;

public class GetEmployeePOJO {

	public GetEmployeePOJO() {
		
	}

	public GetEmployeePOJO(String status,Employee data, String message) {
		super();
		this.status= status;
		this.data = data;
		this.message = message;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	Employee data = new Employee();
	private String message;
}