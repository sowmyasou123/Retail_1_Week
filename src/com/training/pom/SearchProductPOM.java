package com.training.pom;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SearchProductPOM {
	private WebDriver driver;
	
	
	public SearchProductPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	//xpath to click on Shopnow
	@FindBy(xpath="//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span") 
	private WebElement shopnow;
	
	//xpath to click on Jewellery
	@FindBy(xpath="//*[@href='http://retail.hommelle.com/product/category?path=467']/span")
	private WebElement clickJewellery;
	
	//xpath to select sortby list box
	@FindBy(xpath="//*[@id='ProductsSystem_QQI8r357']/nav/div/div[3]/select")
	private WebElement sortby;
	//xpath to get cosmetics image
	@FindBy(xpath="//*[@src='http://retail.hommelle.com/image/cache/placeholder-350x400.png' and @alt='cosmetics']")
	private WebElement cosmetics;
	
	//xpath to get highest rating of the products
	@FindBy(xpath="//*[@id='ProductsSystem_QQI8r357']/div[1]/div/div/div[3]/div/div/div[1]/div/span")
	private WebElement images;
	
	

	//function to click on Jewellery category in SHOPNOW Menu
	public void clickJewellery(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")));
		action.moveToElement(shopnow).build().perform();
		shopnow.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='http://retail.hommelle.com/product/category?path=467']/span")));
		action.moveToElement(clickJewellery).build().perform();
		clickJewellery.click();
		
	}
	//function to validate values of sortby list box
	public void validateSortByValues(){
		Select sort= new Select(sortby);
		List<WebElement>sortbylist=sort.getOptions();
		for(int i=0;i<sortbylist.size();i++){
			System.out.println(sortbylist.get(i).getText());
		}
		
	
	}
	//function to click on list value:Name (A - Z)
	public String clickOnSortByName(){
		Select sort= new Select(sortby);
		sort.selectByVisibleText("Name (A - Z)");
		String actual= cosmetics.getAttribute("alt");
		return actual;
		
		}
	//function to click on list value:Rating (Highest)
	public void clickOnSortByRatings(){
		Select sort= new Select(sortby);
		sort.selectByVisibleText("Rating (Highest)");
	}
	public String[] validateHighestRating(){
		String ratingimg[] = null;
		List<WebElement> ratingImages= driver.findElements(By.xpath("//*[@id='ProductsSystem_QQI8r357']/div[1]/div/div/div[3]/div/div/div[1]/div/span"));
		 ratingimg[0]=ratingImages.get(0).getText();
		ratingimg[1]=ratingImages.get(1).getText();
		return ratingimg;
		
		
	}
}
