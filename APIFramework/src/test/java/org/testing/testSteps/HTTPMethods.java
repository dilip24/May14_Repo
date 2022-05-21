package org.testing.testSteps;
import java.util.HashMap;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

//fetch of URI Values
//To fetch URI Values require properties object
public class HTTPMethods 
{
	Properties pr;
	public HTTPMethods(Properties pr)
	{
		this.pr=pr;
	}

	public Response PostRequest(String JSONRequestBody,String uriKey)
	{		
		Response res=
		given()
		.contentType(ContentType.JSON)
		//.header(headerName, headerValue) //multiple .header needs to be used for multiple instances
		.body(JSONRequestBody)
		.when()
		.post(pr.getProperty(uriKey));
		
		return res;
	}
	
	public Response PostRequestHeader(String JSONRequestBody,String uriKey)
	{
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Key1", "Value1");
		headers.put("Key2", "Value2");
		headers.put("Key3", "Value3");
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.headers(headers)
		//.header(headerName, headerValue) //multiple .header needs to be used for multiple instances
		.when()
		.post(pr.getProperty(uriKey));
		
		System.out.println(res.getHeader(""));
		System.out.println(res.getHeaders());
		
		return res;
	}
	
	public Response getRequest(String uriKey, String idvalue)
	{
		String base=pr.getProperty(uriKey);
		String uri=base+"/"+idvalue;
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uri);
		
		
		return res;
	}
	
	public Response getEmpRequest(String uriKey)
	{
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(pr.getProperty(uriKey));
		
		
		return res;
	}

	public Response getAllRequest(String uriKey)
	{
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(pr.getProperty(uriKey));
		
		
		return res;
	}
	public Response PutRequest(String JSONRequestBody,String uriKey,String pathParameter)
	{
		String uri=pr.getProperty(uriKey)+"/"+pathParameter;
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(JSONRequestBody)
		.when()
		.put(uri);
		
		return res;
	}
	
	public Response PutEmpRequest(String JSONRequestBody,String uriKey)
	{
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(JSONRequestBody)
		.when()
		.put(pr.getProperty(uriKey));
		
		return res;
	}
	
	public Response DeleteRequest(String uriKey, String idvalue)
	{
		String base=pr.getProperty(uriKey);
		String uri=base+"/"+idvalue;
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete(uri);
		
		
		return res;
	}
	
	public Response DeleteEmpRequest(String uriKey)
	{
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete(pr.getProperty(uriKey));
		
		
		return res;
	}		
}

