package testng_classes;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng1 {
	WebDriver driver;
	WebDriverWait wait; 

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/nlogin/login");
	}

	@DataProvider
	public Object[][] dataset() throws Exception {
		Object arr[][] = new Object[3][2];

		File fl = new File(
				"C:\\Users\\Anuj\\OneDrive\\Desktop\\seleniump\\Automationtest\\Repository\\testdata.properties");
		FileInputStream f2 = new FileInputStream(fl);
		Properties pro = new Properties();
		pro.load(f2);
		arr[0][0] = pro.getProperty("Testdata1");
		arr[0][1] = pro.getProperty("Testdata2");
		arr[1][0] = pro.getProperty("Testdata3");
		arr[1][1] = pro.getProperty("Testdata4");
		arr[2][0] = pro.getProperty("Testdata5");
		arr[2][1] = pro.getProperty("Testdata6");

		return arr;

	}

	@Test(dataProvider = "dataset")
	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Email ID / Username']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Email ID / Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test
	 
	    public void homepage() {
	        String actualTitle = driver.getTitle();
	        System.out.println(actualTitle);
	        Assert.assertEquals(actualTitle, "Home | Mynaukri", "Title mismatch!");
	        
	    }

	    @Test
	    public void searchbox() {
	        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Search jobs here']")));
	        Assert.assertTrue(search.isDisplayed());
	    }
	
	

	@AfterClass
	public void close() {
		driver.close();
	}

}
