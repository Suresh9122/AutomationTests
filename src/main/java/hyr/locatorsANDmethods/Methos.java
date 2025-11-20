package hyr.locatorsANDmethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.com.driver;

public class Methos extends driver{
	
	locators locator = new locators();
	public static JavascriptExecutor js =  (JavascriptExecutor)driver;


	public void clickWebTable() {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("")))
		.moveToElement(null);
	}
	
	public void downToWebTable() {
		
	WebElement table =	locator.getTable();
	js.executeScript("arguments[0].scrollIntoView(true);", table);
	
	}
	
	public  List<Map<String,String>> getTableData(){
			
			List<Map<String,String>> table = new ArrayList<Map<String,String>>();
			
			List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id='contactList']/tbody//tr//th"));
			List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='contactList']//tbody//tr/td"));
			try {
				for(int i=1;i<=tableData.size();i++) {
					HashMap<String,String> rock = new HashMap<String,String>();
					for (int j=1;j<= tableHeader.size();j++) {
						String key = driver.findElement(By.xpath("//table[@id='contactList']/tbody//tr//th["+j+"]")).getText().trim();
						
						String value = driver.findElement(By.xpath
								
							("//table[@id='contactList']//tbody//tr["+i+"]/td["+j+"]")).getText().trim();
					rock.put(key, value)	;
					System.out.println("Table====" +rock);
					
					}
					table.add(rock);
				
				}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ErrorMsg=1111===" +e);
		
			
		}
		
		
			return table;
	}

}
