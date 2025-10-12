package testnew;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.BaseClass;
import page.LoginPage;

public class Login extends BaseClass {

    @Test(priority=0,description="verify login with invalid username and invalid password")
    public void verifyInvalidLogin() throws InterruptedException {
        LoginPage l = new LoginPage(driver,wait);  //Pass driver from BaseClass
        l.enterName("Email@gmail.com");
        l.enterpass("Password");
        Thread.sleep(2000);
        l.click();
        Thread.sleep(2000);
        String actualError = l.getErrorMessage();
        String expectedError = "Invalid details. Please check the Email ID - Password combination.";
        Assert.assertEquals(actualError, expectedError, "Error message not matching!");
    }
    @Test(priority=1,description="verify login with valid username and invalid password")
    public void verifyLoginWithValidUserInvalidPass() throws InterruptedException {
    	  LoginPage l = new LoginPage(driver,wait); 
    	  l.enterName("asaxenaanuj.1993@gmail.com");
    	  l.enterpass("pass");
    	  l.click();
    	  Thread.sleep(2000);
    	 String actual= l.getErrorMessage();
    	 String exp="Invalid details. Please check the Email ID - Password combination.";
    	 Assert.assertEquals(actual, exp,"error message not matching");
    }
    @Test(priority=2,description="verify login with invalid username and valid password")
    public void verifyLoginWithinValidUservalidPass() throws InterruptedException {
    	  LoginPage l = new LoginPage(driver,wait); 
    	  l.enterName("invalid@gmail.com");
    	  l.enterpass("Anuj@30491628");
    	  l.click();
    	  Thread.sleep(2000);
    	 String actual= l.getErrorMessage();
    	 String exp="Invalid details. Please check the Email ID - Password combination.";
    	 Assert.assertEquals(actual, exp,"error message not matching");
}
    @Test(priority=4,description="verify login with valid username and valid password")
    public void verifyLoginWithValidUservalidPass() throws InterruptedException {
    	  LoginPage l = new LoginPage(driver,wait); 
    	  l.enterName("asaxenaanuj.1993@gmail.com");
    	  l.enterpass("Anuj@30491628");
    	  l.click();
    	  Thread.sleep(2000);
    	  l.profileicondisplay();
}
    @Test(priority=3,description="verify login with blank credentials")
    public void verifyLoginWithBlankcredentials() throws InterruptedException {
    	  LoginPage l = new LoginPage(driver,wait); 
    	  l.enterName("");
    	  l.enterpass("");
    	  l.click();
    	  Thread.sleep(2000);
    	  String actual1=l.usernameErrorDisplay();
    	  Thread.sleep(2000);
    	  String actual2=l.passwordErrorDisplay();
     	  String exp1="Email ID/Username cannot be left blank";
     	  String exp2="Password cannot be left blank";
     	 Assert.assertEquals(actual1, exp1,"error message not matching");
     	 Assert.assertEquals(actual2, exp2,"error message not matching");
}
}
	

