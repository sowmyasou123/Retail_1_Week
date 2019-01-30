package com.training.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreLoginOrderPOM {
	private WebDriver driver;

	public PreLoginOrderPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// xpath to click on shopnow
	@FindBy(xpath = "//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")
	private WebElement shopnow;
	// xpath to click on jewellery
	@FindBy(xpath = "//*[@href='http://retail.hommelle.com/product/category?path=467']/span")
	private WebElement clickjewellery;

	@FindBy(xpath = "//*[@href='http://retail.hommelle.com/homeETHNIC2']/span/span/img")
	private WebElement FingerRingImage;
	// xpath to click on cart
	@FindBy(xpath = "//*[@id='cart']/ul/li/h3/a/i")
	private WebElement cart;
	// xpath to click on viewcart
	@FindBy(xpath = "//*[@id='cart']/ul/li/div/div/div[3]/a[1]")
	private WebElement viewcart;
	// xpath to click on add tocart
	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement addToCart;
	@FindBy(xpath = "//a[@class='btn btn-sm'][contains(.,'Checkout')]")
	private WebElement checkOut;
	@FindBy(xpath = "//*[@id='button-account']")
	private WebElement continue1;
	@FindBy(xpath = "//*[@id='input-payment-firstname']")
	private WebElement firstName;
	@FindBy(id = "input-payment-lastname")
	private WebElement lastName;
	@FindBy(id = "input-payment-email")
	private WebElement email;
	@FindBy(id="input-payment-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-payment-address-1")
	private WebElement address1;
	@FindBy(id="input-payment-city")
	private WebElement city;
	@FindBy(id="input-payment-password")
	private WebElement password;
	@FindBy(id="input-payment-confirm")
	private WebElement repassword;
	
	@FindBy(xpath="//*[@id='collapse-payment-method']/div/div[2]/div[1]/label/input")
	private WebElement agreecheckbox2;
	
	@FindBy(xpath="//*[@id='button-register']")
	private WebElement continue2;
	@FindBy(xpath="//*[@id='button-shipping-address']")
	private WebElement continue3;
	
	@FindBy(xpath="//*[@id='button-shipping-method']")
	private WebElement continue4;
	
	@FindBy(xpath="//*[@id='button-payment-method']")
	private WebElement continue5;
	
	@FindBy(xpath="//*[@id='button-confirm']")
	private WebElement confirm;
	@FindBy(xpath="//*[@id='collapse-payment-address']/div/div[2]/div/label/input")
	private WebElement agreecheckbox1;
	
	public void clickOnAgreeCheckBox1(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", agreecheckbox1);
		js.executeScript("arguments[0].click()", agreecheckbox1);
		/*WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse-payment-address']/div/div[2]/div/label/input")));
		agreecheckbox1.click();*/
	}
	public void clickOnContinue3(){
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", continue3);
		//continue3.click();
	}
	public void clickOnConfirm(){
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-confirm']")));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", confirm);
		//this.confirm.click();
	}
	public void clickOnContinue5(){
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-payment-method']")));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", continue5);
		//this.continue5.click();
	}
	public void clickOnContinue4(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", continue4);
		//this.continue4.click();
	}
	
	
	public void ClickOnContinue_2(){
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button-register']")));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", continue2);
		//continue2.click();
	}
	public void clickOnAgreeCheckbox2(){
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse-payment-method']/div/div[2]/div[1]/label/input")));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", agreecheckbox2);
		//agreecheckbox2.click();
	}
	public void re_enterPassword(String repwd){
		this.repassword.clear();
		this.repassword.sendKeys(repwd);
	}
	public void enterPassword(String pwd){
		this.password.clear();
		this.password.sendKeys(pwd);
	}
	
	public void selectState(){
		Select state= new Select(driver.findElement(By.id("input-payment-zone")));
		state.selectByVisibleText("Karnataka");
	}
	public void enterCity(String city){
		this.city.clear();
		this.city.sendKeys(city);
	}
	public void enterAddress(String addr){
		this.address1.clear();
		this.address1.sendKeys(addr);
	}
	public void enterTelephoneNo(String telno){
		this.telephone.clear();
		this.telephone.sendKeys(telno);
		
	}
	
	public void enterFirstName(String frstnme) {
		//this.firstName.clear();
		driver.switchTo().activeElement();
		this.firstName.sendKeys(frstnme);
	}

	

	public void enterLastName(String lstnme) {
		this.lastName.clear();
		this.lastName.sendKeys(lstnme);
	}

	

	public void enterEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void clickOnContinue1() {
		
		 
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", continue1);
		//continue1.click();
	}

	public void clickOnCheckOut() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart']/ul/li/h3/a/i")));
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();
		 
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='btn btn-sm'][contains(.,'Checkout')]"))); 
		 JavascriptExecutor js = ((JavascriptExecutor) driver); 
		 js.executeScript("arguments[0].click()", checkOut);
		
		
		/*Actions action = new Actions(driver);
		action.moveToElement(checkOut).build().perform();*/
		//checkOut.click();

	}

	public void clickAddToCart() throws InterruptedException {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath("//*[@id='button-cart']")));
		 */
		Thread.sleep(10000);
		addToCart.click();
	}

	public void clickViewcart() throws InterruptedException {
		// Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart']/ul/li/div/div/div[3]/a[1]")));
		Actions action = new Actions(driver);
		action.moveToElement(viewcart).build().perform();
		viewcart.click();

	}

	public void mouseOverOnCart() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart']/ul/li/h3/a/i")));
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();
	}

	public void clickOnCosmeticImage() {
		FingerRingImage.click();
	}

	public void moveToNextWindow() {
		ArrayList<String> nextWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(nextWindow.get(1));
	}

	public void clickJewellery() {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")));
		action.moveToElement(shopnow).build().perform();
		shopnow.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@href='http://retail.hommelle.com/product/category?path=467']/span")));
		action.moveToElement(clickjewellery).build().perform();
		clickjewellery.click();

	}

}
