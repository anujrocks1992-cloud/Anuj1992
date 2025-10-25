package page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	@FindBy(xpath = "//input[@placeholder='Enter Email ID / Username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement pass;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//span[@class=\"nI-gNb-sb__placeholder\"]")
	WebElement searchbox;
	@FindBy(xpath = "//input[@placeholder=\"Enter keyword / designation / companies\"]")
	WebElement SuggestionSearch;
	@FindBy(xpath = "//ul[@class=\"layer-wrap\"]/li[1]")
	WebElement firstSuggestion;
	@FindBy(xpath = "//span[text()='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//a[contains(@class,'title')][1]")
	WebElement firstJobCard;
	@FindBy(xpath = "//h1[contains(@class,'jd-header-title')]")
	WebElement jobTitle;
	@FindBy(xpath = "//div[@class='styles_jhc__jd-top-head__MFoZl']/div")
	WebElement companyName;
	@FindBy(xpath = "//input[@placeholder='Enter location']")
	WebElement searchLocation;
	@FindBy(xpath = "//h1[@title='Java Developer Jobs In Bengaluru']")
	WebElement resultlist;
	@FindBy(xpath = "(//span[@class='ni-job-tuple-icon ni-job-tuple-icon-srpSaveUnfilled un-saved save-job-tag'][normalize-space()='save'])[1]")
	WebElement saveJobs;
	@FindBy(xpath = "//div[text()='Saved jobs']")
	WebElement savedJobsLink;
	@FindBy(xpath = "(//div[contains(@class,'truncate')])[1]")
	WebElement firstSavedJob;
	@FindBy(xpath = "//div[text()='Jobs']")
	WebElement jobsMenu;
	@FindBy(xpath = "//div[@class='nI-gNb-drawer__icon-img-wrapper']")
	WebElement profileMenu;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutLink;
	@FindBy(xpath = "//a[text()='Login' or text()='Sign in' or text()='Register']")
	WebElement loginOrSignupLink;
	@FindBy(xpath = "//a[text()='View & Update Profile']")
	WebElement viewProfileLink;
	@FindBy(xpath = "//input[@value='Update resume']]")
	WebElement uploadResumeInput;
	@FindBy(xpath = "//span[@id='attachCVMsgBox']")
	WebElement uploadSuccessMessage;
	@FindBy(xpath = "//div[@class='truncate exten']")
	WebElement uploadedResumeName;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterName(String username) {
		usernameField.clear();
		wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
	}

	public void enterpass(String password) {
		pass.clear();
		wait.until(ExpectedConditions.visibilityOf(pass)).sendKeys(password);
	}

	public void click() {
		loginButton.click();
	}

	public void searchboxAction() {
		wait.until(ExpectedConditions.elementToBeClickable(searchbox)).click();

	}

	public void EnterJobName(String jobRole) {
		wait.until(ExpectedConditions.visibilityOf(SuggestionSearch)).sendKeys(jobRole);

	}

	public void firstElementAction() {
		wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion)).click();

	}

	public void searchbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

	}

	public void clickFirstJob() {
		wait.until(ExpectedConditions.elementToBeClickable(firstJobCard)).click();
		String parentid = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for (String ids : handle) {
			if (!ids.equals(parentid)) {
				driver.switchTo().window(ids);
				break;
			}
		}
	}

	public Boolean isJobTitleDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(jobTitle)).isDisplayed();
	}

	public Boolean isJobCompanyNameDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(companyName)).isDisplayed();
	}

	public String jobTitle() {
		return driver.getTitle();
	}

	public boolean isJobCardDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(firstJobCard)).isDisplayed();
	}

	public void EnterLocation(String jobLocation) {
		wait.until(ExpectedConditions.visibilityOf(searchLocation)).sendKeys(jobLocation);
	}

	public Boolean resultListJobLocation() {
		return wait.until(ExpectedConditions.visibilityOf(resultlist)).isDisplayed();
	}

	public void savejob() {
		wait.until(ExpectedConditions.elementToBeClickable(saveJobs)).click();
	}

	public void goToSaveJobPage() {
		wait.until(ExpectedConditions.visibilityOf(jobsMenu));
		actions.moveToElement(jobsMenu).perform();
		wait.until(ExpectedConditions.elementToBeClickable(savedJobsLink)).click();
	}

	public boolean isSavedJobDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(firstSavedJob)).isDisplayed();

	}

	public void openProfileMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
	}

	public void clickLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
	}

	public boolean isLoginOrSignupVisible() {
		return wait.until(ExpectedConditions.visibilityOf(loginOrSignupLink)).isDisplayed();
	}

	public void goToProfilePage() {
		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(viewProfileLink)).click();
	}

	public void uploadResume(String filePath) {
		wait.until(ExpectedConditions.visibilityOf(uploadResumeInput)).sendKeys(filePath);

	}

	public boolean isUploadSuccessful() {

		return wait.until(ExpectedConditions.visibilityOf(uploadSuccessMessage)).isDisplayed();

	}
}
