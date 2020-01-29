package com.actitime.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actitime.testscripts.Baseclass;

public class AddNewProjectPage
{
	@FindBy(name="customerId")
	private WebElement customerDropdown;
	@FindBy(name="name")
	private WebElement projectrNameTextField;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectrButton;
	
	public static Logger log;
	public AddNewProjectPage()
	{
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void selectCustomerFromDropdown(String customername)
	{
		Select s1=new Select(customerDropdown);
		s1.selectByVisibleText(customername);
		log.info("----------customername is selected-----------");

	}
	public void enterProjectName(String customername)
	{
		projectrNameTextField.sendKeys(customername);
		log.info("----------project name is entered-----------");

	}
	public void clickOncreateProjectButton()
	{
		createProjectrButton.click();
		log.info("----------clicked on CreateProject button-----------");

	}
}
