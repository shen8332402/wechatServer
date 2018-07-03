package org.frame.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * 
 * @author shentt
 * @date 2018年7月2日
 * @className PropertiesUtils.java
 * @param 
 * @Description 读取properties配置文件工具类
 */
public class PropertiesUtils {
	/**
	 * 读取配置文件
	 * 
	 * @param resource
	 * @return Properties
	 */
	private static Properties loadProperties(String resource) {
		Properties properties = new Properties();
		try {
			properties.load(ConfigUtils.getResourceAsStream(resource));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return properties;
	}

	/**
	 * 获取配置文件属性
	 * 
	 * @return Properties
	 * 
	 */
	public static Properties getProperties(String resource) {
		return loadProperties(resource);
	}

	/**
	 * 获取配置文件属性值
	 * 
	 * @param key
	 * @return String
	 * 
	 */
	public static String getProperty(String resouce, String key) {
		String tmp = "";
		Properties properties = loadProperties(resouce);
		tmp = properties.getProperty(key);
		return tmp;
	}

	/**
	 * 获取配置文件属性值
	 * 
	 * @param properties
	 * @return String
	 * 
	 */
	public static String getProperty(Properties properties, String key) {
		String tmp = "";
		tmp = properties.getProperty(key);
		return tmp;
	}
}