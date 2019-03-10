package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;
import pageUIs.RegisterPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public boolean isNewCustomerPageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	public boolean isHomePageDisplayed()
	{
		waitToElementVisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	public boolean isHomePageUnDisplayed()
	{
		waitToElementInvisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlUnDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	public boolean isAddCustomerFormUnDisplayed()
	{
		waitToElementInvisible(driver, NewCustomerPageUI.CUSTOMER_FORM);
		return isControlUnDisplayed(driver, NewCustomerPageUI.CUSTOMER_FORM);
	}
	public void inputCustomerName(String newName)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "name");
		sendkeyToElement(driver, newName, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "name");
	}
	public void inputDateOfBirth(String newDob)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "dob");
		sendkeyToElement(driver, newDob, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "dob");
	}
	public void inputAddress(String newAddress)
	{
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, newAddress);
	}
	public void inputCity(String newCity)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "city");
		sendkeyToElement(driver, newCity, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "city");
	}
	public void inputState(String newState)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "state");
		sendkeyToElement(driver, newState, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "state");
	}
	public void inputPin(String newPin)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "pinno");
		sendkeyToElement(driver, newPin, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "pinno");
	}
	public void inputMobileNumber(String newPhone)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "telephoneno");
		sendkeyToElement(driver, newPhone, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "telephoneno");
	}
	public void inputEmail(String newEmail)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "emailid");
		sendkeyToElement(driver, newEmail, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "emailid");
	}
	public void inputPassword(String newPassword)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "password");
		sendkeyToElement(driver, newPassword, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "password");
	}
	public void clickToSubmitBtn()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_BUTTON, "sub");
		clickToElement(driver, AbstractPageUI.DYNAMIC_ELEMENTS_BUTTON, "sub");
	}
	public boolean isMessageInNewCustomerPageDisplayed()
	{
		waitToElementVisible(driver, NewCustomerPageUI.SUCCESS_MESSAGE_IN_NEW_CUSTOMER_PAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.SUCCESS_MESSAGE_IN_NEW_CUSTOMER_PAGE);
	}
	public String getCustomerIDText()
	{
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
		return getTextInElement(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
	}
}
