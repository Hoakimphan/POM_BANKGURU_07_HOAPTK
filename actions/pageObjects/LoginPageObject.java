package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;//chua co du lieu
	
	public LoginPageObject(WebDriver driverMapping) {
		this.driver = driverMapping;
	}
	public String getLoginPageUrl()
	{
		return getCurrentUrl(driver);
	}
	public void inputToUserIDTextbox(String userID)
	{
		waitToElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
	}
	public void inputToPasswordTextbox(String pwd)
	{
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, pwd);
	}
	public HomePageObject clickToLoginButton()
	{
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePage(driver);
	}
	public RegisterPageObject clickToHereLink()
	{
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}

}
