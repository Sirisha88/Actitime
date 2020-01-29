package com.actitime.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.testscripts.Baseclass;


public class BillingTypePage
{
	@FindBy(xpath="//input[@value='Add New Billing Type']")
	private WebElement addNewBillingTypeButton;
	@FindBy(className="successmsg")
	private WebElement successMessage;
	
	public static Logger log;
	public BillingTypePage()
	{
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void clickOnAddNewBillingTypeButton()
	{
		addNewBillingTypeButton.click();
		log.info("---------clicked on add new billtype button----------");
	}
	public String retrieveSucessMessage()
	{
		String s=successMessage.getText();
		System.out.println(s);
		log.info("-----------Success mesage is retrived-------------");
		return s;
	}
}
