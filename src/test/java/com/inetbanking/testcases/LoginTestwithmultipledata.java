package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.ExcelReader;

public class LoginTestwithmultipledata extends BaseClass {
	
	@Test(dataProvider="logindetails")
	public void loginDDT(String un,String pw) throws InterruptedException, IOException
	{	driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.setusername(un);
		lp.setpassword(pw);
		lp.clickonsubmit();
		Thread.sleep(5000);
		System.out.println("title is"+driver.getTitle());
		captureScreenshost(driver,"logintest");
	}
	
	@DataProvider(name="logindetails")
	String[][] getData() throws IOException
	{
		String filepath=System.getProperty("user.dir")+"/src/test/resources/testdata.xlsx";
		int rownum=ExcelReader.getRowCount(filepath, "Sheet1");
		System.out.println(rownum);
		int colcount=ExcelReader.getCellCount(filepath, "Sheet1", 1);
		System.out.println(colcount);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelReader.getCellValue(filepath, "Sheet1", i, j);
				System.out.println(	logindata[i-1][j]);
			}
		}
		return logindata;
	}

}
