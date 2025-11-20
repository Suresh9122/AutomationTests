package com.dtcc.practicess;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsdemo {
	public static WebDriver driver =  new ChromeDriver();
	
	public static ExtentReports ExtentReportManager = new ExtentReports();
	public static  ExtentSparkReporter rockk = new ExtentSparkReporter("report.html");
	
	//public static logMe logger;
	public static void extent() throws IOException {
		// ExtentReports extent = new ExtentReports();
		// line 1 we using absolute path
		// ExtentSparkReporter rockk1 = new ExtentSparkReporter("C:\\Suresh\\com.dtcc\\src\\test\\resources\\Reports\\reports.html");
		
		 ExtentSparkReporter rockk = new ExtentSparkReporter("report.html");
		
			
			  ExtentTest test1 = ExtentReportManager.createTest("Test 1");
			  test1.pass("this is pass");
			  
			  ExtentTest test2 = ExtentReportManager.createTest("Test 2");
			  test2.log(Status.FAIL, "This is fail");
			  
			  ExtentTest test3 =
			  ExtentReportManager.createTest("Test 3").skip("This is skipped");
			 
			 
		ExtentReportManager.attachReporter(rockk);
		ExtentReportManager.flush();
	//	 Desktop.getDesktop().browse(new File("report.html").toURI());
		
	}
	
	public static void Rockk() throws IOException {
		
	extent();
	ExtentTest test1 = ExtentReportManager.createTest("Test 1");
	test1.pass("this is pass");
	
	ExtentTest test2 = ExtentReportManager.createTest("Test 2");
	test2.log(Status.FAIL, "This is fail");
	
	ExtentTest test3 = ExtentReportManager.createTest("Test 3").skip("This is skipped");
	
	
	//ExtentReportManager.createTest("Test 1").log(Status.INFO, "log in ayya ra pukaa");
	
	 Desktop.getDesktop().browse(new File("report.html").toURI());
	
	
	
		
		
		
		
		
		
	}

}
