package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/nlogin/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
