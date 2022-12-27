package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Selenium']")
	WebElement seleniumLink;
	
	@FindBy(xpath="//a[text()='Insurance Project']")
	WebElement insuranceProjectLink;
	
	@FindBy(xpath="//a[text()='Bank Project']")
	WebElement bankProjectLink;
	
	
	public void clickonseleniumlink()
	{
		seleniumLink.click();
	}
	
	public void clickonInsuranceProjectLink()
	{
		insuranceProjectLink.click();
	}
	
	public void clickOnbankProjectLink()
	{
		bankProjectLink.click();
	}

}
