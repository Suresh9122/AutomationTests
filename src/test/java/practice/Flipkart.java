package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.dtcc.practicess.Demo;

public class Flipkart {
	
static Demo rock = new Demo();

	
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 
		props.load(file);
	
		
		String url = props.getProperty("flip");
	
		 
		try {
			
			
	
		
	rock.drivergetURL(url);
	rock.Mobiles();
	/*
	 * HashMap<String,String> Data= rock.getDattaa(); System.out.println(Data);
	 */
	
	String rock11 = rock.getData1();
	System.out.println(rock11);
	
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
}
