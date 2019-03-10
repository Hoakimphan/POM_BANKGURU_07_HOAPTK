package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;

	public NewAccountPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public boolean isNewAccountPageDisplayed() {
		waitToElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}
	public void inputCustomerIDForNewAccountPage(String customerID)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "cusid");
		sendkeyToElement(driver, customerID, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "cusid");
	}
	public void selectAccountType(String accountType)
	{
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInHtmlDropDown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, accountType);
	}
	public void inputInitialDeposit(String initialDeposit)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "inideposit");
		sendkeyToElement(driver, initialDeposit, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "inideposit");
	}
	public void clickSubmitToCreateNewAccount()
	{
		waitToElementVisible(driver, NewAccountPageUI.SUBMIT_TO_CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, NewAccountPageUI.SUBMIT_TO_CREATE_NEW_ACCOUNT_BUTTON);
	}
	public boolean isMessageInNewAccountPageDisplayed()
	{
		waitToElementVisible(driver, NewAccountPageUI.SUCCESS_MESSAGE_IN_NEW_ACCOUNT_PAGE);
		return isControlDisplayed(driver, NewAccountPageUI.SUCCESS_MESSAGE_IN_NEW_ACCOUNT_PAGE);
	}
	public String getCurrentAmountText()
	{
		waitToElementVisible(driver, NewAccountPageUI.CURRENT_AMOUNT);
		String currentAmount = getTextInElement(driver, NewAccountPageUI.CURRENT_AMOUNT);
		return currentAmount;
	}
	public String getAccountIDText()
	{
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
		return getTextInElement(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
	}
	
}
