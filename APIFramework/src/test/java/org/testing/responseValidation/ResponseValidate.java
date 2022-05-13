package org.testing.responseValidation;

import org.testing.utilities.ParsingJsonUsingJsonPath;
import org.testing.utilities.ParsingJsonUsingOrgJson;

import io.restassured.response.Response;

public class ResponseValidate
{
	public static void statusCodeValidate(Response res,int expectedStatusCode)
	{
		int actualStatusCode=res.statusCode();
		if (actualStatusCode==expectedStatusCode)
		{
			System.out.println("Status code is matching");
		}
		else
		{
			System.out.println("Status code is not matching");
		}
	}
	
	public static void DataValidate(Response res,String expectedData,String jsonPaath)
	{
		System.out.println("Expected data is "+expectedData);
		String actualData=ParsingJsonUsingJsonPath.parseJsonPath(res, jsonPaath);
		System.out.println("Actual data is "+actualData);
		
		if(expectedData.equals(actualData))
		{
			System.out.println("Data is matching");
		
		}
		else
		{
			System.out.println("Data is not matching");
		}
	}

}
