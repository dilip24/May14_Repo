package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ResponseValidate;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC5_DeleteRequest
{
	@Test
	public void testcase5() throws IOException
	{
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.DeleteRequest("QA_URI",TC1_PostRequest.respIdValue);
		
		System.out.println("********Test Case5*********");
		System.out.println("Status code is "+response.statusCode());
		System.out.println("response data is");
		System.out.println(response.asString());
		
		ResponseValidate.statusCodeValidate(response, 200);
	}
}
