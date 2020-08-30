package com.qa.selenium.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.selenium.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	public Properties prop;
	private static String CONFIG_PATH = "/src/main/java/com/qa/selenium/config/config.properties";
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	
	public WebDriver initDriver(String browser) {
		//String browserss = prop.getProperty("BROWSER");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}
//		e_driver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("URL"));
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("URL"));
		
		return getDriver();
	}

	public Properties init_prop() {
		prop = new Properties();
		String currentDir = System.getProperty("user.dir") + CONFIG_PATH;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(currentDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found!");
		}

		return prop;
	}
	
	public String getScreenShot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir") + "screenshots" + System.currentTimeMillis() +".png";
		File destination = new File(screenShotPath);
		
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenShotPath;
	}

}
