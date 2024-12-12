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
import pages.ManageNews_AddNews;
import utilities.ExcelUtility;

public class ManageNews_AddNewsTest extends Base {
	public Home homepage;
	public ManageNews_AddNews addNews;

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyNewUserIsAdded() throws AWTException, IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		homepage = login_page.click_login_btn();
		addNews = homepage.click_manageNews_btn();
		addNews.click_newButton();
		String newsfield = ExcelUtility.readStringData(1, 0, "AddNews");
		addNews.enterNews(newsfield).submitNews();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean isNewsCreated = addNews.isNewsCreatedSuccessfully();
		assertTrue(isNewsCreated, Constant.FAILEDTOCREATENEWNEWS);
		addNews.alert_close();
	}
}
