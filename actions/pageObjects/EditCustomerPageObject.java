package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.EditCustomerPageUI;
import pageUIs.NewCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public EditCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public void clickOnSubmitBtn()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_BUTTON, "AccSubmit");
		clickToElement(driver , AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "AccSubmit");
	}
	//edit customer
	public void editAddress(String newAddress)
	{
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, newAddress);
	}
	public void editCity(String newCity)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "city");
		sendkeyToElement(driver, newCity, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "city");
	}
	public void editState(String newState)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "state");
		sendkeyToElement(driver, newState, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "state");
	}
	public void editPin(String newPin)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "pinno");
		sendkeyToElement(driver, newPin, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "pinno");
	}
	public void editMobileNumber(String newPhone)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "telephoneno");
		sendkeyToElement(driver, newPhone, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "telephoneno");
	}
	public void editEmail(String newEmail)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "emailid");
		sendkeyToElement(driver, newEmail, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "emailid");
	}
	public void editPassword(String newPassword)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "password");
		sendkeyToElement(driver, newPassword, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX,  "password");
	}
	public void clickToSubmitBtnToEditCustomer()
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_BUTTON, "sub");
		clickToElement(driver, AbstractPageUI.DYNAMIC_ELEMENTS_BUTTON, "sub");
	}
	public boolean isMessageInEditCustomerPageDisplayed()
	{
		waitToElementVisible(driver, EditCustomerPageUI.SUCCESS_MESSAGE_IN_EDIT_CUSTOMER_PAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.SUCCESS_MESSAGE_IN_EDIT_CUSTOMER_PAGE);
	}
	public String getCustomerIDTextAfterEdit()
	{
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
		return getTextInElement(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
	}
}
