package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;

public class DeleteAccountPageObject extends AbstractPage{
	WebDriver driver;

	public DeleteAccountPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
