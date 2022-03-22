package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public static HttpUtil of (BufferedReader reader) {
		StringBuilder json = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpUtil(json.toString());
	}
	
	public <T> T toModel (Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
