package com.syntax.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;
import utils.Constants;

public class CheckBrokenLinks extends Constants {

	public static void main(String[] args) {
		
		int countVaild = 0;
		int countBroken = 0;
		
		ConfigReader.readConfigProperties(CONFIG_PATH);
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get(ConfigReader.getProperty("url"));
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		
		for(int i = 0; i < links.size(); i++) {
			
			String url = links.get(i).getAttribute("href");
			
			if(url != null) {
				URL object;
				try {
					object = new URL(url);

				
					HttpURLConnection connect = (HttpURLConnection)object.openConnection();
					int responseCode = connect.getResponseCode();
					
						if(responseCode == 200) {
							System.out.println(i + " Link is VALID --> "  + url);
							countVaild++;
						}else {
							System.out.println(i + " Link is BROKEN --> " + url);
							System.out.println("Status code " + responseCode);
							countBroken++;
						}
							
							
				} catch (IOException e) {
					
					
					
				} catch(Exception ex) {
					System.out.println("Some exceptions");
				}
				
				
			}else {
				System.out.println(links.get(i).getText());
				System.out.println(i+ " Link is BROKEN --> " + url);
				countBroken++;
			}
		}//end
		
		
		System.out.println("===============================");
		System.out.println("Total links detected: " + links.size());
		System.out.println("Total valid links: " + countVaild);
		System.out.println("Total broken links: " + countBroken);
		
		
		
		driver.quit();
		

	}

	


}
