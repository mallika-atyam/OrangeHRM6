//import MercuryDemoTours;

package  Emp_Mallika;
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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
 Addemp
 logout
 */

 
public class Edit_emp_pers
{
	public String UserName,Password,PhotoPath;
	public String FirstName,MiddleName,LastName,Id,Oid,DriverLno,Gender,MaritalStat,Nationality;
	
	public  int iRow;
	
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void Edit_emp_pers(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	// Draws a red border around the found element. Does not set it back anyhow.
		public WebElement findElement(By by)throws Exception {
		    WebElement elem5 = driver.findElement(by);
		 
		    // draw a border around the found element
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem5);
		    } 
		    Thread.sleep(1000);
		    
		    return elem5;
		}
		
			
	
	@Test
	public  void EmpDet_datadriventest( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  //int numberowsInputdata=eat.getRowCount("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1");

				 for(int i=1;i<2;i++)
				 {		 
					 UserName="Admin";
					 
					 Password="admin123";
					 //FirstName,MiddleName,LastName,Id,Oid,DriverLno,Gender,MaritalStat,Nationality;
					
					 FirstName=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,0);
					 MiddleName=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,1);
					 LastName=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,2);
					 Id=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,3);
					 Oid=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,4);
					 DriverLno=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,5);
					 Gender=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,6);
					 MaritalStat=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,7);
					 Nationality=eat.getCellData("C:\\HTML Report\\OrangeHRM6\\TC05_EMPLIST.xls","Sheet1",i,8);
					 
					 PhotoPath="E:\\roopa\\Roopa Poetry.txt";
					 System.out.println("FirstName is"+FirstName);
					 System.out.println(" MiddleName is "+MiddleName);
					 System.out.println(" LastName is "+LastName);
					 System.out.println(" Id is "+Id);
					  iRow=i;
					  
						call_allmethods(iRow);
						
						
						
					 
				 }
			
				 
				 driver.quit();
				 
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_Add_Employee_Iteration_" + str,"Chrome");
		
		
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
		
		
		Boolean rp=false;
		Edit_emp_pers EEP =new Edit_emp_pers();
		EEP.Edit_emp_pers(driver,HtmlOutputFileName,TH3 );
		rp=EEP.EditEmp(iRow, FirstName, MiddleName, LastName, Id, Oid, DriverLno, Gender, MaritalStat, Nationality);
		if(rp==true)	 
		{
			System.out.println("YES username found");
			EEP.PhotoUpload(iRow,PhotoPath);
			
		}
		 else
		  {
			 System.out.println("No-username, username not found");
		  }
		TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();

		
	}	
	
	
	public   void PhotoUpload(int iRow , String PhotoPath)throws Exception
	{
		

		
	//findElement(By.xpath("//*[@id='photofile']")).click();
		findElement(By.xpath(OR.Emp_attachFilePick)).click();

	
		Thread.sleep(1000);
		 
		// Specify the file location with extension
		// StringSelection sel = new StringSelection("C:\\Users\\Sudhakar\\Desktop\\download1.jpg");
		 
		StringSelection sel = new StringSelection(PhotoPath);
		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 
		 // Create object of Robot class
		 Robot robot = new Robot();
		 Thread.sleep(2000);
		      
		  // Press Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(2000);
		        
		       //  Press Enter 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(8000);
	
		findElement(By.xpath(OR.Emp_attachUploadBtn)).click();
		
		TH3.HTMLScreenShot("Add Employee Page -  Select Photo to Photo  ","Upload photo selected","Pass", HtmlOutputFileName,driver);
		Thread.sleep(8000);
		 
		 TH3.HTMLScreenShot("Add Employee Page -  Upload Photo  ","Photo Uploaded","Pass", HtmlOutputFileName,driver);
		 
		
		
	}



	public   Boolean EditEmp(int iRow,String FirstName,String MiddleName,String LastName,String Id,String Oid,String DriverLno,String Gender,String MaritalStat,String Nationality)throws Exception
	{  
		
		System.out.println("reached here");
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.Emp_Pim_focus1));
		 actions.moveToElement(ele).click().perform();
		 TH3.HTMLScreenShot("Pim focus highlight","Pim  clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 System.out.println("reached here2");
		 findElement(By.xpath(OR.Emp_list_focus)).click();
		 TH3.HTMLScreenShot("Emp focus highlight","Emp focus highlighted Succefully ","Pass", HtmlOutputFileName,driver);
		
		 
		 List  columns = driver.findElements(By.xpath(OR.Empcoloums)); 
	        System.out.println("No of columns are : " + columns.size());
	        
	        
	        List  rows = driver.findElements(By.xpath(OR.EmpRows)); 
	        System.out.println("No of rows are : " + rows.size());
	      
	     
	        
	        			ExcelApiTest3 eat = new ExcelApiTest3();
	        			Boolean Record_Present=false;
	         
	        			  for ( int i=1 ; i<=rows.size() ;i++)
	  				    {
	  				      	String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[2]";
	  				    
	  				        WebElement CellText1=findElement(By.xpath(str1));
	  				    		   
	  				    	String Idinapp = CellText1.getText();
	  				    	 System.out.println("Id in the application is " + Idinapp);
	  				    	System.out.println("ID in the excelsheet is " + Id);
	  				        
	  					    	if ( Id.equals(Idinapp) )
	  					    	{
	  					    	   Record_Present=true;
	  					    	   System.out.println("ID found " + Idinapp + "Id in  " + i +" rwo" );
	  					    	 
	  					    	// String str2="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[3]";
	  					    	//Actions actions1 = new Actions(driver);   
	  							//WebElement ele1=findElement(By.xpath(str2));
	  							 //actions1.moveToElement(ele1).click().build().perform();

	  							findElement(By.linkText(Idinapp)).click();
	  							 //findElement(By.xpath(str1)).click();
	  							 TH3.HTMLScreenShot("EMPID","EMPID clicked Succefully ","Pass", HtmlOutputFileName,driver);
	  							 
	  							 findElement(By.xpath(OR.EMP_personalDet)).click();
	  							 TH3.HTMLScreenShot("EMP_personalDet","EMP_personalDet clicked Succefully ","Pass", HtmlOutputFileName,driver);
	  							 
	  							 
	  							 findElement(By.xpath(OR.Emp_Edit)).click();
	  							 TH3.HTMLScreenShot("Emp_Edit","Emp_Edit clicked Succefully ","Pass", HtmlOutputFileName,driver);
	  							 
	  							findElement(By.xpath(OR.EMP_Edit_fullname)).clear();
	  							 findElement(By.xpath(OR.EMP_Edit_fullname)).sendKeys(FirstName);
	  							 TH3.HTMLScreenShot("Enter FirstName","FirstName Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							//FirstName,MiddleName,LastName,Id,Oid,DriverLno,Gender,MaritalStat,Nationality;
	  					    	 
	  							findElement(By.xpath(OR.EMP_Edit_midname)).clear();
	  							 findElement(By.xpath(OR.EMP_Edit_midname)).sendKeys(MiddleName);
	  							 TH3.HTMLScreenShot("Enter MiddleName","MiddleName Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							
	  							findElement(By.xpath(OR.EMP_Edit_lastname)).clear();
	  							 findElement(By.xpath(OR.EMP_Edit_lastname)).sendKeys(LastName);
	  							 TH3.HTMLScreenShot("Enter LastName","LastName Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							
	  							findElement(By.xpath(OR.Emp_OtherId)).sendKeys(Oid);
	  							 TH3.HTMLScreenShot("Enter Oid","Oid Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							 
	  							findElement(By.xpath(OR.Emp_DrLicNo)).sendKeys(DriverLno);
	  							 TH3.HTMLScreenShot("Enter DriverLno","DriverLno Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							 
	  							if ( Gender.equals("MALE") )
	  							{
	  								 findElement(By.xpath(OR.Emp_GenMale_radiobtn)).click();
	  								 TH3.HTMLScreenShot("GENDER box","MALE RadioButton clicked","Pass", HtmlOutputFileName,driver);
	  								 	
	  							}
	  							 else
	  							{
	  								 findElement(By.xpath(OR.Emp_GenFemale_radiobtn)).click();
	  								 TH3.HTMLScreenShot("GENDER box","FEMALE RadioButton clicked","Pass", HtmlOutputFileName,driver);
	  								 	
	  							}
	  							
	  							Select listbox1 =new Select(findElement(By.xpath(OR.Emp_MaritalStat)));
	  							listbox1.selectByVisibleText(MaritalStat);
	  							TH3.HTMLScreenShot("Enter MaritalStat","MaritalStat Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							
	  							Select listbox2 =new Select(findElement(By.xpath(OR.Emp_Nationality)));
	  							listbox2.selectByVisibleText(Nationality);
	  							TH3.HTMLScreenShot("Enter Nationality","Nationality Succefully Entered","Pass", HtmlOutputFileName,driver);
	  							
	  							findElement(By.xpath(OR.Emp_Edit_save)).click();
	  							 TH3.HTMLScreenShot("Emp_Edit_save","Emp_Edit_save clicked Succefully ","Pass", HtmlOutputFileName,driver);
	  						
	  							findElement(By.xpath(OR.Emp_attachBtn)).click();
	  							 TH3.HTMLScreenShot("Emp_attachBtn","Emp_attachBtn clicked Succefully ","Pass", HtmlOutputFileName,driver);
	  						
	  							 
	  							 
	  							 
	  							  return Record_Present;
	  					    	}
	  					  		    	
	  					  					    	
	  				    } 
	        			  	return Record_Present;
	        			 
			
	
		} 
		
	
		
		 
		 
	
	

	
}