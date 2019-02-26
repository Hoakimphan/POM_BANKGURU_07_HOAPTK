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

public class RegisterAndLoginToSystem_Level_5_WebDriverLifeCycle extends AbstractTest {
	private WebDriver driver;
	private String email, userID, password, loginUrl ;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName)
	{
		driver = openMultiBrowser(browserName);//map với driver initialize bên AbstractTest
		email = "sele" + randomEmail() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
	}
	@Test
	public void TC_01_Register()
	{
		loginUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();//tạo sự kết nối giữa register page và login page
			
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordIDText();
	}
	@Test
	public void TC_02_LoginWithInformationInAbove()
	{
		registerPage.openLoginPageURL(loginUrl);
		//open url -> vao Login lai
		loginPage = new LoginPageObject(driver);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		//click to login -> vao home page
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Test
	public void Account_03_WebDriverLifeCycle()
	{
		//new customer-> new account -> deposit -> fundtransfer
		newCustomerPage = homePage.openNewCustomerPage();
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		newAccountPage = newCustomerPage.openNewAccountPage();
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		depositPage = newAccountPage.openDepositPage();
		Assert.assertTrue(depositPage.isDepositPageDisplayed());
		
		fundTransferPage = depositPage.openFundTransferPage();
		Assert.assertTrue(fundTransferPage.isFundTransferPageDisplayed());
	}
	@AfterClass
	public void quit()
	{
		driver.close();
	}

}
