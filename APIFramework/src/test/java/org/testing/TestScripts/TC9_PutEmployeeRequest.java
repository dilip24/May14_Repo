package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ResponseValidate;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadFile;
import org.testing.utilities.LoadJsonFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC9_PutEmployeeRequest {
	@Test
	public void testcase9() throws IOException {
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		String jsonBody=LoadJsonFile.jsonData("../APIFramework/src/test/java/org/testing/resources/updateemployeerequestpayload.json");
		
		
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.PutEmpRequest(jsonBody,"EmployeeUpdate_URI");
		
		System.out.println("******Test Case 9********");
		System.out.println("Status Code is "+response.statusCode());
		System.out.println("Response data is ");
		System.out.println(response.asString());
		
		ResponseValidate.statusCodeValidate(response, 200);
		ResponseValidate.DataValidate(response, "Tiger Nixon", "employee_name");
		
	}
}
