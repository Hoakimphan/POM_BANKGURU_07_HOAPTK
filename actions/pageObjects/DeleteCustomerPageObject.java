package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;

public class DeleteCustomerPageObject extends AbstractPage{
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
