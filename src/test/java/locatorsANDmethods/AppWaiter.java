package locatorsANDmethods;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ReadingDataFromPDFExcel.driver;


public class AppWaiter extends driver{

	

	public void waitUntilElementIsClickable(WebElement element) {
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(14));
		  
		//ji
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementVisible(WebElement element) {

	
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(14));
		
        wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilPageToLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(14));
		
		wait.until(pageLoadCondition);
	
	}
	
	public void waitUntilElementVisible(WebElement element,long time) {
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(14));
		
	        wait.until(ExpectedConditions.visibilityOf(element));
		}
}
