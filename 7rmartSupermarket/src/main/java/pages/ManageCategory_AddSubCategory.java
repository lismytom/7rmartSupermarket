package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategory_AddSubCategory {
	public WebDriver driver;

	public ManageCategory_AddSubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//child::i[@class='fas fa-arrow-circle-right']")
	WebElement manage_category_button;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement new_btn;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category_dropdown;
	@FindBy(xpath = "//option[text()='Toys']")
	WebElement category_valueToys;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile_button;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement subCategoryAddition_alert;

	public ManageCategory_AddSubCategory clickNewButton() {
		new_btn.click();
		return this;
	}

	public ManageCategory_AddSubCategory clickSelectCategory() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex1(category_dropdown, 5);
		return this;
	}

	public ManageCategory_AddSubCategory enterSubcategory(String subCategory) {
		subcategory.sendKeys(subCategory);
		return this;
	}

	public ManageCategory_AddSubCategory uploadSubcategoryImge() throws Exception {
		String imagepath = Constant.TESTIMAGEFILE;
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendKeysFileupload(choosefile_button, imagepath);
		return this;
	}

	public ManageCategory_AddSubCategory clickSaveButton() {
		save_button.click();
		return this;
	}

	public boolean isSubCategoryAddedSuccessfully() {
		return subCategoryAddition_alert.isDisplayed();
	}
}
