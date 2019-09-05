package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close invalid user window
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Assert.assertFalse(false);
			logger.warn("Login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login Pass");
			lp.clkLogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();//close logout window
			driver.switchTo().defaultContent();			
		}	
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
			
			int rowCount  = XLUtils.getRowCount(path,"Sheet1");
			int cellCount = XLUtils.getCellCount(path,"Sheet1",1);
			String loginData[][] = new String[rowCount][cellCount];
			for (int i=1;i<=rowCount;i++) {
				for(int j=0;j<cellCount;j++) {
					loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				}
			}return loginData;			
		
	}

}
