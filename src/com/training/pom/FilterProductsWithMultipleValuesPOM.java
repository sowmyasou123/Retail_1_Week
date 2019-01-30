package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterProductsWithMultipleValuesPOM {
	private WebDriver driver;

	public FilterProductsWithMultipleValuesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='input-name']")
	private WebElement productName;
	
	@FindBy(xpath="//*[@id='input-price']")
	private WebElement price;
	@FindBy(xpath="//*[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//*[@id='input-quantity']")
	private WebElement quantity;
	
	@FindBy(xpath="//*[@id='button-filter']")
	private WebElement filter;
	
	@FindBy(xpath="//*[@id='input-image']")
	private WebElement image;
	
	@FindBy(xpath="//*[@class='form-group']/ul/li/a")
	private WebElement ProductNamedropdown;
	
	
	public void selectImageStatus(String status){
		Select imageStatus= new Select(image);
		imageStatus.selectByVisibleText(status);
	}
	public void clickOnFilter(){
		this.filter.click();
	}
	
	public void enterQuantity(String qty){
		this.quantity.clear();
		this.quantity.sendKeys(qty);
	}
	
	public void enterModelName(String model){
		this.model.clear();
		this.model.sendKeys(model);
	}
	 
	public void selectStatus(String value){
		Select status= new Select(driver.findElement(By.xpath("//*[@id='input-status']")));
		status.selectByVisibleText(value);
		
	}
	public void enterPrice(String price){
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void enterProductName(String prodnme){
		Actions action= new Actions(driver);
		this.productName.clear();
		this.productName.sendKeys(prodnme);
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(this.ProductNamedropdown));
		action.moveToElement(this.ProductNamedropdown).build().perform();
		action.doubleClick(this.ProductNamedropdown).build().perform();
	}
}
