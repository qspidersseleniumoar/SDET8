package com.comcast.conatcttest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.commonutils.ExcelUtility;
import com.comcast.commonutils.FileUtility;
import com.comcast.commonutils.JavaUtils;
import com.comcast.commonutils.WebDriverUTils;

public class DeleteCoantctTest {

	@Test
	public void createConatctWithORg() throws Throwable {
		WebDriverUTils wLib = new WebDriverUTils();
		FileUtility fLib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		
		/*Common  Data*/
		String URL  = fLib.getPropertyKeyValue("url");
		String USERNAME  = fLib.getPropertyKeyValue("username");
		String PASSWORD  = fLib.getPropertyKeyValue("password");
		String BROWSER  = fLib.getPropertyKeyValue("browser");
		
		/*Test  Data*/

		String contactLastNAme  = elib.getExcelData("Contact", "tc_02", "LastName")+JavaUtils.getRanDomData();
		

		/*step 1 : login to app*/
		WebDriver driver ;
		 if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver(); 
		 }
		
	
		 
	}

}
