package com.test.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.utils.ExtentReportsUtility;
import com.test.utils.Log4JUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import com.test.models.CreateEmployeePOJO;
import com.test.models.CreateResponsePOJO;
import com.test.models.DeleteUserErrorPOJO;
import com.test.models.DeleteUserPOJO;
import com.test.models.GetEmployeePOJO;
import com.test.models.UserPOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class End2EndTestScript extends UserServiceHelper {
	protected static Log4JUtility logObject = Log4JUtility.getInstance();
	protected static Logger log;
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	private static int empID;

	@BeforeClass
	public static void setBaseUri() {
		RestAssured.baseURI = getBaseURI();
		log = logObject.getLogger();

	}

	// Test Case #1
	@Test(priority = 1, enabled = true)
	public static void getUsers() {
		Response response = getEmployees();

		String jsonString = response.body().asString();
		System.out.println("output :" + jsonString);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			UserPOJO empPOJO = objectMapper.readValue(jsonString, UserPOJO.class);

			assertEquals(empPOJO.getStatus(), "success");
			System.out.println("Number of records: " + empPOJO.getData().size());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		verifyStatusCode(response, 200);
		log.info("Test Case 1 passed");

	}

	// Test Case #2
	@Test(priority = 2, enabled = true)
	public static void createUsers() {
		CreateEmployeePOJO user = ReusableMethods.getUserDataToAdd();
		Response response = addUserData(user);
		String jsonString = response.body().asString();
		System.out.println("out5pur :" + jsonString);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			CreateResponsePOJO crp = objectMapper.readValue(jsonString, CreateResponsePOJO.class);
			assertEquals(crp.getData().getName(), user.getName());
			assertEquals(crp.getData().getAge(), user.getAge());
			assertEquals(crp.getData().getSalary(), user.getSalary());
			assertEquals(crp.getStatus(), "success");
			empID = crp.getData().getId();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		verifyStatusCode(response, 200);
		log.info("Test Case 2 passed");
	}

	// Test Case #3
	@Test(priority = 3, dependsOnMethods = { "createUsers" })
	public static void deleteUser() {
		Response response = deleteUserData(empID);
		String jsonString = response.body().asString();
		System.out.println("out5pur :" + jsonString);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			DeleteUserPOJO deleteUser = objectMapper.readValue(jsonString, DeleteUserPOJO.class);

			assertEquals(deleteUser.getStatus(), "success");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		verifyStatusCode(response, 200);
		log.info("Test Case 3 passed");
	}

	// Test Case #4
	@Test(priority = 4)
	public static void deleteUserWithIDZero() {
		Response response = deleteUserData(0);
		String jsonString = response.body().asString();
		System.out.println("out5pur :" + jsonString);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			DeleteUserErrorPOJO deleteUserErr = objectMapper.readValue(jsonString, DeleteUserErrorPOJO.class);

			assertEquals(deleteUserErr.getStatus(), "error");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		verifyStatusCode(response, 400);
		log.info("Test Case 4 passed");
	}

	// Test Case #5
	@Test(priority = 2, enabled = true)
	public static void getEmployee() {
		Response response = getEmployee(2);
		String jsonString = response.body().asString();
		System.out.println("out5pur :" + jsonString);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			GetEmployeePOJO crp = objectMapper.readValue(jsonString, GetEmployeePOJO.class);

			assertEquals(crp.getData().getEmployee_name(), "Garrett Winters");
			assertEquals(crp.getData().getEmployee_salary(), 170750);
			assertEquals(crp.getData().getEmployee_age(), 63);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		verifyStatusCode(response, 200);
		log.info("Test Case 5 passed");
	}

}
