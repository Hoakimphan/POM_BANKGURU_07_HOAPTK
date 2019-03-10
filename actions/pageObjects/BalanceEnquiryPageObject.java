package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.BalanceEnquiryPageUI;
import pageUIs.DepositPageUI;

public class BalanceEnquiryPageObject extends AbstractPage{
	WebDriver driver;

	public BalanceEnquiryPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public boolean isMessageInBalanceEnquiryPageDisplayed(String accountID)
	{
		waitToElementVisible(driver, BalanceEnquiryPageUI.SUCCESS_MESSAGE_IN_DEPOSIT_PAGE, accountID);
		return isControlDisplayed(driver, BalanceEnquiryPageUI.SUCCESS_MESSAGE_IN_DEPOSIT_PAGE, accountID);
	}
	public String getBalanceText()
	{
		waitToElementVisible(driver, BalanceEnquiryPageUI.BALANCE);
		return getTextInElement(driver, BalanceEnquiryPageUI.BALANCE);
	}
	public String balanceMoney(String depositMoneyAfterWithdrawal, String amountTransferIntoAnother)
	{
		String calculatedBalance = Integer.toString(Integer.parseInt(depositMoneyAfterWithdrawal) - Integer.parseInt(amountTransferIntoAnother));
		return calculatedBalance;
	}
}
