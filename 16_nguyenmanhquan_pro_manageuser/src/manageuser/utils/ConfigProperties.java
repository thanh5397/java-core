/**
 * Copyright(C) 2020 Luvina Software
 * ConfigProperties.java, 17/07/2020 Nguyễn Mạnh Quân
 */
package manageuser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Mô tả: Đọc các thông tin về config của dự án
 * @author Nguyễn Mạnh Quân
 */
public class ConfigProperties {
	/**
	 * Phương thức đọc thông tin config theo key
	 * @param key là thông tin cần đọc
	 * @return giá trị của key
	 * @throws IOException 
	 */
	public static String getConfigProperties(String key) throws IOException{
		String result = "";
		Properties properties = new Properties();
		InputStream inputStream = ConfigProperties.class.getResourceAsStream(Constant.PROPERTIES_CONFIG_PATH);
		InputStreamReader inputStreamReader;
		try {
		    inputStreamReader = new InputStreamReader(inputStream, "utf8");
		    properties.load(inputStreamReader);
		} catch (IOException e) {
			System.out.println("ConfigProperties: getConfigProperties: " + e.getMessage());
		    throw e;
		}
		result = properties.getProperty(key);
		return result;
	}
}
