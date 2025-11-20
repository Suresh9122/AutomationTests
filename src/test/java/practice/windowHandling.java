package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import com.dtcc.practicess.Demo;

public class windowHandling {

	
	static Demo rock = new Demo();
	//static String rock ="";
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties prop = new Properties();
		FileInputStream rockk = new FileInputStream(filepath);
		prop.load(rockk);
		
		String url = prop.getProperty("WindowHandle");
		
		try {
			
			rock.drivergetURL(url);
			rock.Hyr();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
