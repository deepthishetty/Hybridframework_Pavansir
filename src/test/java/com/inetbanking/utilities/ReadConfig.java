package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop=new Properties();
	
	public ReadConfig() 
	
	{
		
		try {
			FileInputStream fis=new FileInputStream(new File("src\\test\\resources\\configuration\\Config.properties"));
			prop.load(fis);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readconfigvalue(String key)
	{
		return prop.getProperty(key);
	}

}
