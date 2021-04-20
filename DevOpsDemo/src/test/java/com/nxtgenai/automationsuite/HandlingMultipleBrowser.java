package com.nxtgenai.automationsuite;

/*======================================================================
| Author :  Vinoth Rathinam
| Project:  NxtGen AI Academy
| Purpose:  To handle the multiple browsers 
| Date   :  19/02/2021 
 *=======================================================================*/

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingMultipleBrowser {

	public WebDriver driver;

	@Test(priority=1)
	public void handlingMutipleBrowser() throws InterruptedException {

		// Set the system property for browser
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		// Creating the driver object for the Chrome Browser in the WebDriver Interface
		driver = new ChromeDriver();

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Clear all the cookies
		driver.manage().deleteAllCookies();

		// Launch the URL
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		System.out.println("Application is Launched");

		// Maximize
		driver.manage().window().maximize();

		// Opening new browser window
		driver.findElement(By.name("newbrowserwindow123")).click();	    
		System.out.println("Child Browser is opened");

		//Can retrieve any number of windows id in the list 
		//System.out.println(driver.getWindowHandles()); 

		// Get the window's ID 
		Set<String> windowId = driver.getWindowHandles();			
		Iterator<String> iterator = windowId.iterator();

		// Storing the window's id to the respective window's
		String homePage = iterator.next(); // 1 - Main Window
		String newPage = iterator.next(); // 2 - New window

		System.out.println("Parent Browser ID is " + homePage);
		System.out.println("Child Browser ID is " + newPage);

		// Switching the control to new window and performing all the operations in New Page Window
		driver.switchTo().window(newPage);
		System.out.println("Child Browser Activated");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		//Click on Python For Data Science in Home page 
		driver.findElement(By.partialLinkText("DATA SCIENCE")).click();
		System.out.println("Data Science Page is loaded in Child Browser");

		Thread.sleep(2000);

		//Close the browser
		driver.close();
		System.out.println("Child Browser is closed");

		// Switching the control to the main window and performing all the operations in Home Page Window
		driver.switchTo().window(homePage);
		System.out.println("Parent Browser Activated");

		Thread.sleep(2000);

		// Click on Home link
		driver.findElement(By.linkText("HOME")).click();
		System.out.println("Home Page is loaded in Parent Browser");

		Thread.sleep(2000);

		driver.close();	
		System.out.println("Parent Browser is closed");	
	}

}
