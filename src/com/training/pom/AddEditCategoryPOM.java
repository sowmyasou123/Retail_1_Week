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

public class AddEditCategoryPOM {
	private WebDriver driver;
	
	public AddEditCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='menu-catalog']/a")
	private WebElement menucatalog;
	
	@FindBy(xpath="//*[@id='menu-catalog']/ul/li/a")
	private WebElement catagories;
	@FindBy(xpath="//*[@id='content']/div/div/div/a")
	private WebElement addcatagory;
	@FindBy(xpath="//*[@id='input-name1']")
	private WebElement catagoryName;
	@FindBy(xpath="//*[@id='input-meta-title1']")
	private WebElement metaTagTitle;
	@FindBy(xpath="//*[@id='content']/div/div/div/button")
	private WebElement savebtn;
	@FindBy(xpath="//*[@id='content']/div[2]/div")
	private WebElement successMsg;
	@FindBy(xpath="//*[@id='content']/div/div/div/button")
	private WebElement editSaveBtn;
	
	public void clickOnAfterEditSave(){
		editSaveBtn.click();
	}
	
	public WebElement validatesuccessmsg(){
		return successMsg;
	}
	
	public void clickOnSave(){
		savebtn.click();
	}
	
	public void enterMetaTagTitle(String metatag){
		metaTagTitle.clear();
		metaTagTitle.sendKeys(metatag);
	}
	
	public void enterCatagoryName(String catagory){
		catagoryName.clear();
		catagoryName.sendKeys(catagory);
	}
	public void clickOnAddCatagory(){
		addcatagory.click();
	}
	
	public void mouseOverandClickOncatagories(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-catalog']/ul/li/a")));
		action.moveToElement(catagories).build().perform();
		catagories.click();
		
	}
	
	public void mouseOveronMenucatalog(){
		Actions action= new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-catalog']/a")));
		action.moveToElement(menucatalog).build().perform();
	}
	
	public void clickOnEditCatalog(String newcloth){
		List<WebElement>catgRowSize=driver.findElements(By.xpath("//table/tbody/tr"));
		int rowSize=catgRowSize.size();
		System.out.println(rowSize);
		for(int i=1;i<=rowSize;i++){
			WebElement secColumn= driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
			String ColumnText= secColumn.getText();
			
			if(ColumnText.equalsIgnoreCase("Clothing")){
				driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]/a")).click();
				metaTagTitle.clear();
				metaTagTitle.sendKeys(newcloth);
				break;
			}
			else{
				continue;
			}
	}
	}
	
}
