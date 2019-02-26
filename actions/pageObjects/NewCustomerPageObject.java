package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{

	public NewCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	WebDriver driver;

	public NewAccountPageObject openNewAccountPage() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, NewCustomerPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}

	public boolean isNewCustomerPageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
}
