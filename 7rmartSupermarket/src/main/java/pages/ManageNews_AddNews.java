package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews_AddNews {

	public WebDriver driver;

	public ManageNews_AddNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement new_button;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news_textbox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newscreation_alert;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alert_close;

	public ManageNews_AddNews click_newButton() {
		new_button.click();
		return this;
	}

	public ManageNews_AddNews enterNews(String news) {
		news_textbox.sendKeys("TestNews");
		return this;
	}

	public ManageNews_AddNews submitNews() {
		submit_button.click();
		return this;
	}

	public boolean isNewsCreatedSuccessfully() {
		return newscreation_alert.isDisplayed();
	}

	public void alert_close() {
		alert_close.click();
	}
}
