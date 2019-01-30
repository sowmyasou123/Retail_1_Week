package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.pom.LoginAdminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddMultipleProduct {

	private WebDriver driver;
	private String adminURL;
	private LoginAdminPOM adminlogin;
	private AddProductPOM addproduct;
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
		adminURL = properties.getProperty("adminURL");
		addproduct = new AddProductPOM(driver);
		adminlogin = new LoginAdminPOM(driver);
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminURL);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// to fetch excel sheet data format:Product Name Meta Title Model Price
	// Quantity SEOURL Category

/*	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void AddMultipleProduct(String productname, String metatag, String model, String price, String qty,
			String SEOURL, String category) throws InterruptedException {
		adminlogin.sendAdminName("admin");
		adminlogin.sendAdminPassword("admin@123");
		adminlogin.clickLoginBtn();
		addproduct.mouseOveronMenucatalog();
		addproduct.mouseOverandClickOnProducts();
		addproduct.ClickOnAddProduct();
		addproduct.enterProductName(productname);
		Thread.sleep(2000);
		addproduct.enterMetaTagTitle(metatag);
		addproduct.clickOnDataTab();
		Thread.sleep(2000);
		addproduct.enterModelName(model);
		addproduct.enterPrice(price);
		addproduct.enterQuantity(qty);
		addproduct.enterSEOURL(SEOURL);
		Thread.sleep(4000);
		addproduct.clickOnLinks();
		addproduct.selectCategory(category);
		Thread.sleep(3000);
		addproduct.clickOnSave();
		String expected = "Success: You have modified products!";
		String actual = addproduct.getSuccessMsg();
		assertTrue(actual.contains(expected));

	}*/

	@Test(dataProvider = "excel-inputs_1", dataProviderClass = LoginDataProviders.class)
	public void validateAddproductsErrorMessages(String productname, String metatag, String model)
			throws InterruptedException {
		String formexpected = "Warning: Please check the form carefully for errors!";
		String modelexpected = "Product Model must be greater than 1 and less than 64 characters!";
		String metatagexpected = "Meta Title must be greater than 3 and less than 255 characters!";
		String productExpected = "Product Name must be greater than 3 and less than 255 characters!";
		adminlogin.sendAdminName("admin");
		adminlogin.sendAdminPassword("admin@123");
		adminlogin.clickLoginBtn();
		Thread.sleep(5000);
		addproduct.mouseOveronMenucatalog();
		addproduct.mouseOverandClickOnProducts();
		Thread.sleep(5000);
		addproduct.ClickOnAddProduct();
		addproduct.enterProductName(productname);
		addproduct.enterMetaTagTitle(metatag);
		
		if (productname.equalsIgnoreCase("a")  && model.equalsIgnoreCase("a") ) {
			
			addproduct.clickOnSave();
			String productActual = addproduct.getProdcutNameValidateMsg();
			
			addproduct.clickOnDataTab();
			Thread.sleep(3000);
			addproduct.enterModelName(model);
			Thread.sleep(3000);
			
			String modelactual = addproduct.getModelNameValidateMsg();
			assertEquals(productActual, productExpected);
			assertEquals(modelactual, modelexpected);
		}
		if (metatag.equalsIgnoreCase("b") && model.equalsIgnoreCase("c")) {
			addproduct.clickOnSave();
			String metatagactual = addproduct.getMetaTagValidateMsg();
			addproduct.clickOnDataTab();
			Thread.sleep(3000);
			addproduct.enterModelName(model);
			Thread.sleep(3000);
			
			String modelactual = addproduct.getModelNameValidateMsg();
			assertEquals(metatagactual, metatagexpected);
			assertEquals(modelactual, modelexpected);
		}
		if (model.equalsIgnoreCase("c")) {
			  addproduct.clickOnDataTab();
			  Thread.sleep(3000);
			addproduct.enterModelName(model);
			Thread.sleep(2000);
			addproduct.clickOnSave();
			String modelactual = addproduct.getModelNameValidateMsg();
			assertEquals(modelactual, modelexpected);
		}
		//addproduct.clickOnSave();
		
		
		// addproduct.clickOnSave();
		
		
		  
	}

}
