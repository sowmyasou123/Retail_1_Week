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

	@FindBy(linkText = "Change your password")
	private WebElement changePassword;

	@FindBy(id = "input-password")
	private WebElement password;
	@FindBy(id = "input-confirm")
	private WebElement repassword;

	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continue_next;
	@FindBy(xpath = "//*[@id='System_nyHsmShk']/div")
	private WebElement successmessage;
	@FindBy(xpath = "//*[@id='System_epRD9Fax']/form/fieldset/div[2]/div/div")
	WebElement verifyPassword;

	public void validateSuccessmesssage() {
		String expectedResult="Success: Your password has been successfully updated.";
		String actualResult=this.successmessage.getText();
		assertEquals(actualResult, expectedResult);

	}

	public void verifyPassword(String password, String repassword) {
		this.password.getText();
		this.repassword.getText();
		this.continue_next.click();
		String expectedResult="Password confirmation does not match password!";
		String actualResult=this.verifyPassword.getText();
		assertEquals(actualResult,expectedResult);
	}

	public void clickContinue() {
		this.continue_next.click();
	}

	public void re_EnterPassowrd(String password) {
		this.repassword.clear();
		this.repassword.sendKeys(password);
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickChangepassword() {
		this.changePassword.click();
	}
}
