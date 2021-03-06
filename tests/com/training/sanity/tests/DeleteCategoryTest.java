package com.training.sanity.tests;

import org.testng.annotations.Test;

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
import com.training.pom.AddEditCategoryPOM;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.LoginAdminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteCategoryTest {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminPOM loginadminpom;
	private AddEditCategoryPOM addeditcategory;
	private DeleteCategoryPOM deletecategory;
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
		if(browser.equalsIgnoreCase("chrome")){
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginadminpom = new LoginAdminPOM(driver);
		addeditcategory= new AddEditCategoryPOM(driver);
		deletecategory= new DeleteCategoryPOM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		}
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void AddCategories(){
		 loginadminpom.sendAdminName("admin");
		  loginadminpom.sendAdminPassword("admin@123");
		  loginadminpom.clickLoginBtn();
		  addeditcategory.mouseOveronMenucatalog();
		  addeditcategory.mouseOverandClickOncatagories();
		  //to add first category
		  addeditcategory.clickOnAddCatagory();
		  addeditcategory.enterCatagoryName("AA");
		  addeditcategory.enterMetaTagTitle("aaa");
		  addeditcategory.clickOnSave();
		  addeditcategory.mouseOveronMenucatalog();
		  addeditcategory.mouseOverandClickOncatagories();
		  // to add second category
		  addeditcategory.clickOnAddCatagory();
		  addeditcategory.enterCatagoryName("AB");
		  addeditcategory.enterMetaTagTitle("abb");
		  addeditcategory.clickOnSave();
	}
  @Test (dependsOnMethods={"AddCategories"})
  public void DeleteCategories() {
	  loginadminpom.sendAdminName("admin");
	  loginadminpom.sendAdminPassword("admin@123");
	  loginadminpom.clickLoginBtn();
	  addeditcategory.mouseOveronMenucatalog();
	  addeditcategory.mouseOverandClickOncatagories();
	  // to click on first 2 category list
	  deletecategory.clickOnFirstCheckbox();
	  deletecategory.clickOnSecCheckbox();
	  deletecategory.clickOnDelete();
	  boolean expected= true;
	 boolean actual= deletecategory.validateCategoriesDeleted();
	 assertEquals(actual, expected);
	  
	  
  }
}
