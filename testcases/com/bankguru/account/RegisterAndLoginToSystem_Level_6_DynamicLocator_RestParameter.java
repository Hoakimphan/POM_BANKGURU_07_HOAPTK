package com.bankguru.account;

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

public class RegisterAndLoginToSystem_Level_6_DynamicLocator_RestParameter extends AbstractTest {
	private WebDriver driver;
	
	private LoginPageObject loginPage;

	private HomePageObject homePage;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserIDTextbox(RegisterAndLoginToSystem_Global_Register_Login.USERID);
		loginPage.inputToPasswordTextbox(RegisterAndLoginToSystem_Global_Register_Login.PASSWORD);
		homePage = loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

//	@Test
//	public void TC_01_Register() {
//		loginUrl = loginPage.getLoginPageUrl();
//		registerPage = loginPage.clickToHereLink();
//
//		registerPage.inputToEmailIDTextbox(email);
//		registerPage.clickToSubmitButton();
//		userID = registerPage.getUserIDText();
//		password = registerPage.getPasswordIDText();
//	}

//	@Test
//	public void TC_02_LoginWithInformationInAbove() {
//		
//		loginPage = new LoginPageObject(driver);
//		loginPage.inputToUserIDTextbox(RegisterAndLoginToSystem_Global_Register_Login.USERID);
//		loginPage.inputToPasswordTextbox(RegisterAndLoginToSystem_Global_Register_Login.PASSWORD);
//		homePage = loginPage.clickToLoginButton();
//		homePage = new HomePageObject(driver);
//		Assert.assertTrue(homePage.isHomePageDisplayed());
//	}

	
//	public void TC_03_Account_03_WebDriverLifeCycle() {
//		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
//		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
//		newAccountPage = (NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
//		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
//		depositPage = (DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
//		Assert.assertTrue(depositPage.isDepositPageDisplayed(driver));
//		homePage = (HomePageObject) depositPage.openDynamicPage(driver, "Manager");
//		Assert.assertTrue(homePage.isHomePageDisplayed());
//		newAccountPage = (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
//		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
//		newAccountPage.openMoreDynamicPage(driver, "New Customer");
//		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
//		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
//	}

	@AfterTest
	public void quit() {
		driver.close();
	}

}
