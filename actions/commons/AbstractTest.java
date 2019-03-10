package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	private WebDriver driver;

	public WebDriver openMultiBrowser(String browserName) {
		if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ChromeHeadless")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1600x900");
			driver = new ChromeDriver(options);
		}
		driver.get(Constant.DEV_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public int randomEmail() {
		Random random = new Random();
		int number = random.nextInt(99999);
		System.out.println("Random number: =" + number);
		return number;
	}

}
