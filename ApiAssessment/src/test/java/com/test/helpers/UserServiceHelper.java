package com.test.helpers;

import static org.hamcrest.Matchers.*;
import java.util.List;
import java.util.Properties;

import com.test.constants.EndPoints;
import com.test.models.CreateEmployeePOJO;
import com.test.models.Employee;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceHelper {
	private static Response response;
	private static Utils prop = new Utils();
	public static Properties load = prop.loadFile();
	public static List<Object> listID2;

	public static String getBaseURI() {

		String baseURI = load.getProperty("api.base.url");
		System.out.println("base URI is " + baseURI);
		return baseURI;
	}

//	public static void getNumberOfUserRecords() {
//		response = RestAssured.given().header("Content-Type", "application/json").when().get(EndPoints.GET_DATA);
//
//		// UserPOJO[] userArray = response.as(UserPOJO[].class); // fetch all user
//		// records
//		// List<UserPOJO> list = Arrays.asList(userArray);
//		List<Employee> list = response.body().jsonPath().getList("data");
//
//		verifyStatusCode(response, 200);
//		verifyStatusMessage(response, "success");
//		System.out.println("User data is printed below: ");
//		System.out.println("*****************************");
//		response.prettyPrint();
//		System.out.println("Number of user records are: " + list.size());
//
//	}
	
	public static Response getEmployees() {
		response = RestAssured.given().header("Content-Type", "application/json").when().get(EndPoints.GET_DATA);

		return response;

	}


	public static Response addUserData(CreateEmployeePOJO user) {

		response = RestAssured.given().contentType(ContentType.JSON).body(user).when().post(EndPoints.ADD_DATA);

		return response;
	}

	public static Response deleteUserData(int empID) {

		response = RestAssured.given().contentType(ContentType.JSON).delete(EndPoints.DELETE_DATA + "/" + empID);

		return response;
	}

	public int getStatusCode(Response res) {
		return res.getStatusCode();
	}

	public String getContentType(Response res) {
		return res.getContentType();
	}

	public static void verifyStatusCode(Response res, int statCode) {
		res.then().statusCode(statCode);

	}

	public static void verifyStatusMessage(Response res, String message) {
		res.then().body("status", is(message));
	}

	public static Response getEmployee(int id) {
		response = RestAssured.given().header("Content-Type", "application/json").when()
				.get(EndPoints.GET_SINGLE_DATA + "/" + id);

		return response;

	}

}
