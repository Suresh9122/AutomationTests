package com.ReadingDataFromPDFExcel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    public static ExtentReports extent;
    public static ExtentTest test1;

    @BeforeSuite
    public void setupReport() {
        // HTML report will be created at this path
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Suresh");
    }

	/*
	 * @BeforeMethod public void startTest(Method method) { // Each test method will
	 * have one test node in report test1 = extent.createTest(method.getName()); }
	 */

    @AfterMethod
    public void updateResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                test1.pass("Test passed");
                break;
            case ITestResult.FAILURE:
                test1.fail(result.getThrowable());
                break;
            case ITestResult.SKIP:
                test1.skip("Test skipped");
                break;
        }
    }

    @AfterSuite
    public void tearDown() {
        extent.flush(); // Very important – writes the report to file
    }
}



