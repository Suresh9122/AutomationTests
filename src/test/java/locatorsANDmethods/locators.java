package locatorsANDmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ReadingDataFromPDFExcel.driver;

public class locators extends driver {
	
	private By WebTable = By.xpath("//table[@id='customers']");
	
	
	public WebElement DemoWebTable() {
		return driver.findElement(WebTable);
		
	}

}
