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
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/* step 2 : Navigtae to Contacts */
		driver.findElement(By.linkText("Contacts")).click();

		/* step 3 : navigate to create Contact Page */
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		/* step 4 : Create new Contact With Organization */
		driver.findElement(By.name("lastname")).sendKeys(contactLastNAme);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/* step 5 : navigate to Coabtct Module */
		driver.findElement(By.linkText("Contacts")).click();

		/* capature all the conatct List */
		List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/*"));
		for (WebElement wb : lst) {
			if (wb.getText().equals(contactLastNAme)) {
				System.out.println(contactLastNAme + "==> is created & avaibale ==PASS");
				break;
			}
		}

		driver.findElement(By.xpath("//a[text()='" + contactLastNAme + "']/../../td[10]/a[text()='del']")).click();
		wLib.accpetAllert(driver);

		/* capature all the conatct List */
		List<WebElement> lst1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/*"));
		for (WebElement wb : lst1) {
			if (wb.getText().equals(contactLastNAme)) {
				System.out.println(contactLastNAme + "==> is still availbale ==Fail");
				break;
			}
		}

		
		 /* step 8 : logout */
		   WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		   wLib.moveMouseToElemnet(driver, wb);
		  driver.findElement(By.linkText("Sign Out")).click(); driver.quit();
		 
	}

}
