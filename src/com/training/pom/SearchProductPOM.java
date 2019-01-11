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
	@FindBy(xpath="//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span") 
	private WebElement element;
	
	@FindBy(xpath="//*[@href='http://retail.hommelle.com/ethnic']/span")
	private WebElement clickethnic;
	
	@FindBy(xpath="//*[@id='ProductsSystem_QQI8r357']/nav/div/div[3]/select")
	private WebElement sortby;
	@FindBy(xpath="//*[@src='http://retail.hommelle.com/image/cache/placeholder-350x400.png' and @alt='bottle']")
	private WebElement bottle;
	@FindBy(xpath="//*[@href='http://retail.hommelle.com/ethnic/home?sort=rating&order=DESC']/span/span/img")
	private WebElement image;
	@FindBy(xpath="//*[@id='ProductRatingSystem_E8ESK1KA']/div/span[1]")
	private WebElement review;
	

	
	public void clickEthnic(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Menu_VIfWm2LT']/nav/ul/li[2]/a/span")));
		action.moveToElement(element).build().perform();
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='http://retail.hommelle.com/ethnic']/span")));
		action.moveToElement(clickethnic).build().perform();
		clickethnic.click();
		
	}
	public void validateSortByValues(){
		Select sort= new Select(sortby);
		List<WebElement>sortbylist=sort.getOptions();
		for(int i=0;i<sortbylist.size();i++){
			System.out.println(sortbylist.get(i).getText());
		}
		
	
	}
	public void clickOnSortByName(){
		Select sort= new Select(sortby);
		sort.selectByVisibleText("Name (A - Z)");
		String expected="bottle";
		String actual= bottle.getAttribute("alt");
		assertEquals(actual, expected);
		}
	
	public void clickOnSortByRatings(){
		Select sort= new Select(sortby);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		sort.selectByVisibleText("Rating (Highest)");
		image.click();
		ArrayList<String> nextwindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(nextwindow.get(1));
		/*wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='ProductRatingSystem_E8ESK1KA']/div/span[1]")));*/
		String expected="5/5";
		String actual=review.getText();
		
		assertEquals(actual, expected);
		
		
	}
}
