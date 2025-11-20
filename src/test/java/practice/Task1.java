package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dtcc.practicess.Demo;



public class Task1  {
	
	static Demo rock = new Demo();
	
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 
		props.load(file);
	
		
		String url = props.getProperty("Movie_URL");
		
		try {
	//public void Tc01 (HashMap<String,String[]> map ){
		
	rock.drivergetURL(url);
	
	//rock.enterGoogle();
List<Map<String,String>> Data = rock.getData();
System.out.println(Data);
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	
	 

}
