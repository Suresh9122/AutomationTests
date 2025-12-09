package com.ReadingDataFromPDFExcel;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReportUtility.Basetest;
import extentReportUtility.ExtentReportsdemo;

public class driver {
	//static ExtentTest ExtentReport = ExtentReportManager.createTest("Test 1");
	
	public static WebDriver driver;
	//static WebDriver driver = new ChromeDriver() ;
	
	
	
	@BeforeClass
	public void setUP() throws IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
	
}
