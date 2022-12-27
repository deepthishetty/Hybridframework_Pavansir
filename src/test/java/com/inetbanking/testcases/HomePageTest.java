package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.HomePage;
import com.inetbanking.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	
	@Test
	public void verifyHomePage() throws InterruptedException, IOException
	{
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clickonsubmit();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		captureScreenshost(driver,"logintest");
		hp.clickonseleniumlink();
		Thread.sleep(5000);
		
		System.out.println("title is"+driver.getTitle());
		

}
	
	@Test
	public void verifyhomPage() throws InterruptedException, IOException
	{
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clickonsubmit();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		captureScreenshost(driver,"logintest");
		hp.clickOnbankProjectLink();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		

}
	@Test
	public void verifyhomPage1() throws InterruptedException, IOException
	{
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clickonsubmit();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		captureScreenshost(driver,"logintest");
		hp.clickonInsuranceProjectLink();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		
		

}
}
