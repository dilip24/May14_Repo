package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ResponseValidate;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadFile;
import org.testing.utilities.ParsingJsonData;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC8_GetAllEmployeeRequest
{
	@Test
	public void testcase8() throws IOException
	{
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.getAllRequest("EmployeeGetAll_URI");
		
		System.out.println("*********Test Case8*********");
		System.out.println("Status code is "+response.statusCode());
		System.out.println("response data is");
		System.out.println(response.asString());
		
		ResponseValidate.statusCodeValidate(response, 200);
		ResponseValidate.DataValidate(response, "Garrett Winters", "data[1].employee_name");
	}
}
