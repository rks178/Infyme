package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	static WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RAHUL\\eclipse-workspace\\JenkinsDemo\\Resources\\chromedriver.exe");
		boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
		ChromeOptions options = new ChromeOptions();
		if (isHeadless) {
			options.addArguments("--headless"); // Run in headless mode
			options.addArguments("--disable-gpu"); // Optional, improves stability
			options.addArguments("--window-size=1920,1080");
		}

		driver = new ChromeDriver(options);

		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}
