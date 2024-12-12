package testScript;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test
	public void verifyUserIsAbleToLogout() throws IOException, AWTException {
		String expected_result = "Login | 7rmart supermarket";
		String actual_result = driver.getTitle();
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		login_page.click_login_btn();
		Home logout = new Home(driver);
		logout.logout();
		assertEquals(actual_result, expected_result, Constant.TITLEMISMATCH);
	}
}
