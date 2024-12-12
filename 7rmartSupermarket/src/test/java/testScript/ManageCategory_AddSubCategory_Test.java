package testScript;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageCategory_AddSubCategory;
import pages.ManageNews_AddNews;
import utilities.ExcelUtility;

public class ManageCategory_AddSubCategory_Test extends Base {
	public Home homepage;
	public ManageCategory_AddSubCategory addSubCategory;

	@Test
	public void verifyUserIsAbleToAddSubCategory() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String subCategory = ExcelUtility.readStringData(1, 0, "AddSubCategroy");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		homepage = login_page.click_login_btn();
		addSubCategory = homepage.click_manageSubcategory_btn();
		addSubCategory.clickNewButton();
		addSubCategory.clickSelectCategory();
		addSubCategory.enterSubcategory(subCategory);
		addSubCategory.uploadSubcategoryImge();
		addSubCategory.clickSaveButton();
		boolean isSubCategoryAdded = addSubCategory.isSubCategoryAddedSuccessfully();
		assertTrue(isSubCategoryAdded, Constant.FAILEDTOCREATESUBCATEGORY);
	}
}
