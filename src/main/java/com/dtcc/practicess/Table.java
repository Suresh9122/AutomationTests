package com.dtcc.practicess;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Table {

	public static WebDriver driver= new ChromeDriver();
	
	 public static WebDriverWait wait = new WebDriverWait(driver, null);
	 public static JavascriptExecutor toScroll =  (JavascriptExecutor)driver;
	
	public void drivergetURL(String url) {
		try {
		driver.manage().window().maximize();
		 HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		    connection.setRequestMethod("HEAD");
		    int responseCode = connection.getResponseCode();

		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        driver.get(url);
		        wait.until(ExpectedConditions.urlContains(url));
		       // WaitForPageLoad.waitForUrlToLoad(driver, "https://example.com", 10);
		    } else {
		        System.out.println("URL not accessible. Skipping...");
		    }
		} catch (Exception e) {
		    System.out.println("Exception occurred while checking URL: " + e.getMessage());
		
		
		}	

}
	
	public void kawkaw() throws InterruptedException {
		
	Thread.sleep(9000);	
	
	//JavascriptExecutor r = (JavascriptExecutor)driver;
	toScroll.executeScript("scrollBy(0,700)", "");
	System.out.println("Scrolldown");	
	
		
	}
	
	public String Data() {
		
		
		String rock = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[2]")).getText().trim();
		
		String[] table= rock.split(" ");
	String result = Arrays.toString(table);
	
	
		System.out.println("Scrollup");
		
		return result;
		
		
	}
	
	public HashMap<String,String> getTableData(){
		
			HashMap<String,String> rock = new HashMap<String,String>();
			try {
			List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
			
			for(int i=1;i<=3;i++) {
			String key = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr/th["+i+"]")).getText().trim();
			String value = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr/td["+i+"]")).getText().trim();
			
			rock.put(key, value);
		
			}
		}catch(Exception e) {
			e.printStackTrace();
		
		}

	
		return rock;
	
}
	public  List<Map<String,String>> getWebTableData(){
		
		List<Map<String,String>> rr = new ArrayList<Map<String,String>>();
		
		List<WebElement> header = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th/span"));

		List<WebElement> data = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td/span"));
		try {
			for(int i=2;i<=data.size();i++) {
				HashMap<String,String> rock = new HashMap<String,String>();
				for(int j=1;j<=header.size();j++) {
					String key = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr/th["+j+"]/span")).getText();
					String value = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]/span")).getText().trim();
				
				rock.put(key, value);
				}
				rr.add(rock);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return rr;
		
		
	}
	
	
}
