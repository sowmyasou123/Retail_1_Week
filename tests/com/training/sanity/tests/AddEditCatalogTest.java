package com.training.sanity.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddEditCatalogPOM;
import com.training.pom.LoginAdminPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddEditCatalogTest {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminPOM loginadminpom;
	private AddEditCatalogPOM addeditcatlog;
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
		loginadminpom = new LoginAdminPOM(driver);
		addeditcatlog= new AddEditCatalogPOM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test
  public void AddCategory() {
	  
	  loginadminpom.sendAdminName("admin");
	  loginadminpom.sendAdminPassword("admin@123");
	  loginadminpom.clickLoginBtn();
	  addeditcatlog.mouseOveronMenucatalog();
	  addeditcatlog.mouseOverandClickOncatagories();
	  addeditcatlog.clickOnAddCatagory();
	  addeditcatlog.enterCatagoryName("Clothing");
	  addeditcatlog.enterMetaTagTitle("cloths");
	  addeditcatlog.clickOnSave();
	  String expectedResult="Success: You have modified categories!";
	  String actualResult= addeditcatlog.validatesuccessmsg().getText();
	  System.out.println(actualResult);
	  assertTrue(actualResult.contains(expectedResult));
  }
  
  @Test
  public void Editcategory(){
	  loginadminpom.sendAdminName("admin");
	  loginadminpom.sendAdminPassword("admin@123");
	  loginadminpom.clickLoginBtn();
	  addeditcatlog.mouseOveronMenucatalog();
	  addeditcatlog.mouseOverandClickOncatagories();
	  addeditcatlog.clickOnEditCatalog("newclothing");
	  
  }
}
