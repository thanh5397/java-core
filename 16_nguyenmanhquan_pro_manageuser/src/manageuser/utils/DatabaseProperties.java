/**
 * Copyright(C) 2020 Luvina Software
 * DatabaseProperties.java, 13/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Mô tả: Đọc các thông tin thiết định kết nối tới database
 * 
 * @author Nguyễn Mạnh Quân
 */
public class DatabaseProperties{
	/**
	 * Phương thức đọc thông tin DB theo key
	 * @param key là thông tin cần đọc
	 * @return giá trị của key
	 * @throws IOException 
	 */
	public static String getDatabaseProperties(String key) throws IOException{
		String result = "";
		Properties properties = new Properties();
		InputStream inputStream = DatabaseProperties.class.getResourceAsStream(Constant.PROPERTIES_DATABASE_PATH);
		InputStreamReader inputStreamReader;
		try {
		    inputStreamReader = new InputStreamReader(inputStream, "utf8");
		    properties.load(inputStreamReader);
		} catch (IOException e) {
			System.out.println("DatabaseProperties: getDatabaseProperties: " + e.getMessage());
		    throw e;
		}
		result = properties.getProperty(key);
		return result;
	}
}
