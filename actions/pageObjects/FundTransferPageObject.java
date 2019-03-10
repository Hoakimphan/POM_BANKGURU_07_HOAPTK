package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.DepositPageUI;
import pageUIs.FundTransferPageUI;

public class FundTransferPageObject extends AbstractPage{
	WebDriver driver;

	public FundTransferPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isFundTransferPageDisplayed() {
		waitToElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_TEXT);
		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_TEXT);
	}
	public void inputPayerAccountNo(String payerAccountNo)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "payersaccount");
		sendkeyToElement(driver, payerAccountNo, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "payersaccount");
	}
	public void inputPayeeAccountNo(String payeeAccountNo)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "payeeaccount");
		sendkeyToElement(driver, payeeAccountNo, AbstractPageUI.DYNAMIC_ELEMENTS_TEXTBOX, "payeeaccount");
	}
	public boolean isMessageInFundTransferPageDisplayed()
	{
		waitToElementVisible(driver, FundTransferPageUI.SUCCESS_MESSAGE_IN_FUND_TRANSFER_PAGE);
		return isControlDisplayed(driver, FundTransferPageUI.SUCCESS_MESSAGE_IN_FUND_TRANSFER_PAGE);
	} 
	public String getAmountText()
	{
		waitToElementVisible(driver, FundTransferPageUI.AMOUNT);
		return getTextInElement(driver, FundTransferPageUI.AMOUNT);
	}
}
