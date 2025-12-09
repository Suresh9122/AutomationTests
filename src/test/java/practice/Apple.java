package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.dtcc.practicess.Demo;

public class Apple {
static Demo rock = new Demo();
	
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 
		props.load(file);
	
		
		String url = props.getProperty("Apple");
		
		rock.drivergetURL(url);
		
	}

}
