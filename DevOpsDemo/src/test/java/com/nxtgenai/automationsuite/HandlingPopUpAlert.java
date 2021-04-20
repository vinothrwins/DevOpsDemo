package com.nxtgenai.automationsuite;

/*======================================================================
| Author :  Vinoth Rathinam
| Project:  NxtGen AI Academy
| Purpose:  To handle the alert box and display the alert message
| Date   :  11/02/2021 
 *=======================================================================*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingPopUpAlert {
	
	public WebDriver driver;

	@Test(priority=1)
	public void handlingpopup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();		
		
		// Parameterizing input values 
		String URL = "https://nxtgenaiacademy.com/alertandpopup/";	

		// Launch the Application and maximize it
		driver.get(URL);		
		driver.manage().window().maximize();				

		// 1. Handling Alert Box
		//Click on Alert Box
		driver.findElement(By.name("alertbox")).click();

		Thread.sleep(1000);

		// Capture the alert message
		String alertBoxMsg = driver.switchTo().alert().getText();
		System.out.println(alertBoxMsg);

		// Click on OK button
		driver.switchTo().alert().accept();

		Thread.sleep(1000);

		// 2. Handling Confirm Alert Box
		//Click on Alert Box
		WebElement confirmationAlert = driver.findElement(By.name("confirmalertbox"));
		confirmationAlert.click();

		// Capture the alert message
		String confirmationAlertBoxMsg = driver.switchTo().alert().getText();
		System.out.println(confirmationAlertBoxMsg);

		Thread.sleep(1000);

		//Click on OK
		driver.switchTo().alert().accept();

		Thread.sleep(1000);

		//Click on Alert Box
		confirmationAlert.click();

		Thread.sleep(1000);

		//Click on Cancel
		driver.switchTo().alert().dismiss();

		// 3. Prompt Alert Box
		// Click on Prompt Alert Box
		WebElement promptAlertButton = driver.findElement(By.name("promptalertbox1234"));
		promptAlertButton.click();

		Thread.sleep(1000);

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capture the alert message
		String promptAlertBoxMsg = alert.getText();
		System.out.println(promptAlertBoxMsg);	

		// To enter the text(yes)
		alert.sendKeys("Yes");

		Thread.sleep(1000);

		// Click on OK
		alert.accept();

		// Click on Prompt Alert Box
		promptAlertButton.click();

		Thread.sleep(1000);

		// To enter the text(no)
		alert.sendKeys("No");

		Thread.sleep(1000);

		// Click on OK
		alert.accept();

		Thread.sleep(1000);

		// Click on Prompt Alert Box
		promptAlertButton.click();

		Thread.sleep(1000);

		// Click on Cancel
		alert.dismiss();

		Thread.sleep(1000);

		// Close the application
		driver.close();
	}

}
