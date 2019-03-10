package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private String email, userID, password, loginUrl, customerID, customerIDAfterEdit, accountID;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;
	private EditCustomerPageObject editCustomerPage;
	private WithdrawalPageObject withdrawalPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	String newName = "AUTOMATION TESTING";
	String newDob = "1989-01-01";
	String newAddress = "PO Box 911 8311 Duis Avenue";
	String newCity = "Tampa";
	String newState = "FL";
	String newPin = "466250";
	String newPhone = "4555442276";
	String newEmail = "Auto" + randomEmail() + "@gmail.com";
	String newPassword = "automation";

	String editAddress = "1883 Cursus Avenue";
	String editCity = "Houston";
	String editState = "Texas";
	String editPin = "166455";
	String editPhone = "4779728081";
	String editEmail = "Testing" + randomEmail() + "@gmail.com";

	String accountType = "Current";
	String initialDeposit = "50000";

	String amountTransfer = "5000";
	String descriptionDeposit = "Deposit";
	String currentBalanceInDeposit;

	String amountWithdrawal = "15000";
	String descriptionWithdraw = "Withdrawal";
	String transactionIDWithdraw;
	String currentBalanceInWithdrawal;

	String payeeAccountNo = "57202";
	String amountTransferIntoAnotherAccount = "10000";
	String descriptionFundTransfer = "Transfer";

	String balance;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "sele" + randomEmail() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void Prepare_01_Register() {
		loginUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordIDText();
	}

	@Test
	public void Prepare_02_LoginWithInformationInAbove() {
		registerPage.openLoginPageURL(loginUrl);
		loginPage = new LoginPageObject(driver);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@Test
	public void TC_01_CreateNewCustomer() {
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		newCustomerPage.inputCustomerName(newName);
		newCustomerPage.inputDateOfBirth(newDob);
		newCustomerPage.inputAddress(newAddress);
		newCustomerPage.inputCity(newCity);
		newCustomerPage.inputState(newState);
		newCustomerPage.inputPin(newPin);
		newCustomerPage.inputMobileNumber(newPhone);
		newCustomerPage.inputEmail(newEmail);
		newCustomerPage.inputPassword(newPassword);
		newCustomerPage.clickToSubmitBtn();
		Assert.assertTrue(newCustomerPage.isMessageInNewCustomerPageDisplayed());
		customerID = newCustomerPage.getCustomerIDText();
	}

	@Test
	public void TC_02_EditCustomer() {
		homePage.openMoreDynamicPage(driver, "Edit Customer");
		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);
		editCustomerPage.inputCutomerID(driver, customerID);
		editCustomerPage.clickOnSubmitBtn();
		editCustomerPage.editAddress(editAddress);
		editCustomerPage.editCity(editCity);
		editCustomerPage.editState(editState);
		editCustomerPage.editPin(editPin);
		editCustomerPage.editMobileNumber(editPhone);
		editCustomerPage.editEmail(editEmail);
		editCustomerPage.clickToSubmitBtnToEditCustomer();
		Assert.assertTrue(editCustomerPage.isMessageInEditCustomerPageDisplayed());
		customerIDAfterEdit = editCustomerPage.getCustomerIDTextAfterEdit();
	}

	@Test
	public void TC_03_AddNewAccount() {
		homePage.openMoreDynamicPage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);
		newAccountPage.inputCustomerIDForNewAccountPage(customerIDAfterEdit);
		newAccountPage.selectAccountType(accountType);
		newAccountPage.inputInitialDeposit(initialDeposit);
		newAccountPage.clickSubmitToCreateNewAccount();
		Assert.assertTrue(newAccountPage.isMessageInNewAccountPageDisplayed());
		accountID = newAccountPage.getAccountIDText();
		Assert.assertEquals(newAccountPage.getCurrentAmountText(), initialDeposit);
	}

	@Test
	public void TC_04_TransferMoneyIntoCurrentAccount() {
		homePage.openMoreDynamicPage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);
		depositPage.inputAccountNo(driver, accountID);
		depositPage.inputAmount(driver, amountTransfer);
		depositPage.inputDescription(driver, descriptionDeposit);
		depositPage.clickToSubmit(driver);
		Assert.assertTrue(depositPage.isMessageInDepositPageDisplayed(accountID));
		currentBalanceInDeposit = depositPage.getCurrentBalanceText();
		Assert.assertEquals(currentBalanceInDeposit, depositPage.depositMoney(initialDeposit, amountTransfer));
	}

	@Test
	public void TC_05_WitdrawalMoney() {
		homePage.openMoreDynamicPage(driver, "Withdrawal");
		withdrawalPage = PageFactoryManager.getWithdrawalPage(driver);
		withdrawalPage.inputAccountNo(driver, accountID);
		withdrawalPage.inputAmount(driver, amountWithdrawal);
		withdrawalPage.inputDescription(driver, descriptionWithdraw);
		withdrawalPage.clickToSubmit(driver);
		Assert.assertTrue(withdrawalPage.isMessageInWithdrawalPageDisplayed(accountID));
		transactionIDWithdraw = withdrawalPage.getTransactionIDText();
		currentBalanceInWithdrawal = withdrawalPage.getCurrentBalanceText();
		Assert.assertEquals(currentBalanceInWithdrawal,
				withdrawalPage.withdrawalMoney(currentBalanceInDeposit, amountWithdrawal));
	}

	@Test
	public void TC_06_TransferMoneyIntoAnotherAccount() {
		homePage.openMoreDynamicPage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);
		fundTransferPage.inputPayerAccountNo(accountID);
		fundTransferPage.inputPayeeAccountNo(payeeAccountNo);
		fundTransferPage.inputAmount(driver, amountTransferIntoAnotherAccount);
		fundTransferPage.inputDescription(driver, descriptionFundTransfer);
		fundTransferPage.clickToSubmit(driver);
		Assert.assertTrue(fundTransferPage.isMessageInFundTransferPageDisplayed());
		Assert.assertEquals(fundTransferPage.getAmountText(), amountTransferIntoAnotherAccount);
	}

	@Test
	public void TC_07_CheckCurrentAccountInBalanceEnquiry() {
		homePage.openMoreDynamicPage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);
		balanceEnquiryPage.inputAccountNo(driver, accountID);
		balanceEnquiryPage.clickToSubmit(driver);
		Assert.assertTrue(balanceEnquiryPage.isMessageInBalanceEnquiryPageDisplayed(accountID));
		balance = balanceEnquiryPage.getBalanceText();
		Assert.assertEquals(balance,
				balanceEnquiryPage.balanceMoney(currentBalanceInWithdrawal, amountTransferIntoAnotherAccount));
	}

	@Test
	public void TC_08_DeleteAccount() {
		homePage.openMoreDynamicPage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		deleteAccountPage.inputAccountNo(driver, accountID);
		deleteAccountPage.clickToSubmit(driver);
		deleteAccountPage.acceptAlert(driver);
		String deleteAccountMessage = deleteAccountPage.getTextAlert(driver);
		Assert.assertEquals(deleteAccountMessage, "Account Deleted Sucessfully");
		deleteAccountPage.acceptAlert(driver);
	}

	@Test
	public void TC_09_DeleteCustomer() {
		homePage.openMoreDynamicPage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);
		deleteCustomerPage.inputCutomerID(driver, customerID);
		deleteCustomerPage.clickToSubmit(driver);
		deleteCustomerPage.acceptAlert(driver);
		String deleteCustomerMessage = deleteCustomerPage.getTextAlert(driver);
		Assert.assertEquals(deleteCustomerMessage, "Customer deleted Successfully");
		deleteCustomerPage.acceptAlert(driver);
	}

	@AfterTest
	public void quit() {
		driver.close();
	}
}
