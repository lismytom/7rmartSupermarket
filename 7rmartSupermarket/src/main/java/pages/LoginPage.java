package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn_btn;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alert_close;

	public LoginPage enter_loginCredentials(String usernamefield, String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}

	public Home click_login_btn() throws AWTException {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementClickable(driver, signIn_btn);
		signIn_btn.click();
		return new Home(driver);
	}

	public boolean isDashboard_loaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlert_displayed() {
		return alert.isDisplayed();
	}
}
