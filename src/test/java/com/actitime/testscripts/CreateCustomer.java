package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actitime.utilities.ExcelUtility;
import com.actitime.webpages.ActiveProjectsAndCustomersPage;
import com.actitime.webpages.AddNewCustomerPage;
import com.actitime.webpages.OpenTasksPage;


public class CreateCustomer extends Baseclass
{
@Test
public void testCreateCustomer() throws EncryptedDocumentException, IOException
{
	String customername = ExcelUtility.readData("Sheet1", 1, 0);
	String exp = ExcelUtility.readData("Sheet1", 1, 1);
	
	OpenTasksPage otp=new OpenTasksPage();
	otp.clickOnProjectAndCustomerLink();
	ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
	apcp.clickOnaddNewCustomerButton();
	AddNewCustomerPage ancp=new AddNewCustomerPage();
	ancp.enterCustomerName(customername);
	ancp.clickOncreateCustomerButton();
	String act = apcp.retrieveSucessMessage();
	System.out.println(act);
	ExcelUtility.writeData("Sheet1", 1, 2, act);

	if(exp.equals(act))
    {
		ExcelUtility.writeData("Sheet1", 1, 3, "pass");

    }
    else
    {
    	ExcelUtility.writeData("Sheet1", 1, 3, "fail");

    }
}
}
