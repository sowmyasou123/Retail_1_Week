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
import com.training.pom.LoginAdminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginAdminTest {

	private WebDriver driver;
	private String adminURL;
	private LoginAdminPOM loginadminpom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")){
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginadminpom = new LoginAdminPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminURL);
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
  public void ValidateErrorPasswordMsg() {
	  loginadminpom.sendAdminName("admin");
	  loginadminpom.sendAdminPassword("admin@12");
	  loginadminpom.clickLoginBtn();
	  String expectedResult="No match for Username and/or Password.";
	  String actualResult= loginadminpom.ErrorPasswordmessage().getText();
	  assertTrue(actualResult.contains(expectedResult));	  
  }
}
