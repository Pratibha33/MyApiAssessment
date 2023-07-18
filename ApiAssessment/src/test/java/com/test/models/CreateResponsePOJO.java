package com.test.models;

import java.util.ArrayList;
import java.util.List;

public class CreateResponsePOJO {
	public CreateResponsePOJO() {
		
	}

	public CreateResponsePOJO(String status,ResponsePOJO data, String message) {
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
	public ResponsePOJO getData() {
		return data;
	}
	public void setData(ResponsePOJO data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	ResponsePOJO data = new ResponsePOJO();
	private String message;
}