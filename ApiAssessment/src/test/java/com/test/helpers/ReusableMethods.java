package com.test.helpers;

import com.test.models.CreateEmployeePOJO;
import com.test.models.DeleteUserPOJO;

public class ReusableMethods {

	public static CreateEmployeePOJO addUser;
	public static DeleteUserPOJO deleteUser;

	public static CreateEmployeePOJO getUserDataToAdd() {
		
		addUser = new CreateEmployeePOJO();
		addUser.setName("pratibha");
		addUser.setSalary(1000);
		addUser.setAge(33);

		return addUser;
	}



}
