package com.inetbanking.utilities;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub	
		
        extent.flush();
    }		

    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub	
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm");
    	String ts=sdf.format(new Date(5));
    	String repname="TestReport"+ts+".html";
    	System.out.println(repname);
    	htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/test-output/"+repname));




    	
//    	String repname="TestReport.html";
//    	htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repname);
    	
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml");
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("user", "deepthi");
			htmlReporter.config().setDocumentTitle("Inetbanking project");
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setReportName("QA Automation Report");
			htmlReporter.config().setTheme(Theme.STANDARD);
		 

        		
    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult tr) {					
        // TODO Auto-generated method stub	
    	
    	logger=extent.createTest(tr.getName());
    	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd-hh-ss");
    	String s=sdf.format(new Date(1));
    	
    	String img = tr.getName()+s+".png";
    	System.out.println(img);
    	String screenshotname=System.getProperty("user.dir")+"/src/test/resources/Screenshots/"+img;
    	File file=new File(screenshotname);
    	try {
			logger.addScreenCaptureFromPath(screenshotname, "login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }		

    public void onTestSkipped(ITestResult tr) {					
        // TODO Auto-generated method stub	
    	
    	logger=extent.createTest(tr.getName());
    	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
        		
    }		

    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub		
    	        		
    }		

    public void onTestSuccess(ITestResult tr) {					
        // TODO Auto-generated method stub				
        		logger=extent.createTest(tr.getName());
        		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }		
	
	

}
