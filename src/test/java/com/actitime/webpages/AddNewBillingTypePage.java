package com.actitime.webpages;

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
	
	public AddNewBillingTypePage()
	{
		PageFactory.initElements(Baseclass.driver, this);
	}
	public void enterBillingTypename(String billname)
	{
		billingTypenameTextfield.sendKeys(billname);
	}
	public void clickOnCreatebillingTypebutton()
	{
		createbillingTypebutton.click();
	}
}
