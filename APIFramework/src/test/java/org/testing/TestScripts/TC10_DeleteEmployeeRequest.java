package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ResponseValidate;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC10_DeleteEmployeeRequest 
{
	@Test
	public  void testcase10() throws IOException
	{
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.DeleteEmpRequest("DeleteEmployee_URI");
		
		System.out.println("********Test Case10********");
		System.out.println("Status code is "+response.statusCode());
		System.out.println("response data is");
		System.out.println(response.asString());
		
		ResponseValidate.statusCodeValidate(response, 200);
	}
}

