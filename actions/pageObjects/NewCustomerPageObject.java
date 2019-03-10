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
	//create a new customer
	public void inputCustomerName()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "name");
		sendkeyToElement(driver, "AUTOMATION TESTING", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "name");
	}
	public void inputDateOfBirth()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "dob");
		sendkeyToElement(driver, "1989-01-01", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "dob");
	}
	public void inputAddress()
	{
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, "PO Box 911 8311 Duis Avenue");
	}
	public void inputCity()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "city");
		sendkeyToElement(driver, "Tampa", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE,  "city");
	}
	public void inputState()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "state");
		sendkeyToElement(driver, "FL", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE,  "state");
	}
	public void inputPin()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "pinno");
		sendkeyToElement(driver, "466250", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE,  "pinno");
	}
	public void inputMobileNumber()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "telephoneno");
		sendkeyToElement(driver, "4555442276", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE,  "telephoneno");
	}
	public void inputEmail(String email)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "emailid");
		sendkeyToElement(driver, email, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE,  "emailid");
	}
	public void inputPassword()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "password");
		sendkeyToElement(driver, "automation", AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE,  "password");
	}
	public void clickToSubmitBtn()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "sub");
		clickToElement(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "sub");
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
