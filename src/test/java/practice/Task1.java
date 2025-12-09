package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ReadingDataFromPDFExcel.BaseTest;
import com.ReadingDataFromPDFExcel.ExcelDataSupplier;
import com.ReadingDataFromPDFExcel.driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReportUtility.Basetest;
import extentReportUtility.ExtentReportsdemo;
import locatorsANDmethods.Demo;
import locatorsANDmethods.Table;


public class Task1 extends Basetest{
	//static Table rock1 = new Table();
	
	static Demo rock = new Demo();
	static ExcelDataSupplier rocky = new ExcelDataSupplier();

	int mapValueENV=0;


	@Test(enabled = true)
	public void TC01() throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 

		props.load(file);
		String url = props.getProperty("Movie_URL");

		try {

			rock.launchURL(url);
			List<Map<String,String>> Data = rock.getData();
			//	System.out.println(Data);

			rock.verifyValues(Data, Data);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
