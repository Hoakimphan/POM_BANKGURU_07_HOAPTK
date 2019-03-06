package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;

	public DepositPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public FundTransferPageObject openFundTransferPage() {
		waitToElementVisible(driver, DepositPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, DepositPageUI.FUND_TRANSFER_LINK);
		return PageFactoryManager.getFundTransferPage(driver);
	}
	public boolean isDepositPageDisplayed(WebDriver driver) {
		waitToElementVisible(driver, DepositPageUI.DEPOSIT_TEXT);
		return isControlDisplayed(driver, DepositPageUI.DEPOSIT_TEXT);
	}
	
}
