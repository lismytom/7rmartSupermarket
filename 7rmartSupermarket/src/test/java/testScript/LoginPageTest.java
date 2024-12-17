package testScript;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersNewAddPage;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;

public class LoginPageTest extends Base {
	//public Home homepage;
	public LoginPageTest login_page;

	@Test
	public void verifyUserIsAbleToLoginWithValidCredentials() throws AWTException, IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		login_page.click_login_btn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isHomepage_loaded = login_page.isDashboard_loaded();
		assertTrue(isHomepage_loaded, Constant.ERRORMESSAGEFORLOGIN);
	}

	@Test
	public void verifyUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws AWTException, IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		login_page.click_login_btn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isAlert_loaded = login_page.isAlert_displayed();
		assertTrue(isAlert_loaded, Constant.ALERTMESSAGEFORINVALIDCREDENTIALS);
	}

	@Test
	@Parameters({ "Username", "Password" })
	public void verifyUserIsAbleToLoginWithInvalidUsernameAndValidPassword(String username, String password)
			throws AWTException {
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		login_page.click_login_btn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isAlert_loaded = login_page.isAlert_displayed();
		assertTrue(isAlert_loaded, Constant.ALERTMESSAGEFORINVALIDCREDENTIALS);
	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = {{ "user3", "Test123" }};
		return data;
	}

	@Test(dataProvider = "credentials")
	public void verifyUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword(String username, String password)
			throws Exception {
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		login_page.click_login_btn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isAlert_loaded = login_page.isAlert_displayed();
		assertTrue(isAlert_loaded, Constant.ALERTMESSAGEFORINVALIDCREDENTIALS);
	}
}
