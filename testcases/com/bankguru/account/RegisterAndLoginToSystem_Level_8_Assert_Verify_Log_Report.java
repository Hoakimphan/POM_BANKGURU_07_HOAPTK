package com.bankguru.account;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterAndLoginToSystem_Level_8_Assert_Verify_Log_Report extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;


	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserIDTextbox(RegisterAndLoginToSystem_Global_Register_Login.USERID);
		loginPage.inputToPasswordTextbox(RegisterAndLoginToSystem_Global_Register_Login.PASSWORD);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());
//		homePage = new HomePageObject(driver);
//		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

//	@Test
//	public void TC_01_Register(Method testMethod) {
//		log.info("=======START:"+ testMethod.getName()+ "==========");
//		
//		log.info("Account 01 - step 01: get Login Page Url");
//		loginUrl = loginPage.getLoginPageUrl();
//		
//		log.info("Account 01 - step 02: click To Here Link");
//		registerPage = loginPage.clickToHereLink();
//		
//		log.info("Account 01 - step 03: input To Email ID Textbox");
//		registerPage.inputToEmailIDTextbox(email);
//		
//		log.info("Account 01 - step 04: click To Submit Button");
//		registerPage.clickToSubmitButton();
//		
//		log.info("Account 01 - step 05: get User ID Text");
//		userID = registerPage.getUserIDText();
//		
//		log.info("Account 01 - step 06: get Password ID Text");
//		password = registerPage.getPasswordIDText();
//		
//		log.info("=======END:"+ testMethod.getName()+ "==========");
//	}

//	@Test
//	public void TC_02_LoginWithInformationInAbove() {
//		log.info("Account 02 - step 01: open Login Page URL");
//		registerPage.openLoginPageURL(loginUrl);
//
//		loginPage = new LoginPageObject(driver);
//		
//		log.info("Account 02 - step 02: input To User ID Textbox");
//		loginPage.inputToUserIDTextbox(userID);
//		
//		log.info("Account 02 - step 03: input To Password Textbox");
//		loginPage.inputToPasswordTextbox(password);
//		
//		log.info("Account 02 - step 04: click To Login Button");
//		homePage = loginPage.clickToLoginButton();
//		
//		homePage = new HomePageObject(driver);
//		
//		log.info("Account 02 - step 05: verify true is Home Page Displayed");
//		verifyTrue(homePage.isHomePageDisplayed());
//		
//		//verifyTrue(homePage.is);
//	}
//
//	@Test
//	public void TC_03_Account_03_WebDriverLifeCycle() {
//		log.info("Account 03 - step 01: open New Customer Page");
//		newCustomerPage = homePage.openNewCustomerPage(driver);
//		
//		log.info("Account 03 - step 02: verify true is New Customer Page Displayed");
//		verifyTrue(newCustomerPage.isNewCustomerPageDisplayed());
//		
//		log.info("Account 03 - step 03: verify true is Add Customer Form Un Displayed");
//		verifyTrue(newCustomerPage.isAddCustomerFormUnDisplayed());
//		
//		log.info("Account 03 - step 04: verify true is Home Page Un Displayed");
//		verifyTrue(newCustomerPage.isHomePageUnDisplayed());
//	}

	@AfterTest
	public void afterTest() {
		closedBrowserAndDriver(driver);
	}

}
