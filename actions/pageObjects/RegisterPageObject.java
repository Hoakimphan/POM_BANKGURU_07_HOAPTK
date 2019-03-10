package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driverMapping) {
		this.driver = driverMapping;
	}
	public void inputToEmailIDTextbox(String email)
	{
		waitToElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}
	public void clickToSubmitButton()
	{
		waitToElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserIDText()
	{
		waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextInElement(driver, RegisterPageUI.USER_ID_TEXT);
	}
	public String getPasswordIDText()
	{
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextInElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}
	public void openLoginPageURL(String loginPageURL)
	{
		openUrl(driver, loginPageURL);
	}
}
