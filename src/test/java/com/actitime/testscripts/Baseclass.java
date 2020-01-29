
package com.actitime.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class Baseclass 
{
	public static WebDriver driver;//declaration
	@BeforeTest
	public void openBrowser() throws IOException
	{
		//step1: open file in Read mode
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/App.properties");
		//step2: create object of properties class to call load()
	    Properties p1=new Properties();
		p1.load(fis);
		String browser = "chrome";
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(p1.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	@BeforeClass
	public void login() throws IOException
	{
		//step1: open file in Read mode
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/App.properties");
		//step2: create object of properties class to call load()
		Properties p1=new Properties();
		p1.load(fis);
		driver.findElement(By.name("username")).sendKeys(p1.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(p1.getProperty("password"));
		driver.findElement(By.xpath("//input[@valign='absmiddle']")).click();
	}
	@AfterClass
	public void logout()
	{
	    driver.findElement(By.className("logoutImg")).click();

	}
}
