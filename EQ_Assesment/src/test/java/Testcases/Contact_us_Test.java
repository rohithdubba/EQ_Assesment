package Testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.AssertJUnit;
import java.util.Hashtable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Base.Base_class;
import Pages.Contactus_page;

import Util.Utilities;

public class Contact_us_Test extends Base_class 
{

	Contactus_page obj;

	@BeforeMethod
	public void init()
	{
		initialization();
		obj= new Contactus_page();
	}
	
	
	@Test
	public void pagevalidation()
	{
	 obj.page_validation();
	}

	
	@Test(dataProviderClass=Utilities.class,dataProvider="datareader")
	public void contact_form_validation(Hashtable<String,String> data) throws InterruptedException 
	{
		try {
			
		obj.form_submssion_withdata(data.get("First Name"),data.get("Last Name"),data.get("Phone Number"),data.get("Email address"),data.get("Province"),data.get("City"),data.get("Inquiry"));
		String expct_confirm_msg="Your message was sent.";
		log.info("the expected msg is "+expct_confirm_msg);
		WebElement msg=driver.findElement(By.xpath("//h3[contains(text(),'Your message was sent.')]"));		
		String act_cnfirm_msg=	msg.getText();
		log.info("the actual msg is "+act_cnfirm_msg);
		Assert.assertEquals(act_cnfirm_msg, expct_confirm_msg,"Contact Form validation");
		log.info("**************successfully submitted the contact_us_support form*******************");	
		
		}
		catch(Exception e)
		{
			obj.form_submssion_withoutdata(data.get("First Name"),data.get("Last Name"),data.get("Phone Number"),data.get("Email address"),data.get("Province"),data.get("City"),data.get("Inquiry"));
			log.info("********successfully validated  error messages************");	
		}
					
	}
	@AfterMethod
	public void Teardown()
	{
		driver.close();
	}
	
	}
			