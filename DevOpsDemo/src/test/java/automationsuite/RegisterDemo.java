package automationsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterDemo {

	public WebDriver driver;

	// Parameterized all The WebElement Path
	String qaAutomationLocator = "//span[@class='text-wrap'][contains(text(),'QA Automation')]";
	String practiceAutomationLocator = "//span[@class='text-wrap'][contains(text(),'Practice Automation')]";
	String regForm = "Registration Form";

	@Test(priority=1)
	public void launchBrowser() {	 

		String url = "https://nxtgenaiacademy.com/";

		// Set the system property for the chrome driver
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		// Creating the object instance for the chrome drive
		driver = new ChromeDriver();

		// Launch the Application and maximize it
		driver.get(url);		
		driver.manage().window().maximize();	
		System.out.println("Application is Launched");	

	}

	@Test(priority=3)
	public void closeApplication() {
		driver.close();
		System.out.println("Application is closed");
	}

	@Test(priority=2)
	public void navigateToRegisterDemo() {
		// Click on Selenium Online Training
		WebElement qaAutomation = driver.findElement(By.xpath(qaAutomationLocator));			

		// Create an Instance in Action Class by Passing WebDriver Instance
		Actions actBuilder = new Actions(driver);

		// Move the Mouse above the QA Automation
		actBuilder.moveToElement(qaAutomation).build().perform();

		// Click on Registration Form
		WebElement practiceAutomation = driver.findElement(By.xpath(practiceAutomationLocator));

		// Move the Mouse above the Practice Automation
		actBuilder.moveToElement(practiceAutomation).build().perform();

		// Click on Demo Site-Registration Form
		driver.findElement(By.partialLinkText(regForm)).click();
		System.out.println("Navigated to Register Demo Page");
	}
}
