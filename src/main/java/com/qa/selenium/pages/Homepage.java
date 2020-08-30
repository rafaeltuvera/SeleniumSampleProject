package com.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.selenium.util.ElementActions;

public class Homepage {

	WebDriver driver;
	ElementActions elementActions;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}
	
	private By HOMEPAGEUNAME = By.xpath("//table//tr[@class='heading3']");

	public String getHomePageDashboardUserName() {

		return elementActions.getElement(HOMEPAGEUNAME).getText();

	}

}
