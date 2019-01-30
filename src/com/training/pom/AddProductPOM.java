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

public class AddProductPOM {
	private WebDriver driver;

	public AddProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='menu-catalog']/a")
	private WebElement menucatalog;
	@FindBy(xpath="//*[@id='menu-catalog']/ul/li[2]/a")
	private WebElement products;
	
	@FindBy(xpath="//*[@id='content']/div/div/div/a")
	private WebElement product;
	@FindBy(xpath="//*[@id='input-name1']")
	private WebElement productName;
	@FindBy(xpath="//*[@id='input-meta-title1']")
	private WebElement metaTagTitle;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[2]/a")
	private WebElement tabData;
	@FindBy(xpath="//*[@id='input-model']")
	private WebElement modelName;
	@FindBy(xpath="//*[@id='input-price']")
	private WebElement price;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a")
	private WebElement links;
	
	@FindBy(xpath="//*[@id='input-quantity']")
	private WebElement quantity;
	@FindBy(xpath="//*[@id='input-category']")
	private WebElement category;
	
	@FindBy(xpath="//*[@class='dropdown-menu']/li/a")
	private WebElement element;
	@FindBy(xpath="//*[@id='content']/div/div/div/button")
	private WebElement save;
	@FindBy(xpath="//*[@id='input-keyword']")
	private WebElement SEOURL;
	@FindBy(xpath="//*[@id='content']/div[2]/div")
	private WebElement successMsg;
	@FindBy(xpath="//*[@id='form-product']/ul/li/a")
	private WebElement generalTab;
	@FindBy(xpath="//*[@id='language1']/div[1]/div/div")
	private WebElement productNameErrMsg;
	
	@FindBy(xpath="//*[@id='language1']/div[3]/div/div")
	private WebElement metatagErrMsg;
	@FindBy(xpath="//*[@id='tab-data']/div[1]/div/div")
	private WebElement modelErrMsg;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div")
	private WebElement formErrMsg;
	
	public void clickOnGeneralTab(){
		generalTab.click();
	}
	public String getFormErrMsg(){
		String errmsg= formErrMsg.getText();
		return errmsg;
	}
	public String getModelNameValidateMsg(){
		String errmsg= modelErrMsg.getText();
		return errmsg;
	}
	
	public String getProdcutNameValidateMsg(){
		String errmsg=productNameErrMsg.getText();
		return errmsg;
	}
	public String getMetaTagValidateMsg(){
		String errmsg=metatagErrMsg.getText();
		return errmsg;
	}
	
	public String getSuccessMsg(){
		String success=successMsg.getText();
		return success;
	}
	
	public void clickOnLinks(){
		this.links.click();
	}
	
	public void enterSEOURL(String seourl){
		this.SEOURL.clear();
		this.SEOURL.sendKeys(seourl);
	}
	
	public void clickOnSave(){
		this.save.click();
	}
	
	public void selectCategory(String jew){
		Actions action= new Actions(driver);
		category.sendKeys(jew);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(this.element));
		action.moveToElement(this.element).build().perform();
		action.doubleClick(this.element).build().perform();
		
	}
	
	
	public void enterQuantity(String qty){
		this.quantity.clear();
		this.quantity.sendKeys(qty);
	}
	
	public void enterPrice(String price){
		this.price.clear();
		this.price.sendKeys(price);
		
	}
	public void enterModelName(String model){
		this.modelName.clear();
		this.modelName.sendKeys(model);
	}
	public void clickOnDataTab(){
		tabData.click();
	}
	
	public void enterMetaTagTitle(String metatag){
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metatag);
	}
	
	public void enterProductName(String prdnme){
		this.productName.clear();
		this.productName.sendKeys(prdnme);
	}
	public void ClickOnAddProduct(){
		product.click();
	}
	
	
	
	public void mouseOverandClickOnProducts(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-catalog']/ul/li[2]/a")));
		action.moveToElement(products).build().perform();
		products.click();
		
	}

	public void mouseOveronMenucatalog(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-catalog']/a")));
		action.moveToElement(menucatalog).build().perform();
	}
	

}
