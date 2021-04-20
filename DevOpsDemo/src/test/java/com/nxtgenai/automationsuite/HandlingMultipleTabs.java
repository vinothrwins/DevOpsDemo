package com.nxtgenai.automationsuite;

/*======================================================================
| Author :  Vinoth Rathinam
| Project:  NxtGen AI Academy
| Purpose:  To handle the multiple tabs 
| Date   :  19/02/2021 
 *=======================================================================*/


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingMultipleTabs {

	public WebDriver driver;

	@Test(priority=1)
	public void handlingMutipleTabs() throws InterruptedException {

		// Set the system property for browser
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		
		// Creating the driver object for the Chrome Browser in the WebDriver Interface
		driver = new FirefoxDriver();

		// Launch the URL
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		System.out.println("Application is Launched");

		// Maximize
		driver.manage().window().maximize();

		// Opening new browser tab
		driver.findElement(By.name("newbrowsertab453")).click();		
		System.out.println("New browser tab is opened");

		Set<String> windowId = driver.getWindowHandles();		
		Iterator<String> iterator = windowId.iterator();

		String homePage = iterator.next(); // 1 - Main Window
		String newTab = iterator.next(); // 2 - New window

		System.out.println("Parent Browser ID is " + homePage);
		System.out.println("New Tab ID is " + newTab);

		// Switching the control to new window 
		driver.switchTo().window(newTab);
		System.out.println("New Tab is Activated");

		Thread.sleep(3000);

		//Click on Python For Data Science in Home page 
		driver.findElement(By.partialLinkText("DATA SCIENCE")).click();
		System.out.println("Data Science Page is loaded in New Tab");

		Thread.sleep(3000);

		//Close the browser
		driver.close();
		System.out.println("New Tab is Closed");

		// Switching the control to the main window
		driver.switchTo().window(homePage);
		System.out.println("Parent Browser Activated");

		// Click on Home link
		driver.findElement(By.linkText("HOME")).click();
		System.out.println("Home Page is loaded in Parent Browser");

		Thread.sleep(3000);

		driver.close();	
		System.out.println("Parent Browser is closed");	


	}

}
