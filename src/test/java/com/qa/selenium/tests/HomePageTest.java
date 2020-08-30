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

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	Credentials credentials;
	BasePage basePage;
	Homepage homePage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.initDriver(browser);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("USER_NAME"), prop.getProperty("PASSWORD"));
		homePage = loginPage.loginToBank(credentials);
	}
	
	@Test
	public void verifyUserName() {
		Assert.assertTrue(homePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		Assert.assertEquals(homePage.getHomePageDashboardUserName().toLowerCase(), "manger id : mgr123");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
