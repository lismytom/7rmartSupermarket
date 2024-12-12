package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUsers_UserSearchPage {
	public WebDriver driver;

	public AdminUsers_UserSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search_button;
	@FindBy(xpath = "//input[@id='un']")
	WebElement usernamesearch;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchbutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement tablecontent;

	public AdminUsers_UserSearchPage searchExistingUser() throws IOException {
		search_button.click();
		String username1 = ExcelUtility.readStringData(1, 0, "UserSearch");
		usernamesearch.sendKeys(username1);
		PageUtility page = new PageUtility();
		page.selectByIndex(usertype, 2);
		searchbutton.click();
		return this;
	}

	public boolean isUserAvailable() {
		return tablecontent.isDisplayed();
	}
}