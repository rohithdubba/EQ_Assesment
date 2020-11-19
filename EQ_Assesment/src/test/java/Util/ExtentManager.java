package Util;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

private static ExtentReports extent;
	
	public static ExtentReports getinstance()
	{
		
		if(extent==null)
		{
		extent = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\Extentreport.html",true,DisplayOrder.OLDEST_FIRST);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ReportsConfig.xml"));
		}
		
		return extent;
	}
	
}
