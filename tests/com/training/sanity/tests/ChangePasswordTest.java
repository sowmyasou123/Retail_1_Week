package com.training.sanity.tests;

import java.util.Properties;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordPOM;
import com.training.pom.LoginPOM;




public class ChangePasswordTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePasswordPOM changePasswordPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		changePasswordPOM = new ChangePasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	//to validate validation message is displayed when 2 different password is given
	public void validateChangePasswordErrorMessage(){
		loginPOM.sendUserName("manzoor@gmail.com");
		loginPOM.sendPassword("mehadi");
		loginPOM.clickLoginBtn();
		changePasswordPOM.clickChangepassword();
		changePasswordPOM.enterPassword("mehadi");
		changePasswordPOM.re_EnterPassowrd("manzoor");
		String actualResult=changePasswordPOM.verifyPassword("mehadi", "manzoor");
		String expectedResult="Password confirmation does not match password!";
		assertEquals(actualResult,expectedResult);
		screenShot.captureScreenShot("validateerrorpasswordmsg");
	}
	// to validate password has been changed successfully
	@Test(dependsOnMethods={"validateChangePasswordErrorMessage"})
	public void validateChangePassword(){
		loginPOM.sendUserName("manzoor@gmail.com");
		loginPOM.sendPassword("mehadi");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Changepassword_Login");
		changePasswordPOM.clickChangepassword();
		changePasswordPOM.enterPassword("mehadi");
		changePasswordPOM.re_EnterPassowrd("mehadi");
		screenShot.captureScreenShot("passwordEntry");
		changePasswordPOM.clickContinue();
		String actualResult=changePasswordPOM.validateSuccessmesssage();
		String expectedResult="Success: Your password has been successfully updated.";
		assertEquals(actualResult, expectedResult);
		screenShot.captureScreenShot("successmessage");
	}
	
}
