/**
 * Copyright(C) 2020  Luvina software
 * ConfigProperties.java, Jul 20, 2020 HuyHDQ
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Xử lý đọc message trong config properties
 * 
 * @author Ha Duyen Quang Huy
 */
public class ConfigProperties {
	private static Map<String, String> mapDBProperties = new HashMap<String, String>();
	static String Link = "\\manageuser\\utils\\properties\\ConfigProperties.properties";
	static {
		try {
			Properties properties = new Properties();
			properties.load(
					new InputStreamReader(ConfigProperties.class.getClassLoader().getResourceAsStream(Link), "UTF-8"));
			Enumeration<?> enumeration = properties.propertyNames();
			while (enumeration.hasMoreElements()) {
				String key = (String) enumeration.nextElement();
				String value = properties.getProperty(key);
				mapDBProperties.put(key, value);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lấy value tương ứng với key trong file properties
	 * 
	 * @param key: key trong file properties
	 * @return giá trị value tương ứng với key
	 */
	public static String getValueByKey(String key) {
		String value = mapDBProperties.get(key);
		return value;
	}

}
