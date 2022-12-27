package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clickonsubmit();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		captureScreenshost(driver,"logintest");
		Assert.fail();
	}

}
