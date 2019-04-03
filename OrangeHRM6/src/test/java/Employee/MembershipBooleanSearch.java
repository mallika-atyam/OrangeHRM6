
package  Employee;
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
 boolean,MEMBERSHIP_ADD,
 MEMBERSHIP_SEARCH
 MEMBERSHIP_DELETE
 export
 logout
 */

 
public class MembershipBooleanSearch
{
	public String UserName,Password,Membership;
	public  int iRow;
	WebDriver driver;
	
	String HtmlOutputFileName;
	String error;
	TestHTMLReporter6 TH3;
		
	public  void MembershipBooleanSearch(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	/*@Test(priority=1)
	public  void AddMem( )throws Exception
	{  	
		AdminMembership AM=new AdminMembership();
		AM.Data_driven_test();
	}

	@Test(priority=2)
	*/
	@Test
	public  void Data_driven_test( )throws Exception
	{  
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_membership.xls","Sheet1");

				 for(int i=1;i<numberowsInputdata;i++)
				 {		 
					 UserName="ADMIN";
					 Password="admin123";
					 Membership=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_membership.xls","Sheet1",i,2);
					 System.out.println("User name is"+UserName);
					 System.out.println(" Password is "+Password);
					 System.out.println(" Membership is "+Membership);
					 
						
					 iRow=i;
					 call_allmethods(iRow);
				 }
				 
			 driver.quit();
	}

	public   void call_allmethods(int iRow )throws Exception
	{  
	
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC03_Membership" + str,"Chrome");
	
		 			
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
		
		
		MembershipBooleanSearch MBS =new MembershipBooleanSearch();
		MBS.MembershipBooleanSearch(driver, HtmlOutputFileName, TH3);
				
		Boolean BL=false;
		BL=MBS.MemberShipDelete(iRow, Membership);
		if(BL==true)	 
		{
			System.out.println("YES Membership found and deelte"+Membership);
			 TH3.HTMLScreenShot("YES Membership found and deelte"+Membership,"YES Membership found and deelte"+Membership,"Pass", HtmlOutputFileName,driver);
		}
		 else
		  {
			 System.out.println("No Membership found to deelte"+Membership);
			 TH3.HTMLScreenShot("No Membership found to deelte"+Membership,"No Membership found to deelte"+Membership,"Pass", HtmlOutputFileName,driver);
		  }
			  
		 
		TH3.HTMLCloser(HtmlOutputFileName);

		TH3=null;
		HtmlOutputFileName=null;
		System.gc(); 
	
			}	
	
	public   Boolean MemberShipDelete(int iRow,String Membership)throws Exception
	{  
		
		Boolean Record_Present=false;
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
	    WebElement ele=driver.findElement(By.xpath(OR.ADMIN_FOCUS));
	    actions.moveToElement(ele).click().perform();
	    
	    driver.findElement(By.xpath(OR.ADMIN_QUALIFICATIONS_FOCUS)).click();
		 TH3.HTMLScreenShot("Qualification focus highlight","Qualification focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 driver.findElement(By.xpath(OR.ADMIN_MEMBERSHIP)).click();
		 TH3.HTMLScreenShot("Membership","Membership clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 
		 TH3.HTMLScreenShot("Admin focus highlight","Admin focused Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 
		 
		// driver.findElement(By.xpath(OR.ADMIN_QUALIFICATIONS_FOCUS)).click();
		 //TH3.HTMLScreenShot("Qualification focus highlight","Qualification focused Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 //driver.findElement(By.xpath(OR.ADMIN_MEMBERSHIP)).click();
		 //TH3.HTMLScreenShot("Membership","Membership clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 List  columns = driver.findElements(By.xpath(OR.ADMIN_MEM_COLS)); 
	    
	     List  rows = driver.findElements(By.xpath(OR.ADMIN_MEM_ROWS)); 
	     System.out.println("No of rows are : " + rows.size());
	    	        
	    		ExcelApiTest3 eat = new ExcelApiTest3();
	         
	           for ( int i=1 ; i<=rows.size() ;i++)
	  		      {
	  			     	String pathdelete="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[2]";
	  				    
	  			        WebElement CellText1=driver.findElement(By.xpath(pathdelete));
	  				    		   
	  			    	String Membershipapp = CellText1.getText();
	  				  				        
	  			    	if ( Membership.equals(Membershipapp) )
	  					    		
	  			       {
	  			    		
	  			   	  Record_Present=true;
	  		  					    	   
	  			   	 String path_checkbox="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[1]";
	  			   	 driver.findElement(By.xpath(path_checkbox)).click();
	  				 TH3.HTMLScreenShot("Check box","Membership checkbox clicked","Pass", HtmlOutputFileName,driver);
	  							 
	  				 driver.findElement(By.xpath(OR.ADMIN_MEM_DEL)).click();
	  				 TH3.HTMLScreenShot("Delte clicked","Membership deleted Succefully ","Pass", HtmlOutputFileName,driver);
	  			
	  				driver.findElement(By.xpath(OR.ADMIN_MEM_DEL_OK)).click();
	  			    TH3.HTMLScreenShot("ConfirmDelte clicked","Membership deleted Succefully ","Pass", HtmlOutputFileName,driver);	  					    	
	  				return Record_Present;
	  				
	  	              	}
	  				else
	  				  	{
	  				TH3.HTMLScreenShot("No Membership found to deelte"+Membership,"No Membership found to deelte"+Membership,"Pass", HtmlOutputFileName,driver);
	  				   	}
	  					  		    	
	  					  					    	
	  				    } 
	        			  	return Record_Present;
	        			  /*if(Record_Present==true)	 
	        				System.out.println("YES Membership found");
	        			  else
	      					System.out.println("No-Membership, Membership not found");
	        				  
	        			  driver.quit();*/
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