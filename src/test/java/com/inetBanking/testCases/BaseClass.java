package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;
	
	//System.getProperty gives the path of your project
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) {
		
		if (browser.equals("chrome")) {			
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",readConfig.getChromepath());
		driver = new ChromeDriver();
		}
		
		else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIepath());
			driver = new InternetExplorerDriver();
		}
		
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFiefoxpath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		//LoginPage lp = new LoginPage(driver);
		logger.info("URL Opeded");
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randomeNum() {
		String generatedNum = RandomStringUtils.random(9);
		return generatedNum;
	}
}
