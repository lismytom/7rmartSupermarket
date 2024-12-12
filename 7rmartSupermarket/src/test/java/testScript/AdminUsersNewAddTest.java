package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersNewAddPage;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersNewAddTest extends Base {
	public Home homepage;
	public AdminUsersNewAddPage addUser;

	@Test
	public void verifyNewUserIsAdded() throws AWTException, IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String new_username = ExcelUtility.readStringData(1, 0, "AddUser");
		String new_password = ExcelUtility.readStringData(1, 1, "AddUser");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		homepage = login_page.click_login_btn();
		addUser = homepage.click_adminUsers_btn();
		addUser.click_newBtn();
		addUser.eneterUsernameandpasswordfields(new_username, new_password);
		addUser.click_SaveButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isUserCreated = addUser.isUserCreatedSuccessfully();
		assertTrue(isUserCreated, Constant.FAILEDTOCREATENEWUSER);
		addUser.alert_close();
		boolean isTableloaded = addUser.isTableDisplayed();
	}
}
