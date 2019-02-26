package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class RegisterAndLoginToSystem_Level_3_PageObject extends AbstractTest {
	private WebDriver driver;
	private String email, userID, password, loginUrl ;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName)
	{
		driver = openMultiBrowser(browserName);//map với driver initialize bên AbstractTest
		//System.out.println("driver in RegisterAndLoginToSystem_Level_3_PageObject", driver);
		email = "sele" + randomEmail() + "@gmail.com";
		loginPage = new LoginPageObject(driver);
	}
	@Test
	public void TC_01_Register()
	{
		loginUrl = loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();
		//click Here Link vao register page
		registerPage = new RegisterPageObject(driver);
		
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
		loginPage.clickToLoginButton();
		//click to login -> vao home page
		homePage = new HomePageObject(driver);
		//Assert.assertTrue(homePage.isHomePageDisplayed());
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	public int randomEmail() {
		Random random = new Random();
		int number = random.nextInt(99999);
		System.out.println("Random number: =" + number);
		return number;
	}
	@AfterClass
	public void quit()
	{
		driver.close();
	}

}
