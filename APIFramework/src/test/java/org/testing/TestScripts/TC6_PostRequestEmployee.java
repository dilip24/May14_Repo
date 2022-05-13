package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.testing.responseValidation.ResponseValidate;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadFile;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.ParsingJsonUsingOrgJson;
import org.testing.utilities.VariableReplacement;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC6_PostRequestEmployee 
{
	@Test
		public  void testcase6() throws IOException {
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		String jsonBody=LoadJsonFile.jsonData("../APIFramework/src/test/java/org/testing/resources/employeepayload.json");
		
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.PostRequest(jsonBody,"Employee_URI");
		
		System.out.println("******Test Case6********");
		System.out.println("Status Code is "+response.statusCode());
		System.out.println("Response data is ");
		System.out.println(response.asString());
		
		ResponseValidate.statusCodeValidate(response, 200);
		
	}

}
