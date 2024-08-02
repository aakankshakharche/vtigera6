package com.crm.JavaUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class VtigerJavaUtility {

	public static String loginData(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Vtiger.Properties");
		prop.load(fis);
		String data = prop.getProperty(key);		
		return data;
	}
}
