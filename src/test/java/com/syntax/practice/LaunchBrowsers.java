package com.syntax.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchBrowsers {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/SeleniumTask/src/test/resources/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com/");
		Thread.sleep(1000);
		driver.quit();
		
		System.setProperty("webdriver.gecko.driver", "/Users/natalia/eclipse-workspace/SeleniumTask/src/test/resources/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://amazon.com/");
		Thread.sleep(1000);
		driver.quit();
		
		driver = new SafariDriver();
		driver.get("https://amazon.com/");
		Thread.sleep(1000);
		driver.quit();
		
		
	/*	
		System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://amazon.com/");
		Thread.sleep(1000);
		driver.quit();
	*/
		
	}

}
