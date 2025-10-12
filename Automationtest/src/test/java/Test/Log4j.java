package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

    // Create a logger instance for this class
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    public static void main(String[] args) {

        // Set up WebDriver (if required, uncomment and set path)
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            logger.info("Opening DemoQA Frames page...");
            driver.get("https://demoqa.com/frames");

            // Switch to single frame
            logger.info("Switching to frame1...");
            driver.switchTo().frame("frame1");

            // Capture text inside frame
            WebElement heading = driver.findElement(By.id("sampleHeading"));
            logger.info("Text inside frame: {}", heading.getText());

            // No need to switch back if only one frame is used

        } catch (Exception e) {
            logger.error("Error occurred: ", e);
        } finally {
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}




