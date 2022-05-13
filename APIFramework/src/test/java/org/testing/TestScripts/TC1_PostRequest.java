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

public class TC1_PostRequest 
{
	static String respIdValue;
	@Test
	public  void testcase1() throws IOException {
		Properties pr=LoadFile.loadProperties("../APIFramework/URI.properites");
		String jsonBody=LoadJsonFile.jsonData("../APIFramework/src/test/java/org/testing/resources/requestpayload.json");
		Random ran=new Random(); //Random class to generate randon number
		Integer idvalue=ran.nextInt();
		jsonBody=VariableReplacement.replaceValue(jsonBody, "id", idvalue.toString());
		//System.out.println("Please enter first name");
		//Scanner s=new Scanner(System.in);
		//String firstname=s.next();
		//jsonBody=VariableReplacement.replaceValue(jsonBody, "firstname", firstname);
		
		HTTPMethods http=new HTTPMethods(pr);
		Response response=http.PostRequest(jsonBody,"QA_URI");
		
		System.out.println("******Test Case 1********");
		System.out.println("Status Code is "+response.statusCode());
		System.out.println("Response data is ");
		System.out.println(response.asString());
		respIdValue=ParsingJsonUsingOrgJson.parseJson(response.asString(),"id");
		
		ResponseValidate.statusCodeValidate(response, 201);
	}

}
