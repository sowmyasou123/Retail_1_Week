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

	@FindBy(xpath = "//*[@ class='clear2']/div/div[2]/div/a/span/span/img")
	private WebElement image;
	@FindBy(xpath = "//*[@id='cart']/ul/li/h3/a/i")
	private WebElement cart;
	@FindBy(xpath = "//*[@id='cart']/ul/li/div/div/div[3]/a[1]")
	private WebElement viewcart;
	@FindBy(xpath="//*[@id='button-cart']")
	private WebElement addToCart;
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	private WebElement removeFromCart;
	@FindBy(xpath = "//*[@id='System_V2Exp1o9']/div/p")
	private WebElement Emptycartmessage;
	@FindBy(xpath = "//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")
	private WebElement element;
	@FindBy(xpath = "//*[@href='http://retail.hommelle.com/ethnic']/span")
	private WebElement clickethnic;
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[2]/a")
	private WebElement productName;
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[3]")
	private WebElement model;
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[4]/div/input")
	private WebElement quantity;
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[5]")
	private WebElement price;
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/form/div/table/tbody/tr/td[6]")
	private WebElement total;
	public void clickEthnic() {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")));
		action.moveToElement(element).build().perform();
		element.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@href='http://retail.hommelle.com/ethnic']/span")));
		action.moveToElement(clickethnic).build().perform();
		clickethnic.click();

	}

	public void validateEmptycartMessage() {
		String expectedResult = "Your shopping cart is empty!";
		String actualResult = Emptycartmessage.getText();
		assertEquals(actualResult, expectedResult);
	}

	public void clickRemoveFromCart() {
		removeFromCart.click();
		driver.navigate().refresh();
	}

	public void clickAddToCart() throws InterruptedException {
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='button-cart']")));*/
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
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='cart']/ul/li/h3/a/i")));
		Actions action = new Actions(driver);
		action.moveToElement(cart).build().perform();
	}
	public void validateViewCart(){
		String ex_name, ex_mdl,ex_qnty,ex_prc,ex_totl;
		ex_name="Finger ring";
		ex_mdl="SKU-012";
		ex_qnty="1";
		ex_prc="Rs.500";
		ex_totl="Rs.500";
		String ac_name=productName.getText();
		String ac_mdl=model.getText();
		String ac_qnty=quantity.getAttribute("value");
		String ac_prc=price.getText();
		String ac_totl=total.getText();
		assertEquals(ac_name, ex_name);
		assertEquals(ac_mdl, ex_mdl);
		assertEquals(ac_qnty, ex_qnty);
		assertEquals(ac_prc, ex_prc);
		assertEquals(ac_totl, ex_totl);
	}
	public void clickViewcart() throws InterruptedException {
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart']/ul/li/div/div/div[3]/a[1]")));
		Actions action = new Actions(driver);
		action.moveToElement(viewcart).build().perform();
		viewcart.click();
		
		
	}
}
