package com.training.sanity.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ReturnOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnOrderTest {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ReturnOrderPOM returnorder;
	private static Properties properties;
	private ScreenShot screenShot;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")){
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		returnorder= new ReturnOrderPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		}
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

  @Test
  public void ReturnOrder() throws InterruptedException {
	  loginPOM.sendUserName("sowmyasou123@gmail.com");
		loginPOM.sendPassword("sowm@123");
		loginPOM.clickLoginBtn();
		returnorder.mouseOverOnIcon();
		returnorder.mouseOverOnMyOrdersandClick();
		returnorder.viewOrder();
		screenShot.captureScreenShot("vieworder");
		returnorder.ClickOnReturn();
		returnorder.clickOnReturnRadio();
		returnorder.clickOnProductRadio();
		returnorder.enterReasonforReturn();
		returnorder.clickOnSubmit();
		String expectedResult1 ="Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
		String expectedResult2="You will be notified via e-mail as to the status of your request.";
		String actualResult1= returnorder.returnSuccessMessage_1();
		String actualResult2=returnorder.returnSuccessMessage_2();
		assertEquals(actualResult1, expectedResult1);
		assertEquals(actualResult2, expectedResult2);
	
		
		
  }
}
