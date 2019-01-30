package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginAdminPOM;
import com.training.pom.OrderCompletePOM;
import com.training.pom.PreLoginOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PreLoginOrderTest {
	private WebDriver driver;
	private String baseUrl;
	private PreLoginOrderPOM prelogin;
	private LoginAdminPOM adminlogin;
	private OrderCompletePOM ordercomplete;
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

		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		baseUrl = properties.getProperty("baseURL");
		prelogin= new PreLoginOrderPOM(driver);
		adminlogin= new LoginAdminPOM(driver);
		ordercomplete= new OrderCompletePOM(driver);
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		//driver.navigate().to(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void Place_PreLoginOrder() throws InterruptedException {
		
		prelogin.clickJewellery();
		Thread.sleep(4000);
		prelogin.clickOnCosmeticImage();
		prelogin.moveToNextWindow();
		prelogin.clickAddToCart();
		Thread.sleep(5000);
		//prelogin.mouseOverOnCart();
		Thread.sleep(5000);
		prelogin.clickOnCheckOut();
		Thread.sleep(4000);
		prelogin.clickOnContinue1();
		prelogin.enterFirstName("sowm");
		prelogin.enterLastName("bbbbbbb");
		prelogin.enterEmail("abbcbcb@gmail.com");
		prelogin.enterTelephoneNo("9945623123");
		prelogin.enterAddress("jayanagar");
		prelogin.enterCity("Bangalore");
		prelogin.selectState();
		prelogin.enterPassword("asdf");
		prelogin.re_enterPassword("asdf");
		Thread.sleep(3000);
		prelogin.clickOnAgreeCheckBox1();
		Thread.sleep(2000);
		prelogin.ClickOnContinue_2();
		Thread.sleep(3000);
		prelogin.clickOnContinue3();
		Thread.sleep(2000);
		prelogin.clickOnContinue4();
		Thread.sleep(2000);
		prelogin.clickOnAgreeCheckbox2();
		prelogin.clickOnContinue5();
		Thread.sleep(2000);
		prelogin.clickOnConfirm();
		
		
		
		
	}
	
	@Test
	public void AdminLogin() throws InterruptedException{
		driver.get("http://retail.hommelle.com/admin/");
		adminlogin.sendAdminName("admin");
		adminlogin.sendAdminPassword("admin@123");
		adminlogin.clickLoginBtn();
		Thread.sleep(3000);
		ordercomplete.mouseOveronMenuSale();
		ordercomplete.mouseOverandClickOnOrders();
		Thread.sleep(10000);
		ordercomplete.clickOnViewOrder("manzoor2 mehadi","31/12/2018");
		Thread.sleep(5000);
		ordercomplete.selectOrderStatus();
		//ordercomplete.addComment("complete the order");
		ordercomplete.addHistory();
		
		
	}
}
