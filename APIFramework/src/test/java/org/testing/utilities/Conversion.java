package org.testing.utilities;

import org.json.JSONObject;
import org.json.XML;

public class Conversion 
{
	public static String convertXmltoJson(String xmlData)
	{
		JSONObject js = XML.toJSONObject(xmlData);
		System.out.println(js.toString());
		return js.toString();
	}
	
	public static String convertJsontoXml(String Json)
	{
		JSONObject obj = new JSONObject(Json);
		String xmlData =XML.toString(obj);
		return xmlData;
	}

}
