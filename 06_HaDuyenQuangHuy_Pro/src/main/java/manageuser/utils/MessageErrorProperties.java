/**
 * Copyright(C) 2020 Luvina Software
 * LoginController.java, 15/07/2020 HaDuyenQuangHuy
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class MessageErrorProperties: Xử lý đọc message trong messageErrorProperties
 *
 * @author Ha Duyen Quang Huy
 */
public class MessageErrorProperties {
	// lÆ°u cÃ¡c cáº·p <key, value> trong file properties
	private static Map<String, String> mapDBProperties = new HashMap<String, String>();
	static String Link = "\\manageuser\\utils\\properties\\MessageErrorProperties.properties";
	static {
		try {
			// táº¡o Ä‘á»‘i tÆ°á»£ng kiá»ƒu Properties
			Properties properties = new Properties();
			// Ä‘á»�c file properties
			properties.load(
					new InputStreamReader(MessageErrorProperties.class.getClassLoader().getResourceAsStream(Link), "UTF-8"));
			// lÆ°u cÃ¡c giÃ¡ trá»‹ key trong file properties
			Enumeration<?> enumeration = properties.propertyNames();
			// true náº¿u váº«n cÃ²n pháº§n tá»­, false náº¿u táº¥t cáº£ pháº§n tá»­ Ä‘Ã£ Ä‘Æ°á»£c láº¥y ra
			while (enumeration.hasMoreElements()) {
				// key = key tiáº¿p theo
				String key = (String) enumeration.nextElement();
				// láº¥y value tÆ°Æ¡ng á»©ng vá»›i key
				String value = properties.getProperty(key);
				// thÃªm vÃ o list
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

