package testScript;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageContacts;
import pages.ManageNews_AddNews;
import utilities.ExcelUtility;

public class ManageContactsTest extends Base {
	public Home homepage;
	public ManageContacts addContact;

	@Test
	public void verifyContactDetailsareupdated() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String phone = ExcelUtility.readIntegerData(1, 0, "ManageContact");
		String email = ExcelUtility.readStringData(1, 1, "ManageContact");
		String address = ExcelUtility.readStringData(1, 2, "ManageContact");
		String delivery_time = ExcelUtility.readIntegerData(1, 3, "ManageContact");
		String delivery_limit = ExcelUtility.readIntegerData(1, 4, "ManageContact");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		homepage = login_page.click_login_btn();
		addContact = homepage.click_ManageContactButton();
		addContact.clickEditbutton();
		addContact.clearExistingDetails();
		addContact.updatePhonefield(phone);
		addContact.updateEmailfield(email);
		addContact.updateAddressfield(address);
		addContact.updateDeliveryTimefield(delivery_time);
		addContact.updateDeliveryChargeLimitfield(delivery_limit);
		addContact.clickUpdateButton();
		boolean isContactUpdated = addContact.iscontactUpdatedSuccessfully();
		assertTrue(isContactUpdated, Constant.FAILEDTOUPDATECONTACT);
	}
}
