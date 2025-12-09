package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.*;


import com.dtcc.practicess.Table;

import locatorsANDmethods.Demo;

public class Tablepractice {
	
	
	static Demo rock = new Demo();
	
	@Test
	public void TC02() throws Exception {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 
		props.load(file);
	
		
		String url = props.getProperty("TableURL");
		try {
			
				
			rock.launchURL(url);
			
			
			HashMap<String,String> Dataa = rock.getTableData();
			System.out.println(Dataa);
		
		//List date = rock.getWebTableData();
		//System.out.println("sghs"+date);
		
		}catch(Exception e) {
				e.printStackTrace();
			}
			}
		
	

}
