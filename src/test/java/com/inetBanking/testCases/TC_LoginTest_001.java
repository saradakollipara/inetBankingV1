package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void LoginTest() {
				
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickLogin();
		System.out.println("Title : " + driver.getTitle());
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")){
			
			
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else 
		{
			Assert.assertFalse(false);
			logger.info("Login test failed");
		
		}
			
		
	}

}
