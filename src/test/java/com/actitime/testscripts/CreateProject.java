package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.utilities.ExcelUtility;
import com.actitime.webpages.ActiveProjectsAndCustomersPage;
import com.actitime.webpages.AddNewProjectPage;
import com.actitime.webpages.OpenTasksPage;




public class CreateProject extends Baseclass
{
@Test
public void testCreateProject() throws EncryptedDocumentException, IOException
{
	String customername = ExcelUtility.readData("Sheet2", 1, 0);
	String projectname = ExcelUtility.readData("Sheet2", 1, 1);
	String exp = ExcelUtility.readData("Sheet2", 1, 2);
	OpenTasksPage otp=new OpenTasksPage();
	otp.clickOnProjectAndCustomerLink();
	ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
	apcp.clickOnaddNewProjectBuutton();
	AddNewProjectPage anpp=new AddNewProjectPage();
	anpp.selectCustomerFromDropdown(customername);
	anpp.enterProjectName(projectname);
	anpp.clickOncreateProjectButton();
	String act = apcp.retrieveSucessMessage();
	System.out.println(act);
	ExcelUtility.writeData("Sheet2", 1, 3, act);
    Assert.assertTrue(false);
	if(exp.equals(act))
    {
		ExcelUtility.writeData("Sheet2", 1, 4, "pass");

    }
    else
    {
    	ExcelUtility.writeData("Sheet2", 1, 4, "fail");

    }

}
}
