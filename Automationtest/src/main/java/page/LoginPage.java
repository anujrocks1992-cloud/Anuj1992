package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//input[@placeholder='Enter Email ID / Username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement pass;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//div[text()='Invalid details. Please check the Email ID - Password combination.']")
	WebElement errorMsg;
	@FindBy(xpath = "//img[@alt='naukri user profile img']")
	WebElement profileicon;
	@FindBy(id = "usernameField_err")
	WebElement usernameError;
	@FindBy(id = "passwordField_err")
	WebElement passwordError;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}

	public void enterName(String username) {
		usernameField.sendKeys(username);
	}

	public void enterpass(String password) {
		pass.sendKeys(password);
	}

	public void click() {
		loginButton.click();
	}

	public String getErrorMessage() {
		return errorMsg.getText();
	}

	public void profileicondisplay() {
		profileicon.isDisplayed();
	}

	public String usernameErrorDisplay() {
		wait.until(ExpectedConditions.visibilityOf(usernameError));
		return usernameError.getText();
	}

	public String passwordErrorDisplay() {
		wait.until(ExpectedConditions.visibilityOf(passwordError));
		return passwordError.getText();
	}
}