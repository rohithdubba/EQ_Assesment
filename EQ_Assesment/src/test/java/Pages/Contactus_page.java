package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.Base_class;

public class Contactus_page extends Base_class {

	@FindBy(xpath=("//button[@class='rounded-button text-brand-primary bg-white rounded-button--sm text-sm mb-3']"))
	WebElement cookie_accept;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailadd;	
	
	@FindBy(xpath="//div[@class='tablet:half']/select")
	WebElement Province;	
	
	@FindBy(xpath="//input[@placeholder='Please enter your city']")
	WebElement city;
	
	@FindBy(xpath="//textarea[@placeholder='Please describe the issue you are having here...']")
	WebElement inquiry;
	
	@FindBy(xpath="//button[text()='Contact Support']")
	WebElement contactsupportbtn;
	
	@FindBy(xpath="//a[@class='mt-4 tablet:mt-0  tablet:pl-8 text-brand-link cursor-pointer']")
	WebElement cancelbtn;
	
	@FindBy(xpath="//footer [@class = 'w-full flex flex-col align-center items-center font-medium tablet:w-auto tablet:inline-flex tablet:flex-row']/button")
	WebElement submit;
	
	@FindBy(xpath="//h3[contains(text(),'Send us a message')]")
	WebElement val_msg;
	
	public  Contactus_page()
	{
		PageFactory.initElements(driver, this);
	}
	public void page_validation()
	{
		String actual_url= driver.getCurrentUrl();
		Assert.assertEquals(actual_url,"https://eqcare.com/en/contact-us/support","url validation");
		log.info("**********The url is valid**********");
		
		String actual_title= driver.getTitle();
		Assert.assertEquals(actual_title,"Contact our Support Team","Title  validation");
		log.info("********The title is valid***********");
		
		
	}
	public void form_submssion_withdata(String arg0,String arg1,String arg2,String arg3,String arg4,String arg5,String arg6) throws InterruptedException
	{ 
		
		((JavascriptExecutor) driver).executeScript("window. scrollBy(0,550)","");
		
		cookie_accept.click();
		firstname.sendKeys(arg0);
		lastname.sendKeys(arg1);
		phonenumber.sendKeys(arg2);
		emailadd.sendKeys(arg3);
		Select sel= new Select(Province);
		sel.selectByVisibleText(arg4);
		city.sendKeys(arg5);
		inquiry.sendKeys(arg6);
		contactsupportbtn.click();
		
}
	
	public void form_submssion_withoutdata(String arg0,String arg1,String arg2,String arg3,String arg4,String arg5,String arg6) throws InterruptedException
	{
		
		Thread.sleep(5000);
		contactsupportbtn.click();
		List<String>exp= new ArrayList<String>();
		exp.add("The first name field is required");
		exp.add("The last name field is required");
		exp.add("The work email field is required");
		exp.add("Please select a province");
		exp.add("The city field is required");
	    exp.add("Please tell us a bit about your inquiry");
		
		List<WebElement>ls= driver.findElements(By.className("form-error"));
log.info("The Number of error messages displayed are :" + ls.size());
		
		for(int i=0;i<ls.size();i++)
		{
			for(int j=0;j<exp.size();j++)
			{
				if(ls.get(i).getText().equalsIgnoreCase(exp.get(j)))
				{
					Assert.assertEquals(ls.get(i).getText(), exp.get(j),"Error Message validation");	
					
					log.info("The contact_us_support form is not submitted correctly and error message is  " +ls.get(i).getText() );
					
				}
			}
			
		}
		
		
		exp.clear();
	}





}
