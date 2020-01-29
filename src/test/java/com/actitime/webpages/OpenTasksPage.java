package com.actitime.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.testscripts.Baseclass;


public class OpenTasksPage 
{
	@FindBy(linkText="Projects & Customers")
	private WebElement projectAndCustomerLink;
	@FindBy(linkText="Settings")
	private WebElement settingsLink;
	
	public static Logger log;
	public OpenTasksPage()
	{
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void clickOnProjectAndCustomerLink()
	{
		projectAndCustomerLink.click();
		log.info("----------clicked on Projectsandcustomers link-----------");
	}
	public void clickOnSettingsLink()
	{
		settingsLink.click();
		log.info("----------clicked on Settings link-----------");

	}
}
