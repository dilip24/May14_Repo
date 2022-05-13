package org.testing.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParsingJsonUsingOrgJson 
{
	public static String parseJson(String responseData,String keyname)
	{
		JSONObject js=new JSONObject(responseData);
		return js.getString(keyname);
	}
	
	public static void parseJsonData(String responseData,String keyname)
	{
		JSONArray js=new JSONArray(responseData);
		for(int i=0;i<js.length();i++)
		{
			JSONObject js1=js.getJSONObject(i);
		System.out.println(js1.get(keyname));
		}				
	}

}
