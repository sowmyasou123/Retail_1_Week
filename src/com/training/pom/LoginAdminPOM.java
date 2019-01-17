package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginAdminPOM {
	private WebDriver driver; 
	
	public LoginAdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username")
	private WebElement adminName; 
	
	@FindBy(name="password")
	private WebElement adminPassword;
	@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/div")
	private WebElement errorPasswordMsg;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn; 
	
	public void sendAdminName(String adminName) {
		this.adminName.clear();
		this.adminName.sendKeys(adminName);
	}
	
	public void sendAdminPassword(String adminPassword) {
		this.adminPassword.clear(); 
		this.adminPassword.sendKeys(adminPassword); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public WebElement ErrorPasswordmessage(){
		return errorPasswordMsg;
	}
}
