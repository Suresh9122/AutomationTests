package driver.com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driver {
	
	public static WebDriver driver =  new ChromeDriver();
	
	public void waitIM() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
