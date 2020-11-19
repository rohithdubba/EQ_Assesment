package Util;


	import com.relevantcodes.extentreports.LogStatus;
	import java.io.IOException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import Base.Base_class;
	import Util.ExtentManager;
	
	

	public class CustomListeners extends Base_class  implements ITestListener{

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
	        test = rep.startTest(result.getName().toUpperCase());	
			System.out.println("******Testcase" +result.getName()+ " Execution started********");
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
	     test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASSED SUCCESSFULLY");
		 System.out.println(result.getName()+" success");
			rep.endTest(test);
			rep.flush();
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception "+result.getThrowable());
			System.out.println(result.getName()+" failed");
			rep.endTest(test);
			rep.flush();
		
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			System.out.println("***********Test Cases execution started****************");
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		}
