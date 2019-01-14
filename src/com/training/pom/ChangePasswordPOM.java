package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPOM {
	private WebDriver driver;

	public ChangePasswordPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//xpath to click on changeyourpassword link
	@FindBy(linkText = "Change your password")
	private WebElement changePassword;
	//xpath to enter input password
	@FindBy(id = "input-password")
	private WebElement password;
	//xpath to re enter password
	@FindBy(id = "input-confirm")
	private WebElement repassword;
	
	//xpath to click on continue
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continue_next;
	
	//xpath to validate on successmessge after password change
	@FindBy(xpath = "//*[@id='System_nyHsmShk']/div")
	private WebElement successmessage;
	
	//xpath to validate message is displayed when both input password field entry is different
	@FindBy(xpath = "//*[@id='System_epRD9Fax']/form/fieldset/div[2]/div/div")
	WebElement verifyPassword;
	

	//function to validate the success message
	public String validateSuccessmesssage() {
		String actualResult=this.successmessage.getText();
		return actualResult;

	}
	//function to validate error message is displayed when different passwords is entered
	public String verifyPassword(String password, String repassword) {
		this.password.getText();
		this.repassword.getText();
		this.continue_next.click();
		String actualResult=this.verifyPassword.getText();
		return actualResult;
	}
	// to click on continue button
	public void clickContinue() {
		this.continue_next.click();
	}
	// to enter password in the second text box
	public void re_EnterPassowrd(String password) {
		this.repassword.clear();
		this.repassword.sendKeys(password);
	}
	// to enter password in the first textbox
	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	// to click on change password link
	public void clickChangepassword() {
		this.changePassword.click();
	}
}
