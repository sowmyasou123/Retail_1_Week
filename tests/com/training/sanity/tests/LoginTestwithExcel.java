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

import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTestwithExcel {
	
	private WebDriver driver;
	private String baseUrl;
	private String fileName;
	private LoginPOM loginPOM;
	private ApachePOIExcelRead readexceldata;
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
		readexceldata= new ApachePOIExcelRead();
		baseUrl = properties.getProperty("baseURL");
		fileName= properties.getProperty("excelfile1");
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
  public void LoginTestwithMultipleData() {
	  String data[][]= readexceldata.getExcelContent(fileName,0);
	  System.out.println(data[0][0]);
	  loginPOM.sendUserName(data[0][0]);
	  loginPOM.sendPassword(data[0][1]);
	  loginPOM.clickLoginBtn();
	  
  }
  @Test
  public void LoginTestwithMultipledata() {
	  String data[][]= readexceldata.getExcelContent(fileName,0);
	  System.out.println(data[1][0]);
	  loginPOM.sendUserName(data[1][0]);
	  loginPOM.sendPassword(data[1][1]);
	  loginPOM.clickLoginBtn();
	  
  }
}
