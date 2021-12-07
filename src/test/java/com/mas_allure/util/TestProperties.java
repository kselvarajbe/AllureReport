package com.mas_allure.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.mas_allure.context.Constants;

/**
 * The Class has all TestProperties (All properties mentioned in
 * <strong>test.properties</strong> file).
 *
 */
public class TestProperties {

	/** The Constant props. */
	private static final Properties props = new Properties();

	/**
	 * Load all propertie.
	 */
	public static void loadAllPropertie() {
//		try {
//			FileInputStream Locator;
//			Locator = new FileInputStream(Constants.PROPERTY_FILE_PATH);
//			props.load(Locator);
//		} catch (IOException e) {
//			LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
//		}
//	}

	try {
		String configFileName = "-test.properties";
		String EnvironmentName = System.getProperty("TestEnvironment");
		System.out.println("TestEnvironment: " + EnvironmentName);

		String name = Constants.PROPERTY_FILE_PATH+EnvironmentName+configFileName;
			System.out.println(name);
		FileInputStream Locator;
		Locator = new FileInputStream(name);
		props.load(Locator);
	     } catch (IOException e) {
		LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * Put property.
	 *
	 * @param key   the key
	 * @param value the value
	 */
	public static void putProperty(String key, String value) {
		props.put(key, value);
	}
}
