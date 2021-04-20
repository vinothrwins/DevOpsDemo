package com.nxtgenai.automationsuite;

/*======================================================================
| Author :  Vinoth Rathinam
| Project:  NxtGen AI Academy
| Purpose:  To handle the iFrame using Frame Names
| Date   :  11/02/2021 
 *=======================================================================*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFramesName {

	public WebDriver driver;

	@Test(priority=1)
	public void handlingFrames() throws InterruptedException {

		// Set the system property for the chrome driver

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();

		// Parameterizing input values 
		String URL = "https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html";	

		// Launch the Application and maximize it
		driver.get(URL);		
		driver.manage().window().maximize();	

		// Frame names
		String listFrame = "packageListFrame";
		String packageFrame = "packageFrame";
		String classFrame = "classFrame";

		// Activate the List Frame
		driver.switchTo().frame(listFrame);

		// Click on org.openqa.selenium.chrome link
		driver.findElement(By.xpath("/html/body/main/ul/li[3]/a")).click();
		System.out.println("org.openqa.selenium.chrome link in "+ listFrame + " is clicked");

		Thread.sleep(3000);

		// Mandatory Step - Back to default frame
		driver.switchTo().defaultContent();

		// Activate the Package Frame
		driver.switchTo().frame(packageFrame);

		// Click on ChromeOptions link
		driver.findElement(By.xpath("/html/body/main/div/section[1]/ul/li[1]/a")).click();
		System.out.println("ChromeOptions link in "+ packageFrame + " is clicked");

		Thread.sleep(3000);

		// Back to default frame
		driver.switchTo().defaultContent();

		// Activate the class frame
		driver.switchTo().frame(classFrame);

		// Click on HELP
		driver.findElement(By.xpath("//div[@class='topNav']//a[contains(text(),'Help')]")).click();
		System.out.println("Help link in "+ classFrame + " is clicked");

		// Close the application
		driver.close();		

	}

}
