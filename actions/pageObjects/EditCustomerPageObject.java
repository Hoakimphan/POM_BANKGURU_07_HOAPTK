package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;

public class EditCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public EditCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	public void inputCutomerID(String customerID)
	{
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "cusid");
		sendkeyToElement(driver, customerID , AbstractPageUI.DYNAMIC_ELEMENTS_NEW_CUSTOMER_PAGE, "cusid");
	}
}
