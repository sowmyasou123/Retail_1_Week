package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddEditCategoryPOM;
import com.training.pom.LoginAdminPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategoryDBTest {
	private WebDriver driver;
	private String adminUrl;
	private AddEditCategoryPOM addcategory;
	private LoginAdminPOM loginadminpom;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addcategory = new AddEditCategoryPOM(driver);
		loginadminpom = new LoginAdminPOM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(adminUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}	
	
  @Test(dataProvider = "db-inputs_1", dataProviderClass = LoginDataProviders.class)
  public void AddCategoryDBTest(String categoryname, String metatagtitle) throws InterruptedException {
	  
	  loginadminpom.sendAdminName("admin");
	  loginadminpom.sendAdminPassword("admin@123");
	  loginadminpom.clickLoginBtn();
	  Thread.sleep(4000);
	  screenShot.captureScreenShot("adminloginscreen");
	  addcategory.mouseOveronMenucatalog();
	  addcategory.mouseOverandClickOncatagories();
	  Thread.sleep(5000);;
	  addcategory.clickOnAddCatagory();
	  Thread.sleep(3000);
	  addcategory.enterCatagoryName(categoryname);
	  addcategory.enterMetaTagTitle(metatagtitle);
	  Thread.sleep(5000);
	 String actualcategory= addcategory.getCategoryName();
	 String actualmetatag= addcategory.getmetaTagTitle();
	  screenShot.captureScreenShot("addednewcatagoryDBTest");
	  addcategory.clickOnSave();
	  System.out.println(actualcategory);
	  System.out.println(actualmetatag);
	  assertEquals(actualcategory, categoryname);
	  assertEquals(actualmetatag, metatagtitle);
	  screenShot.captureScreenShot("successmessageDBTest");
	  
	  
  }
}
