package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageCategory_SearchSubCategory {
	public WebDriver driver;

	public ManageCategory_SearchSubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search_MainButton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement category_dropdown;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement subcategory_textfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_button;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	WebElement search_result;

	public ManageCategory_SearchSubCategory clickSearchButton() {
		search_MainButton.click();
		return this;
	}

	public ManageCategory_SearchSubCategory selectCategoryToSearch() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex1(category_dropdown, 5);
		return this;
	}

	public ManageCategory_SearchSubCategory enterSubcategoryToSearch(String subcategory) {
		subcategory_textfield.sendKeys(subcategory);
		return this;
	}

	public ManageCategory_SearchSubCategory clickOnSearchButton() {
		submit_button.click();
		return this;
	}

	public boolean isSearchResultDisplayed() {
		return search_result.isDisplayed();
	}
}
