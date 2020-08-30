package com.qa.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 30);
		action = new Actions(this.driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		waitForElementPresent(locator);
		try {
			element = driver.findElement(locator);
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		return element;
	}

	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement elementIsDisplayed(By locator) {
		 return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public void clickElement(By locator) {
		waitForElementPresent(locator);
		getElement(locator).click();
	}
	
	public void sendKeys(By locator, String value) {
		waitForElementPresent(locator);
		getElement(locator).sendKeys(value);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void moveToElement(By locator) {
		action.moveToElement(getElement(locator)).build().perform();
	}
	
	public void dragAndDrop(By fromLocator, By toLocator) {
		action.dragAndDrop(getElement(fromLocator), getElement(toLocator)).build().perform();
	}
	
	public void scrollIntoView(By locator) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}
	
	public void jsClick(By locator) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", getElement(locator));
		
	}
	
}
