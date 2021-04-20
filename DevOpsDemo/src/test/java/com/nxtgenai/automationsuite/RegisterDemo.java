package com.nxtgenai.automationsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterDemo {

	public WebDriver driver;

	// Parameterized all Input Values
	String URL = "https://nxtgenaiacademy.com/";
	String regForm = "Registration Form";
	String regFormDemo = "Register For Demo";
	String firstNameValue = "Vinoth";
	String lastNameValue = "Rathinam";
	String streetAddressInput = "Saravana Flats";
	String apartmentInput = "S2";
	String cityNameValue = "Chennai";
	String stateNameValue = "TamilNadu";
	String postalCodeValue= "600100";
	String countryDrpDnValue = "India";
	String emailInput= "vinothrwins@gmail.com";
	String dateOfDemoValue = "03/31/2021";
	String hourInput = "09";
	String minuteInput = "30";
	String ampmInput = "PM";
	String mobileNumberValue = "6383544892";
	String enterYourQueryValue = "What is the training cost?";
	String successfulMessageText = "Your query successfully submitted. Please check your mail box. Click on Home page to know more about latest updates.";

	// Parameterized all The WebElement Path
	String qaAutomationLocator = "//span[@class='text-wrap'][contains(text(),'QA Automation')]";
	String practiceAutomationLocator = "//span[@class='text-wrap'][contains(text(),'Practice Automation')]";
	String regTitleTextLocator = "//h3[contains(text(),'Register For Demo')]";
	String firstNameLocator = "vfb-5";
	String lastNameLocator = "vfb-7";
	String maleRdoBtnLocator = "vfb-8-1";
	String stAddressNameLocator = "vfb-13[address]";
	String apartmentLocator = "vfb-13-address-2";
	String cityLocator = "vfb-13-city";
	String stateLocator = "vfb-13-state";
	String postalCodeLocator = "vfb-13-zip";
	String countryDrpDnLocator = "vfb-13-country";
	String emailLocator = "#vfb-14";
	String dateOfDemoLocator = "#vfb-18";
	String hourLocator= "vfb-16-hour";
	String minuteLocator = "vfb-16-min";
	String amPmLocator = "vfb-16-ampm";
	String mobileNoLocator = "//input[@id='vfb-19']";
	String functionalTestingLocator = "vfb-20-4";
	String seleniumWebDriverLocator = "vfb-20-0";
	String enterYourQueryLocator = "vfb-23";
	String enterTwoDigitsLocator = "vfb-3";
	String submitBtnLocator = "vfb-4";
	String successfulMsgTextLocator = "//div[contains(text(),'Your query successfully submitted. Please check yo')]";

	@BeforeClass
	public void launchBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(URL);
		driver.manage().window().maximize();	
		
		Thread.sleep(1000);
	}


	@Test(priority=1)
	public void navigateToRegisterDemo() throws InterruptedException {
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
		
		Thread.sleep(1000);
	}


	@Test(priority=2)
	public void registerDemo() throws InterruptedException {
		// Step:4 Validate the Title of Form is displayed as "Register for Demo".

		// Positive Scenario
		WebElement regTitleText = driver.findElement(By.xpath(regTitleTextLocator));
		// Verify Register Title is Displayed or not
		if (regTitleText.isDisplayed()) {
			System.out.println("Register Title is Displayed");
		} else {
			System.out.println("Register Title is not Displayed");
		}

		// Verify Register Title page is Enabled or not
		if (regTitleText.isEnabled()) {
			System.out.println("Register Title is Enabled");
		} else {
			System.out.println("Register Title is not Enabled");
		}

		// Validating Text
		String actRegTitleText = regTitleText.getText();
		String expRegTitleText = regFormDemo;

		if (actRegTitleText.equals(expRegTitleText)) {
			System.out.println("The Register Title Text is: " + actRegTitleText);
		} else {
			System.out.println("Actual and expected Register Title Text are not same ");
			System.out.println("Actual Text is " + actRegTitleText);
			System.out.println("Expected Text is " + expRegTitleText);
		}

		// Step:5 Fill the Registration form by entering the all fields.

		// First name
		WebElement firstName = driver.findElement(By.id(firstNameLocator));
		// Verify the First Name is displayed or not
		if (firstName.isDisplayed()) {
			System.out.println("First Name is Displayed");
		} else {
			System.out.println("First Name is not Displayed");
		}

		// Verify the First Name is Enabled or not
		if (firstName.isEnabled()) {
			System.out.println("First Name is Enabled" );
			// Enter First Name
			firstName.sendKeys(firstNameValue);
			System.out.println("The Present First Name Value is: " + firstNameValue);
		} else {
			System.out.println("First Name is not Enabled" );
		}
		
		Thread.sleep(1000);

		// Last name
		WebElement lastName = driver.findElement(By.id(lastNameLocator));
		// Verify the Last Name is displayed or not
		if (lastName.isDisplayed()) {
			System.out.println("Last Name is Displayed");
		} else {
			System.out.println("Last Name is not Displayed");
		}

		// Verify the Last Name is enabled or not
		if (lastName.isEnabled()) {
			System.out.println("Last Name is Enabled");
			// Enter Last Name
			lastName.sendKeys(lastNameValue);
			System.out.println("The Present Last Name Value is: " + lastNameValue);
		} else {
			System.out.println("Last Name is not Enabled");
		}

		Thread.sleep(1000);
		
		// Gender
		// Male Radio Button
		WebElement maleRdoBtn = driver.findElement(By.id(maleRdoBtnLocator));
		// Verify Male Radio Button is Displayed or not
		if (maleRdoBtn.isDisplayed()) {
			System.out.println("Male Radio Button is Displayed");
		} else {
			System.out.println("Male Radio Button is not Displayed");
		}

		// Verify male Radio Button is Enabled or not
		if (maleRdoBtn.isEnabled()) {
			System.out.println("Male Radio Button is Enabled");
		} else {
			System.out.println("Male Radio Button is not Enabled");
		}

		// Verify Male Radio Button is Selected
		if (maleRdoBtn.isSelected()) {
			System.out.println("Male Radio Button is Selected");
		} else {
			System.out.println("Male Radio Button is not Selected");
			// Click on Male Radio Button
			maleRdoBtn.click();
			System.out.println("Male Radio Button is Selected");
		}

		Thread.sleep(1000);
		
		// Verify Male Radio Button is Selected
		if (maleRdoBtn.isSelected()) {
			System.out.println("Verified Male Radio Button  is Selected");
		} else {
			System.out.println("Verified Male Radio Button is not Selected");
		}

		// Address
		// Street Address
		WebElement stAddress = driver.findElement(By.name(stAddressNameLocator));
		// Verify the Street Address is displayed or not
		if (stAddress.isDisplayed()) {
			System.out.println("Street Address is Displayed");
		} else {
			System.out.println("Street Address is not Displayed");
		}

		// Verify the  Street Address is enabled or not
		if (stAddress.isEnabled()) {
			System.out.println("Street Address is Enabled");
			// Enter Street Address
			stAddress.sendKeys(streetAddressInput);
			System.out.println("Present Street Address Value is: " + streetAddressInput);
		} else {
			System.out.println("Street Address is not Enabled");
		}

		// Apartment Number
		WebElement apartmentNo = driver.findElement(By.id(apartmentLocator));
		// Verify the Apartment Number is displayed or not
		if (apartmentNo.isDisplayed()) {
			System.out.println("Apartment Number is Displayed");
		} else {
			System.out.println("Apartment Number is not Displayed");
		}

		// Verify the Apartment Number is enabled or not
		if (apartmentNo.isEnabled()) {
			System.out.println("Apartment Number is Enabled");
			// Enter Apartment Number
			apartmentNo.sendKeys(apartmentInput);
			System.out.println("Present Apartment Number Value is: " + apartmentInput);	
		} else {
			System.out.println("Apartment Number is not Enabled");
		}

		Thread.sleep(1000);
		
		// City
		WebElement cityName = driver.findElement(By.id(cityLocator));
		// Verify the City Name is displayed or not
		if (cityName.isDisplayed()) {
			System.out.println("City Name is Displayed");

		} else {
			System.out.println("City Name is not Displayed");
		}

		// Verify the City Name is enabled or not
		if (cityName.isEnabled()) {
			System.out.println("City Name is Enabled");
			// Enter City Name
			cityName.sendKeys(cityNameValue);
			System.out.println("Present City Name Value is : " + cityNameValue);
		} else {
			System.out.println("City Name is not Enabled");
		}

		Thread.sleep(1000);
		
		// State
		WebElement stateName = driver.findElement(By.id(stateLocator));
		// Verify the State is displayed or not
		if (stateName.isDisplayed()) {
			System.out.println("State is Displayed");
		} else {
			System.out.println("State is not Displayed");
		}

		// Verify the State is enabled or not
		if (stateName.isEnabled()) {
			System.out.println("State is Enabled");
			// Enter State Name
			stateName.sendKeys(stateNameValue);
			System.out.println("Present State Value is : " + stateNameValue);
		} else {
			System.out.println("State is not Enabled");
		}

		Thread.sleep(1000);
		
		// Postal/Zip code
		WebElement postalCode = driver.findElement(By.id(postalCodeLocator));
		// Verify the Postal Code is displayed or not
		if (postalCode.isDisplayed()) {
			System.out.println("Postal Code is Displayed");
		} else {
			System.out.println("Postal Code is not Displayed");
		}

		// Verify the Postal Code is enabled or not
		if (postalCode.isEnabled()) {
			System.out.println("Postal Code is Enabled");
			// Enter Postal Code
			postalCode.sendKeys(postalCodeValue);
			System.out.println("Present Postal Code Value is : " + postalCodeValue);
		} else {
			System.out.println("Postal Code is not Enabled");
		}

		Thread.sleep(1000);
		
		// Country Drop Down
		WebElement countryDropDown = driver.findElement(By.id(countryDrpDnLocator));
		// Verify Country Drop Down is displayed or not
		if (countryDropDown.isDisplayed()) {
			System.out.println("Verified Country Drop Down is Displayed");
		} else {
			System.out.println("Verified Country Drop Down is not Displayed");
		}

		// Verify Country Drop Down is enabled or not
		if (countryDropDown.isEnabled()) {
			System.out.println("Verified Country Drop Down is enabled");
		} else {
			System.out.println("Verified Country Drop Down is not enabled");
		}

		// To Select the Item from country DropDown, Create the Select Object
		Select countryDrpDn = new Select(countryDropDown);
		// Select Using Visible Text
		countryDrpDn.selectByVisibleText(countryDrpDnValue);
		System.out.println("Present Country Drop Down Value is: " + countryDrpDnValue);

		Thread.sleep(1000);
		
		// Email
		WebElement email = driver.findElement(By.cssSelector(emailLocator));
		// Verify the Email is Displayed or not
		if (email.isDisplayed()) {
			System.out.println("Email is Displayed");
		} else {
			System.out.println("Email is not Displayed");
		}

		// Verify the Email is enabled or not
		if (email.isEnabled()) {
			System.out.println("Email is Enabled");
			// Enter Email Id
			email.sendKeys(emailInput);
			System.out.println("Present Email Id is: " + emailInput);
		} else {
			System.out.println("Email is not Enabled");
		}

		// Date of Demo
		WebElement dateOfDemo = driver.findElement(By.cssSelector(dateOfDemoLocator));
		// Verify the Mobile Number is Displayed or not
		if (dateOfDemo.isDisplayed()) {
			System.out.println("Date of Demo is Displayed");
		} else {
			System.out.println("Date of Demo is not Displayed");
		}

		// Verify the Date of Demo is enabled or not
		if (dateOfDemo.isEnabled()) {
			System.out.println("Date of Demo is Enabled");
			// Enter Date of Demo Value
			dateOfDemo.sendKeys(dateOfDemoValue);
			dateOfDemo.sendKeys(Keys.ENTER);
			System.out.println("Present Date of Demo Value is: " + dateOfDemoValue);
		} else {
			System.out.println("Date of Demo is not Enabled");
		}

		Thread.sleep(1000);
		
		// Convenient Time
		// Hour Drop Down
		WebElement convenientTimeHrDrpDn = driver.findElement(By.id(hourLocator));
		// Verify Convenient Time Hour Drop Down is Displayed or not
		if (convenientTimeHrDrpDn.isDisplayed()) {
			System.out.println("Verified Hour DropDown is Displayed ");
		} else {
			System.out.println("Verified Hour DropDown is not Displayed ");
		}

		// Verify Convenient Time Hour Drop Down is Enabled or not
		if (convenientTimeHrDrpDn.isEnabled()) {
			System.out.println("Verified Hour DropDown is Enabled ");

			// To Select the Item from Convenient Time Hour DropDown, Create the Select Object
			Select hourDropDown = new Select(convenientTimeHrDrpDn);
			// Select Using Visible Text
			hourDropDown.selectByVisibleText(hourInput);
			System.out.println("Present Hour Drop Down Value is: " + hourInput);

		} else {
			System.out.println("Verified Hour DropDown is not Enabled ");
		}
		
		Thread.sleep(1000);

		// Minute Drop Down
		WebElement convenientTimeMinDrpDn = driver.findElement(By.id(minuteLocator));
		// Verify MM Drop Down is Displayed or not
		if (convenientTimeMinDrpDn.isDisplayed()) {
			System.out.println("Verified Minute DropDown is Displayed");
		} else {
			System.out.println("Verified Minute DropDown is not Displayed");
		}

		// Verify Minute Drop Down is Enabled or not
		if (convenientTimeMinDrpDn.isEnabled()) {
			System.out.println("Verified Minute DropDown is Enabled");

			// To Select the Item from Minute DropDown, Create the Select Object
			Select minuteDropDown = new Select(convenientTimeMinDrpDn);
			// Select Using Visible Text
			minuteDropDown.selectByVisibleText(minuteInput);
			System.out.println("Present Minute Drop Down Value is: " + minuteInput);

		} else {
			System.out.println("Verified Minute DropDown is not Enabled");
		}

		Thread.sleep(1000);

		// Convenient Time AM/PM Drop Down
		WebElement convenientTimeAmpmDrpDn = driver.findElement(By.id(amPmLocator));
		// Verify Convenient Time AM/PM Drop Down is Displayed or not
		if (convenientTimeAmpmDrpDn.isDisplayed()) {
			System.out.println("Verified AMPM DropDown is Displayed");
		} else {
			System.out.println("Verified AMPM DropDown is not Displayed");
		}

		// Verify Convenient Time AM/PM Drop Down is Enabled or not
		if (convenientTimeAmpmDrpDn.isEnabled()) {
			System.out.println("Verified AMPM DropDown is Enabled");

			// To Select the Item from AM/PM DropDown, Create the Select Object
			Select ampmDrpDown = new Select(convenientTimeAmpmDrpDn);
			// Select Using Visible Text
			ampmDrpDown.selectByVisibleText(ampmInput);
			System.out.println("Present AMPM Drop Down Value is: " + ampmInput );

		} else {
			System.out.println("Verified AMPM DropDown is not Enabled");
		}

		Thread.sleep(1000);
		
		// Mobile Number
		WebElement mobileNumber = driver.findElement(By.xpath(mobileNoLocator));
		// Verify the Mobile Number is Displayed or not
		if (mobileNumber.isDisplayed()) {
			System.out.println("Mobile Number is Displayed");
		} else {
			System.out.println("Mobile Number is not Displayed");
		}

		// Verify the Mobile Number is enabled or not
		if (mobileNumber.isEnabled()) {
			System.out.println("Mobile Number is Enabled");
			// Enter Mobile Number
			mobileNumber.sendKeys(mobileNumberValue);
			System.out.println("Present Mobile Number Value is: " + mobileNumberValue);
		} else {
			System.out.println("Mobile Number is not Enabled");
		}

		Thread.sleep(1000);
		
		// Course Interested
		// Functional Testing Check Box
		WebElement functionalTestingChk = driver.findElement(By.id(functionalTestingLocator));
		// Verify The Functional Testing Check Box is displayed or Not
		if (functionalTestingChk.isDisplayed()) {
			System.out.println("Verified Functional Testing Check Box is Displayed ");
		} else {
			System.out.println("Verified Functional Testing Check Box is Not Displayed ");
		}

		// Verify Functional Testing Check Box Enabled or Not
		if (functionalTestingChk.isEnabled()) {
			System.out.println("Verified Functional Testing Check Box is Enabled");
		} else {
			System.out.println("Verified Functional Testing Check Box is Not Enabled");
		}

		// Verify Functional Testing Check Box Selected or Not-Initial State(not Selected)
		if (functionalTestingChk.isSelected()) {
			System.out.println("Verified Functional Testing Check Box is Selected");
		} else {
			System.out.println("Verified Functional Testing Check Box is Not Selected");
			// Click on Functional Testing check Box
			functionalTestingChk.click();
			System.out.println("Functional Testing Check Box is checked");
		}

		Thread.sleep(1000);
		
		// Verify Functional Testing Check Box Selected or Not
		if (functionalTestingChk.isSelected()) {
			System.out.println("Verified Functional Testing Check Box is Selected");
		} else {
			System.out.println("Verified Functional Testing Check Box is Not Selected");
		}

		// Selenium WebDriver Check Box
		WebElement seleniumWebDriverChk= driver.findElement(By.id(seleniumWebDriverLocator));
		// Verify The Selenium WebDriver Check Box is displayed or Not
		if (seleniumWebDriverChk.isDisplayed()) {
			System.out.println("Verified Selenium WebDriver Check Box is Displayed ");
		} else {
			System.out.println("Verified Selenium WebDriver Check Box is Not Displayed ");
		}

		// Verify Selenium WebDriver Check Box Enabled or Not
		if (seleniumWebDriverChk.isEnabled()) {
			System.out.println("Verified Selenium WebDriver Check Box is Enabled");
		} else {
			System.out.println("Verified Selenium WebDriver Check Box is Not Enabled");
		}

		// Verify Selenium WebDriver Check Box Selected or Not
		if (seleniumWebDriverChk.isSelected()) {
			System.out.println("Verified Selenium WebDriver Check Box is Selected");
		} else {
			System.out.println("Verified Selenium WebDriver Check Box is Not Selected");
			// Click on Selenium WebDriver check Box
			seleniumWebDriverChk.click();
			System.out.println("Selenium WebDriver Check Box is Checked ");
		}

		Thread.sleep(1000);
		
		// Verify Selenium WebDriver Check Box Selected or Not
		if (seleniumWebDriverChk.isSelected()) {
			System.out.println("Verified Selenium WebDriver Check Box is Selected");
		} else {
			System.out.println("Verified Selenium WebDriver Check Box is Not Selected");
			// Click on Selenium WebDriver check Box
			System.out.println("Selenium WebDriver Check Box is Checked ");
		}

		// Enter Your Query
		WebElement enterYourQuery = driver.findElement(By.id(enterYourQueryLocator));
		// Verify the Enter Your Query is Displayed or not
		if (enterYourQuery.isDisplayed()) {
			System.out.println("Enter Your Query is Displayed");

		} else {
			System.out.println("Enter Your Query is not Displayed");
		}
		// Verify the Enter Your Query is enabled or not
		if (enterYourQuery.isEnabled()) {
			System.out.println("Enter Your Query is Enabled");
			// Enter Your Query Value
			enterYourQuery.sendKeys(enterYourQueryValue);
			System.out.println("Present Enter Your Query is: " + enterYourQueryValue);
		} else {
			System.out.println("Enter Your Query is not Enabled");
		}

		// Enter Any Two Digits
		WebElement enterTwoDigits = driver.findElement(By.id(enterTwoDigitsLocator));
		// Verify the Enter Any Two Digits is Displayed or not
		if (enterTwoDigits.isDisplayed()) {
			System.out.println("Enter Any Two Digits is Displayed");
		} else {
			System.out.println("Enter Any Two Digits is not Displayed");
		}

		// Verify the Enter Any Two Digits is enabled or not
		if (enterTwoDigits.isEnabled()) {
			System.out.println("Enter Any Two Digits is Enabled");

			// Retrieve the Verification Number during run time and enter value.
			String text=driver.findElement(By.xpath("//*[@id=\"item-vfb-2\"]/ul/li[1]/span/label")).getText();
			String num[]=text.split(":");    //Example: 50
			enterTwoDigits.sendKeys(num[1].trim());
			System.out.println("Enter Any Two Digits is: " + num[1]);
		} else {
			System.out.println("Enter Any Two Digits is not Enabled");
		}

		Thread.sleep(1000);
		
		// Submit button
		WebElement submitBtn = driver.findElement(By.id(submitBtnLocator));
		// Verify The Submit Button is displayed or Not
		if (submitBtn.isDisplayed()) {
			System.out.println("Verified Submit Button is Displayed ");
		} else {
			System.out.println("Verified Submit Button is Not Displayed ");
		}

		// Verify The Submit Button is Enabled or Not
		if (submitBtn.isEnabled()) {
			System.out.println("Verified Submit Button is Enabled");
			// Click on Submit Button
			submitBtn.click();
			System.out.println("Submit Button is Clicked");
		}

		Thread.sleep(1000);

		System.out.println("Details are submitted");
	}

	@Test(priority=3)
	public void validateSuccessfulMsg() throws InterruptedException {

		// Step:7 Submit the Form.
		WebElement successfulMsgText = driver.findElement(By.xpath(successfulMsgTextLocator));
		// Verify Successful message Text displayed or not
		if (successfulMsgText.isDisplayed()) {
			System.out.println("Successful Message Text is Displayed");			
		} else {
			System.out.println("Successful Message Text is not Displayed");
		}

		// Validating Successful Message Text
		String actSuccessfulMsgText = successfulMsgText.getText();
		String expSuccessfulMsgText = successfulMessageText;

		if (actSuccessfulMsgText.equals(expSuccessfulMsgText)) {
			System.out.println("The Successful Message Text is:  " + actSuccessfulMsgText);
		} else {
			System.out.println("Actual and expected Successful Msg Text are not same");
			System.out.println("Actual Text is: " + actSuccessfulMsgText);
			System.out.println("Expected Text is: " + expSuccessfulMsgText);
		} 
		Thread.sleep(1000);

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("Application is closed");
	}

}



