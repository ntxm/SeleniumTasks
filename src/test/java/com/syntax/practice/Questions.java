package com.syntax.practice;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.Constants;

public class Questions {

	public static void main(String[] args) throws InterruptedException {

		// set properties for driver
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		// initialize driver (Chrome in this case)
		WebDriver driver = new ChromeDriver();
		// navigate to the page
		driver.get("http://the-internet.herokuapp.com/");

		
		//============ PREPLY.COM =================// 
		
		driver.navigate().to("https://preply.com");
		Thread.sleep(2000);

		/**
		 * How to get the text of a web element? How to get an attribute value using
		 * Selenium WebDriver?
		 */

		String text = driver.findElement(By.xpath("//a[@id='find-tutors']")).getText();
		System.out.println(text);

		String attributeText = driver.findElement(By.xpath("//a[@id='find-tutors']")).getAttribute("href");
		System.out.println(attributeText);
		
		
		
		
		driver.navigate().back();
		
		/**
		 * Handle Dropdown menu
		 */
		
		
		
		driver.findElement(By.linkText("Dropdown")).click();
		
		Select select = new Select(driver.findElement(By.id("dropdown")));
		
		List<WebElement> list = select.getAllSelectedOptions();
		
		select.selectByVisibleText("Option 2");
		select.selectByIndex(0);
		select.selectByValue("2");

		
		
		
		
		/**
		 * Handle Window (Windows)
		 * getWindowHandle() and getWindowsHandles();
		 */
		
		driver.navigate().to("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		//get current window ID
		String winID = driver.getWindowHandle();
		System.out.println(winID);
		
		
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(1000);
		
		
		//get Window ID for all Windows (Tabs)
		Set<String> setWinID = driver.getWindowHandles();
		System.out.println(setWinID);

		
		for(String windowID: setWinID) {
			driver.switchTo().window(windowID);
			Thread.sleep(1000);
		}
		
		
		
		/**
		 * Handle frames
		 */
		
		driver.navigate().to("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		Thread.sleep(2000);

		
		//switch to frame by name
		driver.switchTo().frame("frame-top");
		//switch to frame by Index
		driver.switchTo().frame(1);
		
		
		/**
		 * Handle alerts
		 */
		
		driver.navigate().to("http://the-internet.herokuapp.com/");
		driver.findElement(By.partialLinkText("Alerts")).click();
		
		//accept (ok)
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//dismiss (cancel)
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(1000);
		alert.dismiss();
		
		//send text
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		alert.sendKeys("bla-bla text");
		alert.accept();
		Thread.sleep(1000);
		
		/**
		 * Perform right click, double click, context click
		 */
		
		driver.get("http://the-internet.herokuapp.com/");
		WebElement link = driver.findElement(By.linkText("Drag and Drop"));
		
		Actions act = new Actions(driver);
		
		//Mouse over
		act.moveToElement(link).perform();
		
		//Right click (context click)
		//act.contextClick(link).perform();
		
		//double click
		act.doubleClick(link).perform();
		
		//simple click
		act.click(link);
		Thread.sleep(2000);
		
		
		//Drag and Drop
		WebElement drag = driver.findElement(By.id("column-a"));
		WebElement drop = driver.findElement(By.id("column-b"));
		
		act.dragAndDrop(drag, drop).perform();
		Thread.sleep(2000);
		
		
		
		driver.quit();
	}

}
