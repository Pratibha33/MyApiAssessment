package com.test.models;

import java.util.ArrayList;
import java.util.List;

public class UserPOJO {
	public UserPOJO() {

	}

	public UserPOJO(String status, List<Employee> data, String message) {
		super();
		this.status = status;
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

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private List<Employee> data = new ArrayList<Employee>();
	private String message;

}
