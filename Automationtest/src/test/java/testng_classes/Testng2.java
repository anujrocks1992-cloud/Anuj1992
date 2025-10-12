package testng_classes;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Testng2 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(groups={"smoke","regression"},priority = 1)
	public void TC_B1_OpenHomePage() {
		driver.get("https://www.naukri.com/nlogin/login");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Naukri"), "Title does not contain Naukri");

		WebElement searchBox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Search jobs here']")));
		Assert.assertTrue(searchBox.isDisplayed(), "Search box not visible");
	}

	@Test(groups="smoke",priority = 3)
	public void TC_B2_LoginValid() {
		driver.findElement(By.xpath("//input[@placeholder='Enter Email ID / Username']")).clear();

		WebElement email = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Email ID / Username']")));
		email.sendKeys("asaxenaanuj.1993@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).clear();

		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		password.sendKeys("1");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		WebElement profileIcon = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='naukri user profile img']")));
		Assert.assertTrue(profileIcon.isDisplayed(), "Login not successful");
	}

	@Test(groups="smoke",priority = 2)
	public void TC_B3_LoginInvalid() {

		WebElement email = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Email ID / Username']")));
		email.sendKeys("invalid@gmail.com");

		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		password.sendKeys("invalid");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[text()='Invalid details. Please check the Email ID - Password combination.']")));
		Assert.assertTrue(error.isDisplayed(), "Error message not shown");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
