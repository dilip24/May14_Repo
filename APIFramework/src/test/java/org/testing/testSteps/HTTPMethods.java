package org.testing.testSteps;
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
		.body(JSONRequestBody)
		.when()
		.post(pr.getProperty(uriKey));
		
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

