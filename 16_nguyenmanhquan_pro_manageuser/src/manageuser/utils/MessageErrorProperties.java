/**
 * Copyright(C) 2020 Luvina Software
 * MessageErrorProperties.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Mô tả: Đọc các thông tin về các câu thông báo lỗi của hệ thống
 * 
 * @author Nguyễn Mạnh Quân
 */
public class MessageErrorProperties {
	/**
	 * Phương thức đọc thông tin Message Error theo key
	 * @param key là thông tin cần đọc
	 * @return giá trị của key
	 * @throws IOException 
	 */
	public static String getMessageError(String key) throws IOException {
		String result = "";
		Properties properties = new Properties();
		InputStream inputStream = MessageErrorProperties.class.getResourceAsStream(Constant.PROPERTIES_MESSAGE_ERROR_PATH);
		InputStreamReader inputStreamReader;
		try {
		    inputStreamReader = new InputStreamReader(inputStream, "utf8");
		    properties.load(inputStreamReader);
		} catch (IOException e) {
			System.out.println("MessageErrorProperties: getMessageError: " + e.getMessage());
			throw e;
		}
		
		result = properties.getProperty(key);

		return result;
	}

}
