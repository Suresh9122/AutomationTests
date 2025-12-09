package locatorsANDmethods;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.ReadingDataFromPDFExcel.driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import extentReportUtility.Basetest;
import extentReportUtility.ExtentReportsdemo;





public class Demo extends Basetest {

 //static ExtentTest test = ExtentReportsdemo.createTest("Data Comparsion");

	static Basetest extent = new Basetest();
	public static JavascriptExecutor rr =  (JavascriptExecutor)driver;
	public static ExtentReports ExtentReportManager = new ExtentReports();
//static AppWaiter waitTym = new AppWaiter();
	AppWaiter appWaiter;
	locators xpath;

	//xpaths
	private By googleSear = By.xpath("//textarea[@class='gLFyf']");
	private By header = By.xpath("//table[@class='wikitable sortable jquery-tablesorter'][1]//thead/tr/th");
	private By mobilebutton = By.xpath("//div[@class='_2GaeWJ']//img[@alt='Mobiles']");
	private By ElectronicButton = By.xpath("(//span[@class='TSD49J'])[1]");
	private By text = By.xpath("(//input[@type='text'])[2]");

	//public static void setUp() {
	//System.setProperty("webdriver.chrome.driver", "C:\\Suresh\\com.dtcc\\src\\test\\resources\\chromeDriver\\chromedriver.exe");
	// driver = new ChromeDriver();
	//}

	@BeforeClass
	public void setUP() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

	public void launchURL(String url) throws Exception {
		ExtentTest test = ExtentReportsdemo.createTest("Test 1");

		test.log(Status.INFO, "Test Execution Started in Task1");
		test.log(Status.PASS, "Chrome Launched Successfully");

		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public void waits() {
		appWaiter.waitUntilElementVisible(xpath.DemoWebTable());	
	
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
	



	public void enterGoogle() throws InterruptedException {

		Thread.sleep(2000);

		/*
		 * WebElement rockk =driver.findElement(googleSear);
		 * rockk.sendKeys("list of tollywood movies 2024"); rockk.sendKeys(Keys.ENTER);
		 */
		JavascriptExecutor rr= (JavascriptExecutor)(driver);
		rr.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();

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

	public List<Map<String,String>> getData(){

		List<Map<String,String>> Rock = new ArrayList<Map<String,String>>();

		List<WebElement> header = driver.findElements(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter'][1]//thead/tr/th)[position()>1]"));
		List<WebElement> tabledata = driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter'][1]/tbody/tr/td"));

		try {
			Thread.sleep(2000);
			JavascriptExecutor rr= (JavascriptExecutor) driver;
			rr.executeScript("window.scrollBy(0,700)", "");

			for(int i=1;i<=tabledata.size();i++) {
				HashMap<String,String> rockk = new HashMap<String,String>();	

				for(int j=1;j<=header.size();j++) {
					String key = driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter'][1]//thead/tr/th)[position()>1]["+j+"]"))
							.getText().trim().replace(".", "");
					if(key.contains("Ref")) {
						continue;
					}
					String value = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter'][1]/tbody/tr["+i+"]/td["+j+"]"))
							.getText().trim().replace(",", "");	
					rockk.put(key, value);
				}

				Rock.add(rockk);
			}


		}catch(Exception e) {
			e.printStackTrace();
		}



		return Rock;


	}



	public void Mobiles() throws InterruptedException {
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(mobilebutton).click();
		//Thread.sleep(2000);
		//	waitIM();
		//Actions rock = new Actions(driver);

		//rock.moveToElement(driver.findElement(By.xpath("(//div[@class='bpjkJb']/span)[1]"))).click().perform();
		//rock.moveToElement(driver.findElement(By.xpath("//div[@class='wZsanD']/a[@title='Realme']"))).click().perform();
		/*
		 * JavascriptExecutor rocky = (JavascriptExecutor)(driver);
		 * rocky.executeScript("scrollBy(0,700)", ""); Thread.sleep(2000);
		 */
		WebElement rokk =driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		rokk.sendKeys("Realme mobiles");
		rokk.sendKeys(Keys.ENTER);



	}

	public String getData1() {

		String kaki = driver.findElement
				(By.xpath("(//div[@class='_6NESgJ']/ul[1]/li[@class='J+igdf'][3])[1]//text()")).getText().trim();

		return kaki;


	}

	public HashMap<String,String> getDattaa(){

		HashMap<String,String> ro = new HashMap<String,String>();
		List<WebElement> data = driver.findElements
				(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[3]/ul/li"));


		try {	
			for(int i=1;i<=data.size();i++) {

				String key = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[3]/ul/li["+i+"]"))
						.getText().trim();
				ro.put("rock", key);

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ro;


	}

	public void Hyr () throws InterruptedException {
		try {
			JavascriptExecutor rr = (JavascriptExecutor)driver;
			rr.executeScript("scrollBy(0,400)", "");

			Thread.sleep(3000);

			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("(//button[@class='whButtons'])[1]")).click();

			Set<String> child = driver.getWindowHandles();
			ArrayList<String> windows = new ArrayList(driver.getWindowHandles());

			for(String rockk : windows) {

				if (!rockk.equals(parentWindow)) {
					driver.switchTo().window(windows.get(1));
					driver.manage().window().maximize();

					rr.executeScript("scrollBy(0,700)", "");
					Thread.sleep(17000);
					driver.switchTo().window(windows.get(0));
					//	driver.switchTo().defaultContent();
					Thread.sleep(3000);
					//driver.quit();
				}

			}



		}catch(Exception  e) {
			e.printStackTrace();
		}

	}
	public void multiSelectDropDown() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		WebElement ee = driver.findElement(By.xpath("//select[@id='ide']"));
		Select s = new Select(ee);
		s.selectByIndex(1);
		s.selectByValue("vs");
		Thread.sleep(2000);
		s.deselectByValue("vs");



	}



	public void singledropDown() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//select[@id='course']"));
		Select s = new Select(element);
		s.selectByIndex(1);
		Thread.sleep(2000);
		s.selectByValue("python");
		Thread.sleep(2000);
		s.selectByVisibleText("Javascript");


	}

	public HashMap<String,String> getAppleData(){
		HashMap<String,String> rock = new HashMap<String,String>();

		String Key = driver.findElement(By.xpath("//h3[text()='iPhone Air  ']")).getText();
		String value=driver.findElement(By.xpath("//span[text()='₹119900.00']")).getText();

		rock.put(Key, value);
		return rock;
	}


	public Demo verifyValues(List<Map<String,String>> Data ,List<Map<String,String>> Data1) {
		ExtentTest test = ExtentReportsdemo.createTest("Data Comparsion");

		for(Map<String,String> map : Data1) {
			for(Map<String,String> map1 : Data) {

				for(String keystr : map.keySet()) {
					
					String data1 = map1.get(keystr);
					String data2 = map.get(keystr);

					if(data1 !=null) {

						if(data2.equals(data1)) {

							test.pass("The Value for " +keystr+ " in Data1 is : "
							      +data1+ " in Data2 : " +data2+ " Values are matches");

						}else {
							test.fail("The Value for " +keystr+ " in Data1 is : " 
									+data1+ " in Data 2 : " +data2+ " Values not matches");
						}

					}
				}
			}
		}

		return this;

	}

	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
