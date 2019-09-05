package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//  demo.guru99.com	
//	User ID :	mngr26593
//	Password :	abc@123

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement lnkLogout;

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);		
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);		
	}

	public void clickLogin() {
		btnLogin.click();		
	}
	
	public void clkLogout() {
		lnkLogout.click();
	}
	
	
	
	
}
