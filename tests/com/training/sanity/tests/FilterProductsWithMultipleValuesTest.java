package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.pom.FilterProductsWithMultipleValuesPOM;
import com.training.pom.LoginAdminPOM;
import com.training.pom.PreLoginOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterProductsWithMultipleValuesTest {
	private WebDriver driver;
	private String adminURL;
	private FilterProductsWithMultipleValuesPOM filterpom;
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
		filterpom= new FilterProductsWithMultipleValuesPOM(driver);
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
	
	
	
  @Test(dataProvider = "excel-inputs_2", dataProviderClass = LoginDataProviders.class)
  public void ValidateFilterWithMultipleValues(String productname, String price, String status,String model,String qty,String image) throws InterruptedException {
	  adminlogin.sendAdminName("admin");
		adminlogin.sendAdminPassword("admin@123");
		adminlogin.clickLoginBtn();
		Thread.sleep(3000);
		addproduct.mouseOveronMenucatalog();
		addproduct.mouseOverandClickOnProducts();
		
	  if(productname.equalsIgnoreCase("null"))
		  System.out.println(productname);
		  else
		  filterpom.enterProductName(productname);
	  
	  if(price.equalsIgnoreCase("null"))
		  System.out.println(price);
	  else
		  filterpom.enterPrice(price);
	  
	  if(status.equalsIgnoreCase("null") )
		  System.out.println(status);
	  else
		  filterpom.selectStatus(status);
	  
	  if(model.equalsIgnoreCase("null"))
		  System.out.println(model);
	  else
		  filterpom.enterModelName(model);
	  
	  if(qty.equalsIgnoreCase("null"))
		  System.out.println(qty);
	  else
		  filterpom.enterQuantity(qty);
	  if(image.equalsIgnoreCase("null") )
		  System.out.println(image);
	  else
		  filterpom.selectImageStatus(image);
	  
	  Thread.sleep(10000);
	  filterpom.clickOnFilter();
	  Thread.sleep(15000);
	  screenShot.captureScreenShot("Filterwith"+status+model);
	 // System.out.println("printing excel.v  sheet");
  } 
}
