package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	public static Properties property;
	
	
	/**
	 * 
	 * @param url take a path to the file as a parameter. 
	 * @return property
	 */
	public static Properties readConfigProperties(String url) {
		
		
		try {
			FileInputStream fis = new FileInputStream(url);
			property = new Properties();
			property.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return property;
		
	}

	/**
	 * 
	 * @param key take key as a parameter
	 * @return value of provided key
	 */
	public static String getProperty(String key) {
		
		return property.getProperty(key);
		
	}

}
