package org.testing.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParsingJsonData 
{
	public static void parseJsonData(String responseData,String keyname)
	{
		JSONArray js=new JSONArray(responseData);
		for (int i=0;i<js.length();i++)
		{
			JSONObject j=new JSONObject(i);
			System.out.println(j.get(keyname));
		}
	}
}
