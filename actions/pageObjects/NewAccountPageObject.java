package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewAccountPageUI;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;

	public NewAccountPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public DepositPageObject openDepositPage() {
		waitToElementVisible(driver, NewAccountPageUI.DEPOSIT_LINK);
		clickToElement(driver, NewAccountPageUI.DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
	}

	public boolean isNewAccountPageDisplayed() {
		waitToElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}

}
