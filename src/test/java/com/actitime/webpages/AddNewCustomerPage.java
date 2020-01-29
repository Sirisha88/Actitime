package com.actitime.webpages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.testscripts.Baseclass;

public class AddNewCustomerPage
{
	@FindBy(name="name")
	private WebElement customerNameTextField;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomerButton;
	
	public static Logger log;
	public AddNewCustomerPage()
	{
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void enterCustomerName(String customername)
	{
		customerNameTextField.sendKeys(customername);
		log.info("----------customer name is entered-----------");

	}
	public void clickOncreateCustomerButton()
	{
		createCustomerButton.click();
		log.info("----------clicked on createcustomer button-----------");

	}
}
