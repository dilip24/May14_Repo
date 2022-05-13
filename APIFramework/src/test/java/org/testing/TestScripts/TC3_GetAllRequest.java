package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ResponseValidate;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadFile;
import org.testing.utilities.ParsingJsonData;
import org.testing.utilities.ParsingJsonUsingOrgJson;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC3_GetAllRequest
{
	@Test
	public  void testcase3() throws IOException
	{
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.getAllRequest("QA_URI");
		
		System.out.println("********Test Case3********");
		System.out.println("Status code is "+response.statusCode());
		System.out.println("response data is");
		System.out.println(response.asString());
		ParsingJsonUsingOrgJson.parseJsonData(response.asString(), "id");
		
		
		ResponseValidate.statusCodeValidate(response, 200);
		ResponseValidate.DataValidate(response, "General Manager", "APITesting[0].Designation");
		
			}

}
