package com.actitime.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.testscripts.Baseclass;

																																														
public class ActiveProjectsAndCustomersPage 
{
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement addNewCustomerButton;
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement addNewProjectButton;
	@FindBy(className="successmsg")
	private WebElement successMessage;
	
	public static Logger log;
	public ActiveProjectsAndCustomersPage()
	{
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void clickOnaddNewCustomerButton()
	{
		addNewCustomerButton.click();
		log.info("----------clicked on addnewcustomer button-----------");

	}
	public void clickOnaddNewProjectBuutton()
	{
		addNewProjectButton.click();
		log.info("----------clicked on addnewproject button-----------");

	}
	public String retrieveSucessMessage()
	{
		String s=successMessage.getText();
		log.info("----------success message is retrieved-----------");
		return s;
	}

}
