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
 Search on Username,Userrole and empname
 logout
 */

 
public class name_role_empSearch
{
	public String UserName,Password,name,role,empname;
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void name_role_empSearch(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	/*
	@Test
	public  void DelJobTitle( )throws Exception
	{  
		DeleteJobTitle AL=new DeleteJobTitle();
		AL.Data_driven_test();
	}
	
	
	
	@Test(priority=2)
	*/
	@Test
	public  void Data_driven_test( )throws Exception
	{  
		

		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet1");

				 for(int i=1;i<numberowsInputdata;i++)
				 {		 
					 UserName="ADMIN";
					 Password="admin123";
					 name=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet1",i,2);
					 role=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet1",i,3);
					 empname=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet1",i,4);
					 
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 System.out.println(" Username is "+name);
					 System.out.println(" Userrole is "+role);
					 System.out.println(" Empname is "+empname);
						
					 iRow=i;
					 call_allmethods(iRow);
				 }

				 
			 driver.quit();
	}

	
	public   void call_allmethods(int iRow )throws Exception
	{  
	
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_username_search" + str,"Chrome");
	
		 			
		if (iRow==1)
		{
		
		driver=TestBrowser.OpenChromeBrowser();
				
		Login l1=new Login();
		l1.Login(driver ,HtmlOutputFileName,TH3);
	
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		
		 TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		l1.OrangeHRMSigninClick();
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.Admin_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 
		 driver.findElement(By.xpath(OR.UserManagement_focus)).click();
		 TH3.HTMLScreenShot("usermanagement focus highlight","usermanagement focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_USERS_click)).click();
		 TH3.HTMLScreenShot("users","users clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 

		
		}
		
		
		name_role_empSearch nre =new name_role_empSearch();
		nre.name_role_empSearch(driver, HtmlOutputFileName, TH3);
		
		
		Boolean r1=false;
		r1=nre.variousSearch(name, role, empname);
		if(r1==true)	 
		{
			System.out.println("YES username,role and empname found");
			
		}
		 else
		  {
			 System.out.println("No-record found");
		  }
			  
		 
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		//driver.quit();
			}	
	
	public   Boolean variousSearch(String name,String role,String empname)throws Exception
	{  
		
		Boolean Record_Present=false;
		System.out.println("reached here");
				
		/*Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=driver.findElement(By.xpath(OR.Admin_focus));
		 actions.moveToElement(ele).click().perform();
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 
		 driver.findElement(By.xpath(OR.UserManagement_focus)).click();
		 TH3.HTMLScreenShot("usermanagement focus highlight","usermanagement focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_USERS_click)).click();
		 TH3.HTMLScreenShot("users","users clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 */
		driver.findElement(By.xpath(OR.ADMIN_reset_btn)).click();
		
		 driver.findElement(By.xpath(OR.ADMIN_username)).sendKeys(name);
		 TH3.HTMLScreenShot("Enter user name","username Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Select listbox =new Select(driver.findElement(By.xpath(OR.ADMIN_userrole)));
		 listbox.selectByVisibleText(role);
		 TH3.HTMLScreenShot("Enter user role","userrole Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_empname)).sendKeys(empname);
		 TH3.HTMLScreenShot("Enter user name","username Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 
		    List  columns = driver.findElements(By.xpath(OR.ADMIN_COLUMNS_click)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        //No.of rows
	        String rowscount="//*[@id='resultTable']/tbody/tr/td[2]";
	        List  rows = driver.findElements(By.xpath(rowscount)); 
	        System.out.println("No of rows are : " + rows.size());
	      
	     
	        
	        			ExcelApiTest3 eat = new ExcelApiTest3();
	         
	        			  for ( int i=1 ; i<=rows.size() ;i++)
	  				    {
	  				      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[2]";
	  				        WebElement CellText1=driver.findElement(By.xpath(str1));
	  				       	String nameinapp1 = CellText1.getText();
	  				       	
	  				       	String str2="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[3]";
	  				        WebElement CellText2=driver.findElement(By.xpath(str2));
	  				       	String nameinapp2 = CellText2.getText();
	  				       	
	  				       	String str3="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[4]";
	  				        WebElement CellText3=driver.findElement(By.xpath(str3));
	  				       	String nameinapp3 = CellText3.getText();
	  				       	
	  				       	
	  				    	 System.out.println("Username in the application is " + nameinapp1);
	  				    	System.out.println("Username in the excelsheet is " + name);
	  				    	
	  				    	 System.out.println("Userrole in the application is " + nameinapp2);
	  				    	System.out.println("Userrole in the excelsheet is " + role);
	  				    	
	  				    	 System.out.println("Empname in the application is " + nameinapp3);
	  				    	System.out.println("Empname in the excelsheet is " + empname);
	  				        
	  					    	if ( name.equals(nameinapp1) && role.equals(nameinapp2) && empname.equals(nameinapp3))
	  					    	{
	  					    	   Record_Present=true;
	  					    	   System.out.println("Record found in  " + i +" rwo" );
	  					    	   
	  					    	 ExcelApiTest3 eat1 = new ExcelApiTest3();
			        			 int rownum1=eat1.getRowCount("C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet3");
			        			 
			        			  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
						    	   {
						      		   String strr="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
						      		   WebElement CellTextt=driver.findElement(By.xpath(strr));
						    		   String valuetoexpo = CellTextt.getText();
						    	      						    	      
						    	        if (valuetoexpo !=null)
						    	        eat1.PutCellData( "C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet3",rownum1,k,valuetoexpo);
						    	        else
						    	        eat1.PutCellData( "C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet3",rownum1,k,"Blank Data");
						    	        	
						    	   }   		
			        			  return Record_Present;
	  					    	}
	  					  		    	
	  					  					    	
	  				    } 
	        			  
	        			  driver.findElement(By.xpath(OR.ADMIN_reset_btn)).click();
	        			  TH3.HTMLScreenShot("ADMIN_RESET","ADMIN_RESET clicked Succefully ","Pass", HtmlOutputFileName,driver);
	        				 
	        			  	return Record_Present;
	        			 
	}
	

	
	

	@BeforeTest
    public void suiteSetup1() throws Exception {
		
		 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
		 String xlsFileSheet="Sheet1";
		 
		 ExcelApiTest3 eat = new ExcelApiTest3();
		 eat.clearsheetdata(xlsFile,xlsFileSheet);
		 
		// xlsFile="E://OrangeHrm//TC05_Leavelist.xls";
		 //xlsFileSheet="Sheet3";
		 
		 //ExcelApiTest3 eat1 = new ExcelApiTest3();
		 //eat1.clearsheetdata(xlsFile,xlsFileSheet);
		 
    }  	
	
	@AfterTest
  
    public void AftersuiteSetup2() throws Exception {
		 
		 TestHTMLReporter6 TH4 = new TestHTMLReporter6();	
		 TH4.Regression_CretaeHTMLFile();
		 
		 
		
		
    }
			
	
}