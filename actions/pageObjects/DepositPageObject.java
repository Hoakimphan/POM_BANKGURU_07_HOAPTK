package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.DepositPageUI;
import pageUIs.NewCustomerPageUI;

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
	public boolean isMessageInDepositPageDisplayed(String accountID)
	{
		waitToElementVisible(driver, DepositPageUI.SUCCESS_MESSAGE_IN_DEPOSIT_PAGE, accountID);
		return isControlDisplayed(driver, DepositPageUI.SUCCESS_MESSAGE_IN_DEPOSIT_PAGE, accountID);
	} 
	public String depositMoney(String initialDeposit, String amountTransfer)
	{
		String calculatedBalance = Integer.toString(Integer.parseInt(initialDeposit) + Integer.parseInt(amountTransfer));
		return calculatedBalance;
	}
	public String getCurrentBalanceText()
	{
		waitToElementVisible(driver, DepositPageUI.CURRENT_BALANCE);
		return getTextInElement(driver, DepositPageUI.CURRENT_BALANCE);
	}
}
