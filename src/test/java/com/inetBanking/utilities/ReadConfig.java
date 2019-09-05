package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class ReadConfig {
	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The Exception is : " + e.getMessage());
		}

	}

	public String getApplicationURL() {

		String url = prop.getProperty("baseURL");
		System.out.println("URL : " + url);
		return url;		
	}

	public String getUserName() {

		String username = prop.getProperty("userName");
		return username;
	}

	public String getPassword() {

		String password = prop.getProperty("password");
		return password;
	}

	public String getChromepath() {

		String chromepath = prop.getProperty("chromepath");
		System.out.println("Chrome path : " + chromepath);
		return chromepath;
	}
	
	public String getIepath() {

		String iepath = prop.getProperty("iepath");
		return iepath;
	}
	
	public String getFiefoxpath() {

		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}



}
