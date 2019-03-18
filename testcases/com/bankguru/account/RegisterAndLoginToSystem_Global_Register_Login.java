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

public class RegisterAndLoginToSystem_Global_Register_Login extends AbstractTest {
	private WebDriver driver;
	private String email;
	public static String USERID, PASSWORD;
	
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "sele" + randomEmail() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Register(Method testMethod) {
		log.info("=======START:"+ testMethod.getName()+ "==========");

		log.info("Account 01 - step 01: click To Here Link");
		registerPage = loginPage.clickToHereLink();
		
		log.info("Account 01 - step 02: input To Email ID Textbox");
		registerPage.inputToEmailIDTextbox(email);
		
		log.info("Account 01 - step 03: click To Submit Button");
		registerPage.clickToSubmitButton();
		
		log.info("Account 01 - step 04: get User ID Text");
		USERID = registerPage.getUserIDText();
		
		log.info("Account 01 - step 05: get Password ID Text");
		PASSWORD = registerPage.getPasswordIDText();
		
		log.info("=======END:"+ testMethod.getName()+ "==========");
	}

	@AfterTest
	public void afterTest() {
		closedBrowserAndDriver(driver);
	}

}
