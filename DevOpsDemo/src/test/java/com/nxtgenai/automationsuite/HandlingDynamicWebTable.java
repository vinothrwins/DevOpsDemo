package com.nxtgenai.automationsuite;

/*======================================================================
| Author :  Vinoth Rathinam
| Project:  NxtGen AI Academy
| Purpose:  To handle the dynamic webtable
| Date   :  19/02/2021 
 *=======================================================================*/


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingDynamicWebTable {

	public WebDriver driver;

	@Test(priority=1)
	public void browserCommands() throws InterruptedException {

		// Parameterizing input values 
		String URL = "https://nxtgenaiacademy.com/webtable/";
		
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Step 1: Launch the application
		driver.get(URL);

		// Maximize the application
		driver.manage().window().maximize();
		System.out.println("Application is Launched");

		// Step 2 : Identify the Table
		WebElement employersTable = driver.findElement(By.xpath("//*[@id=\"content\"]/article/div/div/div/div/section[2]/div/div/div/div/div/div/div/table"));

		// Step 3 : To locate the rows of the table
		List<WebElement> rowsTable = employersTable.findElements(By.tagName("tr"));

		// Step 4 : To calculate the total number of rows
		int rowCount = rowsTable.size();
		//System.out.println(rowCount);

		// Step 5: For loop - Loop will be executed till the last row of the table
		// Row = 0 : It starts from the 1st row
		for(int row = 0; row < rowCount; row++) {

			// Step 6: To locate the column of the specified row
			List<WebElement> columnsRow = rowsTable.get(row).findElements(By.tagName("td"));

			// Step 7 : To calculate the total number of columns
			int colCount = columnsRow.size();
			//System.out.println(colCount);

			// Step 8 : For Loop - Execute the loop till the last cell of the specified column of the table
			for(int col = 0 ; col < colCount; col++) {

				// Step 9: To Retrieve all the cell text
				String cellText = columnsRow.get(col).getText();
				//System.out.println(cellText);

				// Parametrizing the Xpath
				String startXpath = "//*[@id=\"content\"]/article/div/div/div/div/section[2]/div/div/div/div/div/div/div/table/tbody/tr[";

				// Step 10 : Find the specified Value
				String empID = "635241";
				if(cellText.equals(empID)) {

					int rownew = row + 1 ;

					// Print the First Name 
					String firstNameVal = driver.findElement(By.xpath(startXpath + rownew +"]/td[2]")).getText();
					System.out.println("The First Name of the Employee is "+ firstNameVal);

					// Print the Last Name
					String lastNameVal = driver.findElement(By.xpath(startXpath + rownew +"]/td[3]")).getText();
					System.out.println("The LastName of the Employee is "+ lastNameVal);

					// Print the Salary
					String salary = driver.findElement(By.xpath(startXpath + rownew +"]/td[10]")).getText();
					System.out.println("The Salary of the Employee is "+ salary);

					// Print the Email ID
					WebElement email = driver.findElement(By.xpath(startXpath + rownew +"]/td[11]"));
					String emailId = email.getText();
					System.out.println("Email id of the Employee is "+ emailId);	

				}
			}
		}

		// Adding 3 seconds wait to see the flow - Don't use in real time scenario
		Thread.sleep(3000);

		// Close the Application
		driver.close();
		System.out.println("Application is closed");
	}

}
