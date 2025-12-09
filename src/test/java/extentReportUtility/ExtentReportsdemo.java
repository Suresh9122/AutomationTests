package extentReportUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ReadingDataFromPDFExcel.driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsdemo {
	
	private static ExtentReports extent;
	
	

	public static void initReport() throws IOException {
		// ExtentReports extent = new ExtentReports();
		// line 1 we using absolute path
		// ExtentSparkReporter rockk1 = new ExtentSparkReporter("C:\\Suresh\\com.dtcc\\src\\test\\resources\\Reports\\reports.html");
		if(extent == null) {
		 ExtentSparkReporter rockk = new ExtentSparkReporter("report.html");
		
		 extent = new ExtentReports(); 
		 extent.attachReporter(rockk);
		}
		//ExtentReportManager.flush();
	//	 Desktop.getDesktop().browse(new File("report.html").toURI());
		
	}

	
	
	public static ExtentTest createTest(String testName) {
		return extent.createTest(testName);
		
	}
	
	 
	public static void flush() {
		if(extent !=null) {
			extent.flush();
		}
	}
	
	
	
	
	/*
	 * @BeforeTest public static void Rockk() throws IOException { extentReport();
	 * 
	 * ExtentReportManager.createTest("Test 1").log(Status.INFO,
	 * "Test Execution Started");
	 * 
	 * ExtentTest test2 = ExtentReportManager.createTest("Test 2");
	 * test2.log(Status.PASS, "This is Pass");
	 * 
	 * }
	 * 
	 * 
	 * @AfterSuite public void tearDown() throws Exception {
	 * 
	 * ExtentReportManager.flush(); // Very important – writes the report to file
	 * Desktop.getDesktop().browse(new File("report.html").toURI());
	 * 
	 * }
	 */
}
