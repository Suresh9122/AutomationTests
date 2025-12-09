package hyr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.dtcc.practicess.Demo;

//import hyr.locatorsANDmethods.Methos;

public class webTable {
	static Demo rock = new Demo();
	//static Methos me = new Methos();
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\config\\TestData.properties";
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(filepath); 
		props.load(file);
	
		
		String url = props.getProperty("Hyr");
		
		try {
			rock.drivergetURL(url);
		//	me.downToWebTable();
			//List<Map<String,String>> kaki = me.getTableData();
		//	System.out.println(kaki);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ErrorMsg====" +e);
		}
	}
}
