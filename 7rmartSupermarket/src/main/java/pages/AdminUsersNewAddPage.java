package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUsersNewAddPage {
	public WebDriver driver;

	public AdminUsersNewAddPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement Admin_home;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement new_btn;
	@FindBy(xpath = "//h3[@class='card-title']")
	WebElement user_information;
	@FindBy(xpath = "//input[@name='username']")
	WebElement new_username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement new_password;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement user_type;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save_btn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement usercreation_alert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement save_alert;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alert_close;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement tablecontent;

	public AdminUsersNewAddPage click_newBtn() throws IOException {
		new_btn.click();
		return this;
	}

	public AdminUsersNewAddPage eneterUsernameandpasswordfields(String newusername, String newpassword)
			throws IOException {
		new_username.sendKeys(newusername);
		new_password.sendKeys(newpassword);
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(user_type, 2);
		return this;
	}

	public AdminUsersNewAddPage click_SaveButton() {
		save_btn.click();
		return this;
	}

	public boolean isTableDisplayed() {
		return tablecontent.isDisplayed();
	}

	public boolean isUserCreatedSuccessfully() {
		return usercreation_alert.isDisplayed();
	}

	public void alert_close() {
		alert_close.click();
	}
}