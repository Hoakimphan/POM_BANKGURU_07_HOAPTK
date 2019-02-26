package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;

	public DepositPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isDepositPageDisplayed() {
		waitToElementVisible(driver, DepositPageUI.DEPOSIT_TEXT);
		return isControlDisplayed(driver, DepositPageUI.DEPOSIT_TEXT);
	}

	public FundTransferPageObject openFundTransferPage() {
		waitToElementVisible(driver, DepositPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, DepositPageUI.FUND_TRANSFER_LINK);
		return PageFactoryManager.getFundTransferPage(driver);
	}

}
