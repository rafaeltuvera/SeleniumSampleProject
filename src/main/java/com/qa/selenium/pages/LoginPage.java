package com.qa.selenium.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.qa.selenium.basepage.BasePage;
import com.qa.selenium.pojo.Credentials;
import com.qa.selenium.util.ElementActions;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementActions elementActions;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}
	
	//locators
	private By USER_NAME = By.name("uid");
	private By PASSWORD = By.name("password");
	private By BTN_LOGIN = By.name("btnLogin");
	private By HEADER_TITLE = By.xpath("//h2[@class='barone' and contains(text(),'Guru99 Bank')]");
	
	public WebElement verifyHeaderTitle() {
		return elementActions.elementIsDisplayed(HEADER_TITLE);
	}
	
	public Homepage loginToBank(Credentials credentials) {
		elementActions.sendKeys(USER_NAME, credentials.getUsername());
		elementActions.sendKeys(PASSWORD, credentials.getPassword());
		elementActions.clickElement(BTN_LOGIN);
		
//		String parentWindow = driver.getWindowHandle();
//		Set<String> w = driver.getWindowHandles();
//		Iterator<String> itr = w.iterator();
//		
//		while(itr.hasNext()) {
//			String child = itr.next();
//			if(!child.equalsIgnoreCase(parentWindow)) {
//				driver.switchTo().window(child);
//			}
//		}	
		return new Homepage(driver);
	}
	
}
