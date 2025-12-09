package extentReportUtility;

import java.awt.Desktop;
import java.io.IOException;
import java.io.File;
import org.testng.annotations.*;

import com.ReadingDataFromPDFExcel.driver;

public class Basetest extends driver {
	
	@BeforeSuite
	public void setUPReport() throws IOException {
		
		ExtentReportsdemo.initReport();
		System.out.println("Extent Report Intialized");
		
	}
	
	@AfterSuite
	public void tear() throws Exception {
		ExtentReportsdemo.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
