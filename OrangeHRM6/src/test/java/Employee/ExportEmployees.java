//import MercuryDemoTours;

package Employee;

import CommonUtil.*;
import HTMLReport.TestHTMLReporter6;
import ExcelUtil.ExcelApiTest3;
import Login.Login;

import org.testng.annotations.Test;



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


 
public class ExportEmployees
{
	public String UserName,Password;
	public String empname;
	
	
	public  int iRow;
	
	WebDriver driver;
	TestHTMLReporter6 TH3;	
	String HtmlOutputFileName;
	String error;
	
	public  void ExportEmployees(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3  )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	
	
	
	@Test
	public  void ExportAllEmployees( )throws Exception
	{  
		
			 ExcelApiTest3 eat = new ExcelApiTest3();
			 int numberowsInputdata=eat.getRowCount("E://OrangeHrm//TC01.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,0);
					 Password=eat.getCellData("E://OrangeHrm//TC01.xls","Sheet1",i,1);
					 iRow=i;
					 call_allmethods(iRow);
				 }
			
				 driver.quit();
				 
	}
	
				 
				 
				 public void call_allmethods(int iRow )throws Exception
					{  
						
					 
					String str=String.valueOf(iRow);
					TH3= new TestHTMLReporter6();
					HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_Export_Employees","Chrome");
					 
					 
						driver=TestBrowser.OpenChromeBrowser();
						
						Login l1=new Login();
						l1.Login(driver ,HtmlOutputFileName,TH3);
						l1.openOrangeHRM();
						l1.OrangeHRMlogin(UserName,Password);
						TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
						l1.OrangeHRMSigninClick();
						
						TH3.HTMLScreenShot("HomePage navigation","Navigated to HomePage","Pass", HtmlOutputFileName,driver);
						
						ExportEmployees Ae=new  ExportEmployees();		
						Ae.ExportEmployees(driver ,HtmlOutputFileName,TH3);
						Ae.Export_EmployeeDetails();
						TH3.HTMLScreenShot("Export Employee Details","Employee Details exported to E://OrangeHrm//TC05_empname.xls","Pass", HtmlOutputFileName,driver);
						
						//driver.quit();
						TH3.HTMLCloser(HtmlOutputFileName);
						TH3=null;
						System.gc();
					}
					
				 
					public  Boolean Empname_sech(int iRow,String empname )throws Exception
					{ 
						
						
						System.out.println("empname is : "+ empname);
						
						Boolean Record_Present=false;
						

					     Actions actions = new Actions(driver);   
						 WebElement ele=driver.findElement(By.xpath(OR.Pim_focus));
				         actions.moveToElement(ele).click().perform();
						 
						 driver.findElement(By.xpath(OR.Employee_click)).click();
						 
						 driver.findElement(By.xpath(OR.Employeename_click)).sendKeys(empname);
							System.out.println("empname is"+empname);
									
						 
						 driver.findElement(By.xpath(OR.Employee_click)).click();
						 driver.findElement(By.xpath(OR.Empserch_click)).click();
						 
						
						
				        //No. of columns
				        List  columns = driver.findElements(By.xpath(OR.Empcoloums)); 
				        System.out.println("No of columns are : " + columns.size());
				        
				        //No.of rows 
				        List  rows = driver.findElements(By.xpath(OR.EmpRows)); 
				        System.out.println("No of rows are : " + rows.size());
				        
								    for ( int i=1 ; i<=rows.size() ;i++)
								    {
								      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + 2 +"]";
								      	
								      //*[@id="resultTable"]/tbody/tr[1]/td[2]
								      	
								      //*[@id="resultTable234"]/tbody/tr[1]/td[4]
								      	
								    
								        WebElement CellText1=driver.findElement(By.xpath(str1));
								    		   
								    	String valueIneed1 = CellText1.getText();
								       
								        
									    	if (empname.equals(valueIneed1) )
									    	{
									    	    	 Record_Present=true;
									    	    	 System.out.println("True- empname Text Value is: " + valueIneed1);
									    	    	 return Record_Present;
									    	    	 //Employee ID exist in employee list
									    	}
									    	else
									    	{
									    		 System.out.println("Cell Text Value is:" + valueIneed1);
											     System.out.println("Seracching for Employee ID is:" +empname);
									    	}
									    	
									  					    	
								    }  //After for loop
								    
								    System.out.println("*******Employee Serach method completed*****");
				   
						return Record_Present;
		    }  //After for loop
									    
									   

					public  void Export_EmployeeDetails()throws Exception
					{ 
						
						
						 Actions actions = new Actions(driver);   
						 WebElement ele=driver.findElement(By.xpath(OR.Pim_focus));
				         actions.moveToElement(ele).click().perform();
						 
						 driver.findElement(By.xpath(OR.Employee_click)).click();
						 
						
						 driver.findElement(By.xpath(OR.Empserch_click)).click();
						
				        //No. of columns
				        List  columns = driver.findElements(By.xpath(OR.Empcoloums)); 
				        //System.out.println("No of columns are : " + columns.size());
				        
				        //No.of rows 
				        List  rows = driver.findElements(By.xpath(OR.EmpRows)); 
				       // System.out.println("No of rows are : " + rows.size());
				        
				       
				      
				        			ExcelApiTest3 eat = new ExcelApiTest3();
				         
								    for ( int i=1 ; i<=rows.size() ;i++)
								    {
								    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++)
								    	   {
								      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
								      		   
								      		//*[@id="resultTable"]/tbody/tr[1]/td[2]
								    		    WebElement CellText1=driver.findElement(By.xpath(str1));
								    		   
								    	        String valueIneed1 = CellText1.getText();
								    	      //  System.out.println("Cell Text Value is: " + valueIneed1);
								    	        
								    	        if (valueIneed1 !=null)
								    	        eat.PutCellData( "E://OrangeHrm//TC05_empname.xls","Sheet4",i,k,valueIneed1);
								    	        else
								    	        eat.PutCellData( "E://OrangeHrm//TC05_empname.xls","Sheet4",i,k,"Blank Data");
								    	        	
								    	   }
								    }
				   
					
					}
					
}
				        
					
					
				
					
					
					
					
						
		





















						
						


	