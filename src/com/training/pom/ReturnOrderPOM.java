package com.training.pom;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnOrderPOM {
	private WebDriver driver;
	
	public ReturnOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a")
	private WebElement icon;
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[3]/a/span")
	private WebElement myorders;
	@FindBy(xpath="//*[@id='System_epRD9Fax']/div/div/table/tbody/tr/td[6]/a[2]")
	private WebElement returnicon;
	@FindBy(xpath="//*[@id='input-comment']")
	private WebElement returnreason;
	@FindBy(xpath="//*[@type='submit' and @value='Submit']")
	private WebElement submit;
	@FindBy(xpath="//*[@id='System_epRD9Fax']/div/p[1]")
	private WebElement message1;
	@FindBy(xpath="//*[@id='System_epRD9Fax']/div/p[2]")
	private WebElement message2;
	public String returnSuccessMessage_1(){
		String returnmsg= message1.getText();
		return returnmsg;
	}
	public String returnSuccessMessage_2(){
		String returnmsg= message2.getText();
		return returnmsg;
	}
	public void clickOnSubmit(){
		submit.click();
	}
	public void mouseOverOnMyOrdersandClick(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[3]/a/span")));
		action.moveToElement(myorders).build().perform();
		myorders.click();
		
	}
	public void viewOrder(){
		List<WebElement>orderids=driver.findElements(By.xpath("//*[@id='System_epRD9Fax']/div/table/tbody/tr/td[7]/a"));
		orderids.get(0).click();
	}
	public void ClickOnReturn(){
		returnicon.click();
	}
	public void clickOnReturnRadio(){
		List<WebElement>radiobtns=driver.findElements(By.xpath("//*[@name='return_reason_id']"));
		radiobtns.get(0).click();
	}
	public void clickOnProductRadio(){
		List<WebElement> radio= driver.findElements(By.xpath("//*[@name='opened']"));
		radio.get(0).click();
	}
	public void enterReasonforReturn(){
		returnreason.sendKeys("product is faulty");
	}
	public void mouseOverOnIcon(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a")));
		action.moveToElement(icon).build().perform();
		
	}

}
