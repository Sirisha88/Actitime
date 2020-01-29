package com.actitime.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.testscripts.Baseclass;


public class AddNewBillingTypePage
{
	@FindBy(name="name0")
	private WebElement billingTypenameTextfield;
	@FindBy(xpath="//input[@value='Create Billing Type(s)']")
	private WebElement createbillingTypebutton;
	
	public static Logger log;
	public AddNewBillingTypePage()
	{
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void enterBillingTypename(String billname)
	{
		billingTypenameTextfield.sendKeys(billname);
		log.info("------------Billname is entered--------------");
	}
	public void clickOnCreatebillingTypebutton()
	{
		createbillingTypebutton.click();
		log.info("------------Clicked on create billing type button-----------");
	}
}
