package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeleteCategoryPOM {
	
	private WebDriver driver;
	
	public DeleteCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	private WebElement FirstRowCatagory;
	@FindBy(xpath="//table/tbody/tr[2]/td[1]")
	private WebElement SecRowCategory;
	@FindBy(xpath="//*[@id='content']/div/div/div/button")
	private WebElement DelCategories;
	
	
	public void clickOnDelete(){
		DelCategories.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	public boolean validateCategoriesDeleted(){
		String firstCatName= driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		String secCatName= driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		if(firstCatName!="AA" && secCatName!="AB")
			return true;		
		return false;
		
				}
	public void clickOnFirstCheckbox(){
		FirstRowCatagory.click();
	}
	public void clickOnSecCheckbox(){
		SecRowCategory.click();
	}
	
	
}
