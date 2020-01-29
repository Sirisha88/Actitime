package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actitime.utilities.ExcelUtility;
import com.actitime.webpages.AddNewBillingTypePage;
import com.actitime.webpages.BillingTypePage;
import com.actitime.webpages.OpenTasksPage;



public class CreateBill
{
	@Test
public void testCreateBill() throws EncryptedDocumentException, IOException
{
		String billname =  ExcelUtility.readData("Sheet3", 1, 0);
		String exp =  ExcelUtility.readData("Sheet3", 1, 1);
		OpenTasksPage otp=new OpenTasksPage();
		otp.clickOnSettingsLink();
		BillingTypePage btp=new BillingTypePage();
		btp.clickOnAddNewBillingTypeButton();
		AddNewBillingTypePage anbp=new AddNewBillingTypePage();
		anbp.enterBillingTypename(billname);
		anbp.clickOnCreatebillingTypebutton();
		String s=btp.retrieveSucessMessage();
		System.out.println(s);
		ExcelUtility.writeData("Sheet3", 1, 2, s);

		if(exp.equals(s))
	      {
			ExcelUtility.writeData("Sheet3", 1, 3, "pass");

	      }
	      else
	      {
	    	  ExcelUtility.writeData("Sheet3", 1, 3, "fail");

	      }
		
		

	}
}

