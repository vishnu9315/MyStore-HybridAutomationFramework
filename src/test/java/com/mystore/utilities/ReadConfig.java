package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	String path = "C:\\Users\\AB COM\\eclipse-workspace\\MyStoreV1\\configuration\\config.properties";
	
	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fs = new FileInputStream(path);
			properties.load(fs);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getUrl() {
		String url = properties.getProperty("baseUrl");
		
		if(url != null) {
			return url;
		}else {
			throw new RuntimeException("Url not found in Config file"); 
		}
		
	}
	public String getBrowser() {
		String url = properties.getProperty("browser");
		
		if(url != null) {
			return url;
		}else {
			throw new RuntimeException("Browser not found in Config file"); 
		}
		
	}

} 
