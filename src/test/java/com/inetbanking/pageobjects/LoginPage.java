package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(name="SubmitLogin")
	WebElement submitBtn;
	
	
	public void setusername(String username)
	{
		email.sendKeys(username);
	}
	
	public void setpassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	
	public void clickonsubmit()
	{
		submitBtn.click();
	}

}
