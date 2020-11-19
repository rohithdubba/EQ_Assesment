package Base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Testcases.Contact_us_Test;
import Util.ExcelReader;
import Util.ExtentManager;




public class Base_class 
{
	public  static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports rep = ExtentManager.getinstance();
	public static ExcelReader excel=new ExcelReader(
			System.getProperty("user.dir")+"\\src\\test\\resources\\testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static void initialization()
	{
	
		String browsername	=Constants.browser;
	
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");	
		driver=new ChromeDriver();
		log.info("**************Browser Launched !!!*****************");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.url);
		driver.manage().window().maximize();
	
	}	

	}

	
}
