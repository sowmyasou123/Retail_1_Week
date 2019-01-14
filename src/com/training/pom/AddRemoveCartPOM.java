package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveCartPOM {
	private WebDriver driver;

	public AddRemoveCartPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// xpath to click on image
	@FindBy(xpath = "//*[@src='http://retail.hommelle.com/image/cache/placeholder-350x400.png' and @alt='cosmetics']")
	private WebElement image;
	// xpath to click on cart
	@FindBy(xpath = "//*[@id='cart']/ul/li/h3/a/i")
	private WebElement cart;
	// xpath to click on viewcart
	@FindBy(xpath = "//*[@id='cart']/ul/li/div/div/div[3]/a[1]")
	private WebElement viewcart;
	// xpath to click on add tocart
	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement addToCart;
	// xpath to click on removefromcart
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	private WebElement removeFromCart;
	// xpath to validate empty cart message
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/div/p")
	private WebElement Emptycartmessage;
	// xpath to click on shopnow
	@FindBy(xpath = "//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")
	private WebElement shopnow;
	// xpath to click on jewellery
	@FindBy(xpath = "//*[@href='http://retail.hommelle.com/product/category?path=467']/span")
	private WebElement clickjewellery;
	// xpath to get product name
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[2]/a")
	private WebElement productName;
	//xpath to get model name
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[3]")
	private WebElement model;
	//xpath to get quantity of the product
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[4]/div/input")
	private WebElement quantity;
	//xpath to get price of the product
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[5]")
	private WebElement price;
	//xpath to get total price of the product
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[6]")
	private WebElement total;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getModel() {
		return model;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getTotal() {
		return total;
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

	public String validateEmptycartMessage() {
		String expectedResult = "Your shopping cart is empty!";
		String actualResult = Emptycartmessage.getText();
		return actualResult;
	}

	public void clickRemoveFromCart() {
		removeFromCart.click();
		driver.navigate().refresh();
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

	public void clickOnImage() {
		image.click();

	}

	public void moveToNextWindow() {
		ArrayList<String> nextwindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(nextwindow.get(1));
	}

	public void mouseOverOnCart() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart']/ul/li/h3/a/i")));
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();
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
}
