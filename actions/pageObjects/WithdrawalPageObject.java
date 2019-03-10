package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.DepositPageUI;
import pageUIs.WithdrawalPageUI;

public class WithdrawalPageObject extends AbstractPage{
	WebDriver driver;
	public WithdrawalPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public String withdrawalMoney(String currentBalence, String amountWithdrawal)
	{
		String calculatedBalance = Integer.toString(Integer.parseInt(currentBalence) - Integer.parseInt(amountWithdrawal));
		return calculatedBalance;
	}
	public String getCurrentBalanceText()
	{
		waitToElementVisible(driver, WithdrawalPageUI.CURRENT_BALANCE);
		return getTextInElement(driver, WithdrawalPageUI.CURRENT_BALANCE);
	}
	public boolean isMessageInWithdrawalPageDisplayed(String accountID)
	{
		waitToElementVisible(driver, WithdrawalPageUI.SUCCESS_MESSAGE_IN_WITHDRAWAL_PAGE, accountID);
		return isControlDisplayed(driver, WithdrawalPageUI.SUCCESS_MESSAGE_IN_WITHDRAWAL_PAGE, accountID);
	}
	public String getTransactionIDText()
	{
		waitToElementVisible(driver, WithdrawalPageUI.TRANSACTION_ID);
		return getTextInElement(driver, WithdrawalPageUI.TRANSACTION_ID);
	}
}
