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

public class RegisterAndLoginToSystem_Level_2_Apply_AbstractPage_MultiBrowser extends AbstractTest {
	//WebDriver driver;
	//C1: (k khuyến khích): k can bien driver trong class nay, ma su dung bien driver o class AbstracTest
	//C2: khai báo biến driver, và biến driver này sử dụng lại biến driver đã khởi tạo ở class cha mà nó đang kế thừa (làm vậy để k SD chung driver, lợi khi có nhiều class TC)
	private WebDriver driver;
	private String email, userID, password, loginUrl ;
	private AbstractPage abstractPage;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName)
	{
		driver = openMultiBrowser(browserName);//map với driver initialize bên AbstractTest
		abstractPage = new AbstractPage();
		email = "sele" + randomEmail() + "@gmail.com";
	}
	@Test
	public void TC_01_Register()
	{
		abstractPage.openUrl(driver, "http://demo.guru99.com/v4/");
		loginUrl = abstractPage.getCurrentUrl(driver);
		abstractPage.clickToElement(driver, "//a[text()='here']");
		abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", email);
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		userID = abstractPage.getTextInElement(driver, "//td[text()='User ID :']//following-sibling::td");
		password = abstractPage.getTextInElement(driver, "//td[text()='Password :']//following-sibling::td");
	}
	@Test
	public void TC_02_LoginWithInformationInAbove()
	{
		abstractPage.openUrl(driver, loginUrl);
		abstractPage.sendkeyToElement(driver, "//input[@name='uid']", userID);
		abstractPage.sendkeyToElement(driver, "//input[@name='password']", password);
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		abstractPage.isControlDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]");
		abstractPage.isControlDisplayed(driver, "//td[text()='Manger Id : "+userID+"']");
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
