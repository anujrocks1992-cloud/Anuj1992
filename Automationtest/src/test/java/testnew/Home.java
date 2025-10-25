package testnew;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import page.HomePage;

public class Home extends BaseClass {
	@DataProvider
	public Object[][] dataset() throws Exception {
		Object arr[][] = new Object[1][2];
		File fl = new File("C:\\Users\\Anuj\\git\\Anuj1992\\Automationtest\\Repository\\testdata.properties");
		FileInputStream f2 = new FileInputStream(fl);
		Properties pro = new Properties();
		pro.load(f2);
		arr[0][0] = pro.getProperty("Testdata5");
		arr[0][1] = pro.getProperty("Testdata6");

		return arr;

	}

	@Test(dataProvider = "dataset", description = "verify the page title")
	public void verifyFirstJobTitle(String username, String password) throws InterruptedException {
		HomePage hm = new HomePage(driver, wait);
		Thread.sleep(2000);
		hm.enterName(username);
		hm.enterpass(password);
		hm.click();
		Thread.sleep(2000);
		hm.searchboxAction();
		hm.EnterJobName("Automation Testing");
		hm.firstElementAction();
		hm.searchbtn();
		hm.clickFirstJob();
		Assert.assertTrue(hm.isJobTitleDisplayed(), "title is incorrect");
		Assert.assertTrue(hm.isJobCompanyNameDisplayed(), "company name is incorrect");
	}

	@Test(dataProvider = "dataset", description = "Verify The Basic Job Search")
	public void verifyTheBasicJobSearch(String username, String password) throws InterruptedException {
		HomePage hp = new HomePage(driver, wait);
		hp.enterName(username);
		hp.enterpass(password);
		hp.click();
		Thread.sleep(2000);
		hp.searchboxAction();
		Thread.sleep(2000);
		hp.EnterJobName("Java Developer");
		hp.searchbtn();
		String title = hp.jobTitle();
		System.out.println("Page Title: " + title);
		Assert.assertTrue(hp.isJobCardDisplayed(), "Job cards are not visible!");
		Assert.assertFalse(title.contains("Java Developer"), "Page title contains the keyword!");

	}

	@Test(dataProvider = "dataset", description = "Verify The Basic Job Search using location keyword")
	public void verifyTheBasicJobSearchUsingLoc(String username, String password) throws InterruptedException {
		HomePage hp1 = new HomePage(driver, wait);
		hp1.enterName(username);
		hp1.enterpass(password);
		hp1.click();
		Thread.sleep(2000);
		hp1.searchboxAction();
		Thread.sleep(2000);
		hp1.EnterJobName("Java Developer");
		hp1.EnterLocation("bengaluru");
		hp1.searchbtn();
		Assert.assertTrue(hp1.resultListJobLocation(), "result does not match");
	}

	@Test(dataProvider = "dataset", description = "verify the save jobs")
	public void verifySaveJobs(String username, String password) throws InterruptedException {
		HomePage hp2 = new HomePage(driver, wait);
		hp2.enterName(username);
		hp2.enterpass(password);
		hp2.click();
		Thread.sleep(2000);
		hp2.searchboxAction();
		Thread.sleep(2000);
		hp2.EnterJobName("Java Developer");
		hp2.EnterLocation("bengaluru");
		hp2.searchbtn();
		hp2.savejob();
		hp2.goToSaveJobPage();
		Assert.assertTrue(hp2.isSavedJobDisplayed());
	}

	@Test(dataProvider = "dataset", description = "Verify Logout functionality")
	public void verifyLogout(String username, String password) throws InterruptedException {
		HomePage hp3 = new HomePage(driver, wait);
		hp3.enterName(username);
		hp3.enterpass(password);
		hp3.click();
		Thread.sleep(2000);
		hp3.openProfileMenu();
		Thread.sleep(2000);
		hp3.clickLogout();
		Assert.assertTrue(hp3.isLoginOrSignupVisible(), "Login/Signup not visible — Logout might have failed!");
		System.out.println("Logout successful — redirected to public home page.");
	}

	@Test(enabled=false,dataProvider = "dataset", description = "Verify Resume Upload functionality")
	public void verifyResumeUpload(String username, String password) throws InterruptedException {
		HomePage hp = new HomePage(driver, wait);
		hp.enterName(username);
		hp.enterpass(password);
		hp.click();
		Thread.sleep(3000);
		hp.goToProfilePage();
		Thread.sleep(2000);
		String resumePath = System.getProperty("user.dir") + "\\Repository\\screenshot\\Anuj_saxena_2.9y.pdf";
		Thread.sleep(2000);
		hp.uploadResume(resumePath);
		Assert.assertTrue(hp.isUploadSuccessful(), "Resume upload failed or message not displayed");
		System.out.println("Resume uploaded successfully and message verified");
	}
}
