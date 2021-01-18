package com.globallogic.model;

import java.util.HashMap;
import java.util.Map;

public class Response
{
	private String text;
	private Map<String,Object> customProperties = new HashMap<>();//future enhancements

	public Response(String text) 
	{
		this.text = text;
	}

	public String getText() 
	{
		return text;
	}

	public Map<String, Object> getCustomProperties() {
		return customProperties;
	}

	public void setCustomProperties(Map<String, Object> customProperties) {
		this.customProperties = customProperties;
	}
}
