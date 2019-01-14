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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.generics.ScreenShot;
import com.training.pom.SearchProductPOM;

public class SearchProductTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private SearchProductPOM searchproduct;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		searchproduct= new SearchProductPOM(driver);
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
	//to search the product
	public void searchProduct() throws InterruptedException{
		//click on shop now and then click on jewellery
		searchproduct.clickJewellery();
		//get the sortby list box values
		searchproduct.validateSortByValues();
		// click on sortby list value: Name(A-Z)
		String actual=searchproduct.clickOnSortByName();
		String expected="cosmetics";
		assertEquals(actual, expected);
		//capture teh screenshot
		screenShot.captureScreenShot("SortByName");
		Thread.sleep(15000);
		//click on sortby list value:Ratings(Highest)
		searchproduct.clickOnSortByRatings();
		Thread.sleep(15000);
		screenShot.captureScreenShot("SortByHighestRating");
	}
	
}
