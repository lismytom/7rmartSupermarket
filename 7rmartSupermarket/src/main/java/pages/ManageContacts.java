package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageContacts {

	public WebDriver driver;

	public ManageContacts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@role='button']")
	WebElement edit_button;
	@FindBy(id = "phone")
	WebElement phone_textfield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_textfield;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement address_textfield;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement delivery_time_textfield;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement delivery_charge_limit_textfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement update_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement contact_updation_alert;

	public ManageContacts clickEditbutton() {
		edit_button.click();
		return this;
	}

	public ManageContacts clearExistingDetails() {
		phone_textfield.clear();
		email_textfield.clear();
		address_textfield.clear();
		delivery_time_textfield.clear();
		delivery_charge_limit_textfield.clear();
		return this;
	}

	public ManageContacts updatePhonefield(String phone) {
		phone_textfield.sendKeys(phone);
		return this;
	}

	public ManageContacts updateEmailfield(String email) {
		email_textfield.clear();
		email_textfield.sendKeys(email);
		return this;
	}

	public ManageContacts updateAddressfield(String address) {
		address_textfield.sendKeys(address);
		return this;
	}

	public ManageContacts updateDeliveryTimefield(String delivery_time) {
		delivery_time_textfield.sendKeys(delivery_time);
		return this;
	}

	public ManageContacts updateDeliveryChargeLimitfield(String delivery_limit) {
		delivery_charge_limit_textfield.clear();
		delivery_charge_limit_textfield.sendKeys(delivery_limit);
		return this;
	}

	public ManageContacts clickUpdateButton() throws Exception {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		update_button.click();
		return this;
	}

	public boolean iscontactUpdatedSuccessfully() {
		return contact_updation_alert.isDisplayed();
	}
}
