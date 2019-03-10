package pageUIs;

public class NewAccountPageUI {
	public static final String NEW_ACCOUNT_TEXT = "//p[text()='Add new account form']";
	public static final String ACCOUNT_TYPE_DROPDOWN = "//select[@name='selaccount']";
	public static final String SUBMIT_TO_CREATE_NEW_ACCOUNT_BUTTON = "//input[@value='submit']";
	public static final String ACCOUNT_ID_TEXT = "//td[text()='Account ID']//following-sibling::td";
	public static final String SUCCESS_MESSAGE_IN_NEW_ACCOUNT_PAGE = "//p[text()='Account Generated Successfully!!!']";
	public static final String CURRENT_AMOUNT = "//td[text()='Current Amount']//following-sibling::td";
}
