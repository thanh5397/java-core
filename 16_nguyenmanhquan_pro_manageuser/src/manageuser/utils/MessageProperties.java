/**
 * Copyright(C) 2020 Luvina Software
 * MessageProperties.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Mô tả: Đọc các thông tin về các câu thông báo, của hệ thống
 * 
 * @author Nguyễn Mạnh Quân
 */
public class MessageProperties {
	/**
	 * Phương thức đọc thông tin Message theo key
	 * @param key là thông tin cần đọc
	 * @return giá trị của key
	 * @throws IOException 
	 */
	public static String getMessageProperties(String key) throws IOException{
		String result = "";
		Properties properties = new Properties();
		InputStream inputStream = MessageProperties.class.getResourceAsStream(Constant.PROPERTIES_MESSAGE_PATH);
		InputStreamReader inputStreamReader;
		try {
		    inputStreamReader = new InputStreamReader(inputStream, "utf8");
		    properties.load(inputStreamReader);
		} catch (IOException e) {
			System.out.println("MessageProperties: getMessageProperties: " + e.getMessage());
		    throw e;
		}
		result = properties.getProperty(key);
		return result;
	}
}
