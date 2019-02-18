package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	//public WebDriver driver;//C1: (k khuyến khích): khai bao kieu public(hoac protected de class ben TestCase sau khi extend class AbstractTest co the su dung dc bien driver, k gap loi NullPointerException
	//C2:khai báo kiểu private để chỉ SD tron class này, tuy nhiên sẽ return lại driver để class con thừa kế class này có thể SD tiếp
	private WebDriver driver;
	public WebDriver openMultiBrowser(String browserName)
	{
		if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ChromeHeadless"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1600x900");
			driver = new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
