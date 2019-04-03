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
 username search and export
 logout
 */

 
public class Username_search
{
	public String UserName,Password,name;
	//public String FirstName,MiddleName,LastName,Id;
	
	public  int iRow;
	
	
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
	//TestHTMLReporter6 TH3 = new TestHTMLReporter6();	
	
	public  void Username_search(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
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
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 System.out.println(" User name is "+name);
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 System.out.println("out of for loop in datadriventest||||||||||||||||||||");
	 
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

		
		}
		
		
		Username_search DJT =new Username_search();
		DJT.Username_search(driver, HtmlOutputFileName, TH3);		
		
		
		Boolean r1=false;
		r1=DJT.username_search(iRow,name);
		if(r1==true)	 
		{
			System.out.println("YES username found");
			
		}
		 else
		  {
			 System.out.println("No-username, username not found");
		  }
			  
		 
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
		//driver.quit();
			}	
	
	public   Boolean username_search(int iRow,String name)throws Exception
	{  
		
		Boolean Record_Present=false;
		System.out.println("reached here");
				
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
		 
		 driver.findElement(By.xpath(OR.ADMIN_username)).sendKeys(name);
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
	  				    		   
	  				    	String nameinapp = CellText1.getText();
	  				    	 System.out.println("name in the application is " + nameinapp);
	  				    	System.out.println("name in the excelsheet is " + name);
	  				        
	  					    	if ( name.equals(nameinapp) )
	  					    	{
	  					    	   Record_Present=true;
	  					    	   System.out.println("jobtitle found " + nameinapp + "jobtitle in  " + i +" rwo" );
	  					    	   
	  					    	 ExcelApiTest3 eat1 = new ExcelApiTest3();
			        			 int rownum1=eat1.getRowCount("C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet4");
			        			 
			        			  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
						    	   {
						      		   String str2="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
						      		   
						      		//*[@id="resultTable"]/tbody/tr[1]/td[2]
						    		    WebElement CellText2=driver.findElement(By.xpath(str2));
						    		   
						    	        String valueIneed2 = CellText2.getText();
						    	      //  System.out.println("Cell Text Value is: " + valueIneed1);
						    	        
						    	      
						    	        if (valueIneed2 !=null) {
						    	        eat1.PutCellData( "C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet4",rownum1,k,valueIneed2);
						    	        System.out.println("Export of  " + valueIneed2 +" is over.");
						    	        }
						    	        else
						    	        eat1.PutCellData( "C://HTML Report//OrangeHRM6//TC01_users.xls","Sheet4",rownum1,k,"Blank Data");
						    	        	
						    	   }   		
			        			  return Record_Present;
	  					    	}
	  					  		    	
	  					  					    	
	  				    } 
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