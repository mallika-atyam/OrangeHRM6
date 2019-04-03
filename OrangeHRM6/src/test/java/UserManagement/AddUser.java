//import MercuryDemoTours;

package  UserManagement;
import org.testng.annotations.Test;

import CommonUtil.*;
import HTMLReport.TestHTMLReporter6;
import ExcelUtil.ExcelApiTest3;
import Login.Login;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.*;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;
/*
 Openbrowser
 openurL
 login
 AddUser 
 logout
 */

 
public class AddUser
{
	public String UserName,Password;
	public String userrole,empname,username,status,pass1,pass2,fname,mname,lname;
	
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void AddUser(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	//*
	@Test(priority=1)
	public  void Addmem( )throws Exception
	{  	
		AddEmp1 AE=new AddEmp1();
		AE.AddEmp_datadriventest();
	}

	@Test(priority=2)
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 //int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1");
			// System.out.println("User name is|||||||||"+numberowsInputdata);
			 
				for(int i=1;i<2;i++)
				 {	
					 UserName="ADMIN";
					 Password="admin123";	 
					 //UserName=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,0);
					 //Password=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_jobtitle.xls","Sheet1",i,1);
					 
					 userrole=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1",i,2);
					 empname=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1",i,3);
					 username=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1",i,4);
					 status=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1",i,5);
					 pass1=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1",i,6);
					 pass2=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_useradd.xls","Sheet1",i,7);
							 
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 System.out.println(" userrole is "+userrole);
					 System.out.println(" empname is "+empname);
					 System.out.println(" username is "+username);
					 System.out.println(" status is "+status);
					 System.out.println(" pass1 is "+pass1);
					 System.out.println(" pass2 is "+pass2);
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 System.out.println("out of for loop in datadriventest");
	 
			// driver.quit();
			 
	}

	
	public   void call_allmethods(int iRow )throws Exception
	{  
			
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_jobtitle_ADD" + str,"Chrome");
		 
		 			
		if (iRow==1)
		{
		
		driver=TestBrowser.OpenChromeBrowser();
		//HtmlOutputFileName= TH3.CretaeHTMLFile("TC01 Add Employee","Chrome");
		
		Login l1=new Login();
		l1.Login(driver ,HtmlOutputFileName,TH3);
	
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		
		 TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		l1.OrangeHRMSigninClick();

			}
				
		AddUser AU =new AddUser();
		AU.AddUser(driver, HtmlOutputFileName, TH3);
		AU.AddingUsers(iRow,userrole,empname,username,status,pass1,pass2);
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		driver.quit();
	}	
	
	public   void AddingUsers(int iRow,String userrole,String empname,String username,String status,String pass1,String pass2)throws Exception
	{  
		
		System.out.println("reached here");
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.Admin_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 driver.findElement(By.xpath(OR.ADMIN_USERMANAGEMENT_focus)).click();
		 TH3.HTMLScreenShot("ADMIN_USERMANAGEMENT_focus highlight","ADMIN_USERMANAGEMENT_focus highlighted Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 
		 driver.findElement(By.xpath(OR.ADMIN_USERS_click)).click();
		 TH3.HTMLScreenShot("USERS clicked","USERS clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_user_add)).click();
		 TH3.HTMLScreenShot("Jobtitle clicked","Jobtitle clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 System.out.println(" username in add "+username);
		 System.out.println(" empname is add"+empname);
		 System.out.println(" userrole is add "+userrole);
		
		 Select listbox =new Select(driver.findElement(By.xpath(OR.ADMIN_adduser_userrole)));
		 listbox.selectByVisibleText(userrole);
		 TH3.HTMLScreenShot("Enter userrole","userrole Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_adduser_empname)).sendKeys(empname);
		 TH3.HTMLScreenShot("Enter empname","empname Succefully Entered","Pass", HtmlOutputFileName,driver);
		
		 driver.findElement(By.xpath(OR.ADMIN_adduser_username)).sendKeys(username);
		 TH3.HTMLScreenShot("Enter username","username Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Select listbox1 =new Select(driver.findElement(By.xpath(OR.ADMIN_adduser_status)));
		 listbox1.selectByVisibleText(status);
		 TH3.HTMLScreenShot("Enter status","status Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_adduser_pass1)).sendKeys(pass1);
		 //TH3.HTMLScreenShot("Enter password","password Succefully Entered","Pass", HtmlOutputFileName,driver);
		 driver.findElement(By.xpath(OR.ADMIN_adduser_pass2)).sendKeys(pass1);
		 //Thread.sleep(5000);
		 Actions actions2 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele2=driver.findElement(By.xpath(OR.ADMIN_adduser_save));
			 actions2.moveToElement(ele2).click().build().perform();
			 
		 
		// driver.findElement(By.xpath(OR.ADMIN_adduser_save)).click();
		 Thread.sleep(5000);
		 TH3.HTMLScreenShot("Enter status","status Succefully Entered","Pass", HtmlOutputFileName,driver);
		
		 Thread.sleep(5000);
		 Actions actions1 = new Actions(driver);   
			System.out.println("reached here1");
			 WebElement ele1=driver.findElement(By.xpath(OR.Admin_focus));
			 actions1.moveToElement(ele1).click().perform();
			 
			 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
			 System.out.println("reached here2");
			 
			 driver.findElement(By.xpath(OR.ADMIN_USERMANAGEMENT_focus)).click();
			 TH3.HTMLScreenShot("ADMIN_USERMANAGEMENT_focus highlight","ADMIN_USERMANAGEMENT_focus highlighted Succefully ","Pass", HtmlOutputFileName,driver);
			 
			
		 driver.findElement(By.xpath(OR.ADMIN_USERS_click)).click();
		 Thread.sleep(5000);
		TH3.HTMLScreenShot("USERS clicked","USERS clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
					 
	}
	
	@BeforeTest
    public void suiteSetup1() throws Exception {
		
		 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
		 String xlsFileSheet="Sheet1";
		 
		 ExcelApiTest3 eat = new ExcelApiTest3();
		 eat.clearsheetdata(xlsFile,xlsFileSheet);
		 	 
    }  	
	
	@AfterTest
  
    public void AftersuiteSetup2() throws Exception {
		 
		 TestHTMLReporter6 TH4 = new TestHTMLReporter6();	
		 TH4.Regression_CretaeHTMLFile();
		 
		 
		
		
    }
			
	
}