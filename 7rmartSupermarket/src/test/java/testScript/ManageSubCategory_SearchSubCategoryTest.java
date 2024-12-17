package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageCategory_AddSubCategory;
import pages.ManageCategory_SearchSubCategory;
import utilities.ExcelUtility;

public class ManageSubCategory_SearchSubCategoryTest extends Base {
	public Home homepage;
	public ManageCategory_SearchSubCategory searchSubcategory;

	@Test
	public void verifyUserCanSearchExistingSubCategory() throws Exception {
		String username = ExcelUtility.readStringData(6, 0, "LoginPage");
		String password = ExcelUtility.readStringData(6, 1, "LoginPage");
		String subCategory = ExcelUtility.readStringData(1, 0, "AddSubCategroy");
		LoginPage login_page = new LoginPage(driver);
		login_page.enter_loginCredentials(username, password);
		homepage = login_page.click_login_btn();
		searchSubcategory = homepage.clickSearchSubCategory();
		searchSubcategory.clickSearchButton().selectCategoryToSearch().enterSubcategoryToSearch(subCategory)
				.clickOnSearchButton();
		boolean isSubCategorySearched = searchSubcategory.isSearchResultDisplayed();
		assertTrue(isSubCategorySearched, Constant.SUBCATEGORYNOTAVAILABLE);
	}
}
