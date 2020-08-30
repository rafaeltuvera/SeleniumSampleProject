package com.qa.selenium.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.selenium.basepage.BasePage;
import com.qa.selenium.pages.Homepage;
import com.qa.selenium.pages.LoginPage;
import com.qa.selenium.pojo.Credentials;

public class LoginPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	Homepage homepage;
	LoginPage loginPage;
	Credentials credentials;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.initDriver(browser);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("USER_NAME"), prop.getProperty("PASSWORD"));
	}
	
	@Test (groups = {"testtwo"})
	public void verifyLoginPage() {
		loginPage.loginToBank(credentials);
		Assert.assertTrue(loginPage.verifyHeaderTitle().isDisplayed(), "UNABLE TO LOCATE ELEMENT!");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
