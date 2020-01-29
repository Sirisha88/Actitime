package com.actitime.webpages;

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
	
	public BillingTypePage()
	{
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void clickOnAddNewBillingTypeButton()
	{
		addNewBillingTypeButton.click();
	}
	public String retrieveSucessMessage()
	{
		String s=successMessage.getText();
		return s;
	}
}
