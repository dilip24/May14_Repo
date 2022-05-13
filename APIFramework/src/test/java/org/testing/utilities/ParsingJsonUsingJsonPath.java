package org.testing.utilities;

import io.restassured.response.Response;

public class ParsingJsonUsingJsonPath
{
	public static String parseJsonPath(Response res,String jsonPathh)
	{
		return res.jsonPath().get(jsonPathh);
	}
}
