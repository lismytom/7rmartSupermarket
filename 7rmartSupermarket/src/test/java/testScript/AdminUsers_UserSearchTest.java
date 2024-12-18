package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersNewAddPage;
import pages.AdminUsers_UserSearchPage;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsers_UserSearchTest extends Base {
	public Home homepage;
	public AdminUsers_UserSearchPage searchUser;

	@Test
	public void verifyUserCanBeSearched() throws AWTException, IOException {
		String username = ExcelUtility.readStringData(6, 0, "LoginPage");
		String password = ExcelUtility.readStringData(6, 1, "LoginPage");
		String username1 = ExcelUtility.readStringData(1, 0, "UserSearch");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		homepage = login_page.click_login_btn();
		searchUser = homepage.click_AdminUsers_button();
		searchUser.clickOnMainSearchButton();
		searchUser.enterUsernameAndUserType(username1).clickOnSearchButton();
		boolean isUserPresent = searchUser.isUserAvailable();
		assertTrue(isUserPresent, Constant.USERNOTAVAILABLE);
	}
}