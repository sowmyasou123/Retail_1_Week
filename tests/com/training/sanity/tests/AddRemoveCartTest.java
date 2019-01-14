package com.training.sanity.tests;

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
import com.training.pom.AddRemoveCartPOM;
import com.training.pom.LoginPOM;
import com.training.pom.SearchProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddRemoveCartTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddRemoveCartPOM addremovecart;
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
		addremovecart = new AddRemoveCartPOM(driver);
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
	// to validate add to cart and remove from the cart functionality
	public void addRemoveCartTest() throws InterruptedException {
		/*
		 * loginPOM.sendUserName("sowmyasou123@gmail.com");
		 * loginPOM.sendPassword("sowm@123"); loginPOM.clickLoginBtn();
		 * Thread.sleep(5000);
		 */
		addremovecart.clickJewellery();
		addremovecart.clickOnImage();
		addremovecart.moveToNextWindow();
		screenShot.captureScreenShot("addtocartpage");
		addremovecart.clickAddToCart();
		Thread.sleep(3000);
		screenShot.captureScreenShot("shoppingcartupdatedmsg");
		addremovecart.mouseOverOnCart();
		addremovecart.clickViewcart();
		String ex_name, ex_mdl, ex_qnty, ex_prc, ex_totl;
		ex_name = "Diamond ring";
		ex_mdl = "DKU-012";
		ex_qnty = "1";
		ex_prc = "Rs.8,566";
		ex_totl = "Rs.8,566";
		String ac_name = addremovecart.getProductName().getText();
		String ac_mdl = addremovecart.getModel().getText();
		String ac_qnty = addremovecart.getQuantity().getAttribute("value");
		String ac_prc = addremovecart.getPrice().getText();
		String ac_totl = addremovecart.getTotal().getText();
		assertEquals(ac_name, ex_name);
		assertEquals(ac_mdl, ex_mdl);
		assertEquals(ac_qnty, ex_qnty);
		assertEquals(ac_prc, ex_prc);
		assertEquals(ac_totl, ex_totl);
		screenShot.captureScreenShot("viewcart");
		addremovecart.clickRemoveFromCart();

		String expectedResult = "Your shopping cart is empty!";
		String actualResult = addremovecart.validateEmptycartMessage();
		assertEquals(actualResult, expectedResult);

		screenShot.captureScreenShot("Emtpycartmessage");

	}
}
