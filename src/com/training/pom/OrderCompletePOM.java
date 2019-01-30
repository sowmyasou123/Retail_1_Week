package com.training.pom;

import java.util.ArrayList;
import java.util.List;

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

public class OrderCompletePOM {
	private WebDriver driver;
	JavascriptExecutor js = ((JavascriptExecutor) driver);

	public OrderCompletePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu-sale']/a")
	private WebElement menusale;
	@FindBy(xpath = "//*[@id='menu-sale']/ul/li[1]/a")
	private WebElement orders;
	@FindBy(xpath = "//*[@id='input-order-status']")
	private WebElement orderStatus;

	@FindBy(xpath = "//*[@class='note-editing-area']/div[2]/p")
	private WebElement comment;

	@FindBy(xpath = "//*[@id='button-history']")
	private WebElement addhistory;

	public void addHistory() {
		addhistory.click();
	}

	public void addComment(String com) {
		this.comment.sendKeys(com);
	}

	public void selectOrderStatus() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", orderStatus);
		Select status = new Select(orderStatus);
		status.selectByVisibleText("Complete");

	}

	public void mouseOverandClickOnOrders() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-sale']/ul/li[1]/a")));
		action.moveToElement(orders).build().perform();
		js.executeScript("arguments[0].click()", orders);
		// orders.click();

	}

	public void mouseOveronMenuSale() {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-sale']/a")));
		action.moveToElement(menusale).build().perform();
	}

	public void clickOnViewOrder(String custnme, String date) throws InterruptedException {
		List<WebElement> orderTotal = driver.findElements(By.xpath("//table/tbody/tr"));
		int orderSize = orderTotal.size();

		for (int i = 1; i < 26; i++) {

			if (i != 25) {
				WebElement customerName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]"));
				String custName = customerName.getText();
				WebElement orderStatus = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
				String ordstatus = orderStatus.getText();
				WebElement orderCreateDate = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]"));
				String ordDate = orderCreateDate.getText();
				WebElement view = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[8]"));

				if (custName.equalsIgnoreCase(custnme) && ordstatus.equalsIgnoreCase("Pending")
						&& ordDate.equalsIgnoreCase(date)) {

					view.click();
					break;
				}
			} else {
				// break;
				if (i == 25) {
					WebElement customerName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]"));
					String custName = customerName.getText();
					WebElement orderStatus = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
					String ordstatus = orderStatus.getText();
					WebElement orderCreateDate = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]"));
					String ordDate = orderCreateDate.getText();
					WebElement view = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[8]"));
					if (custName.equalsIgnoreCase(custnme) && ordstatus.equalsIgnoreCase("Pending")
							&& ordDate.equalsIgnoreCase(date)) {

						view.click();
						break;
					}
					WebElement secondPage = driver
							.findElement(By.xpath("//*[@id='content']/div[2]/div/div[2]/div[2]/div/ul/li[2]/a"));
					js.executeScript("arguments[0].scrollIntoView();", secondPage);
					secondPage.click();
					driver.navigate().refresh();
					Thread.sleep(5000);
					for (int k = 1; k < 26; k++) {
						customerName = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[3]"));
						custName = customerName.getText();
						orderStatus = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[4]"));
						ordstatus = orderStatus.getText();
						orderCreateDate = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[6]"));
						ordDate = orderCreateDate.getText();
						view = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[8]"));

						if (k != 25) {
							if (custName.equalsIgnoreCase(custnme) && ordstatus.equalsIgnoreCase("Pending")
									&& ordDate.equalsIgnoreCase(date)) {

								view.click();
								break;
							}
						} else if (k == 25) {
							custName = customerName.getText();
							orderStatus = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[4]"));
							ordstatus = orderStatus.getText();
							orderCreateDate = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[6]"));
							ordDate = orderCreateDate.getText();
							view = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[8]"));

							if (custName.equalsIgnoreCase(custnme) && ordstatus.equalsIgnoreCase("Pending")
									&& ordDate.equalsIgnoreCase(date)) {

								view.click();
								break;
							}
							WebElement thirdPage = driver.findElement(
									By.xpath("//*[@id='content']/div[2]/div/div[2]/div[2]/div/ul/li[5]/a"));
							js.executeScript("arguments[0].scrollIntoView();", thirdPage);
							thirdPage.click();

							driver.navigate().refresh();
							Thread.sleep(5000);
							for (int l = 1; l < orderSize; l++) {

								if (l != 25) {
									customerName = driver.findElement(By.xpath("//table/tbody/tr[" + l + "]/td[3]"));
									custName = customerName.getText();
									orderStatus = driver.findElement(By.xpath("//table/tbody/tr[" + l + "]/td[4]"));
									ordstatus = orderStatus.getText();
									orderCreateDate = driver.findElement(By.xpath("//table/tbody/tr[" + l + "]/td[6]"));
									ordDate = orderCreateDate.getText();
									view = driver.findElement(By.xpath("//table/tbody/tr[" + l + "]/td[8]"));
									if (custName.equalsIgnoreCase(custnme) && ordstatus.equalsIgnoreCase("Pending")
											&& ordDate.equalsIgnoreCase(date)) {

										view.click();
										break;
									}
								} // close of if l!=25 block
							} // close of for l block

						} // close of if k=25 block
					}
				} // close of if i==25 block

			} // close of else block of if i!=25

		} // close of for i block

	}

}
