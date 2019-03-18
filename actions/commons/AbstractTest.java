package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;
	protected AbstractTest()
	{
		log = LogFactory.getLog(getClass());
	}

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
	
	private boolean checkPassed(boolean condition)
	{
		boolean pass = true;
		try
		{
			if(condition == true)
				log.info("====PASSED====");
			else
				log.info("====FAILED====");
				Assert.assertTrue(condition);
			
		}catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	private boolean checkFailed(boolean condition)
	{
		boolean pass= true;
		try
		{
			if(condition == true)
				log.info("====PASSED====");
			else
				log.info("====FAILED====");
			Assert.assertFalse(condition);
		}catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	private boolean checkEquals(Object[] actual, Object[] expected)
	{
		boolean pass= true;
		try
		{
			if(actual == expected)
				log.info("====PASSED====");
			else
				log.info("====FAILED====");
			Assert.assertEquals(actual, expected);
		}catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyTrue(boolean condition)
	{
		return checkPassed(condition);
	}
	
	protected boolean verifyFalse(boolean condition)
	{
		return checkFailed(condition);
	}
	
	protected boolean verifyEquals(Object[] actual, Object[] expected)
	{
		return checkEquals(actual, expected);
	}
	
	protected void closedBrowserAndDriver(WebDriver driver)
	{
		try
		{
			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.quit();
			if(driver.toString().toLowerCase().contains("chrome")) {
				if(osName.toString().toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				}else if(osName.toString().toLowerCase().contains("window")){
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if(driver.toString().toLowerCase().contains("internetexplorer")) {
				if(osName.toLowerCase().contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
