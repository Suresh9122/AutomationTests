package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.dtcc.practicess.Demo;
import com.dtcc.practicess.Table;

public class Tablepractice {
	static Table rock = new Table();
	
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 
		props.load(file);
	
		
		String url = props.getProperty("TableURL");
		try {
			
				
			rock.drivergetURL(url);
			rock.kawkaw();
			
		
			String kaki = rock.Data();
			System.out.println(kaki);
			
			HashMap<String,String> Dataa = rock.getTableData();
			System.out.println(Dataa);
		
		List date = rock.getWebTableData();
		System.out.println("sghs"+date);
		}catch(Exception e) {
				e.printStackTrace();
			}
			}
		
	

}
