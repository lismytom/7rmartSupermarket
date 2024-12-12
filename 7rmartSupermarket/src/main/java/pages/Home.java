package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminuser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement new_btn;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//child::i[@class='fas fa-arrow-circle-right']")
	WebElement admin_users;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//child::i[@class='fas fa-arrow-circle-right']")
	WebElement manage_news;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//child::i[@class='fas fa-arrow-circle-right']")
	WebElement manage_Subcategory_button;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//child::i[@class='fas fa-arrow-circle-right']")
	WebElement manage_contact_button;

	public Home logout() {
		admin.click();
		logout.click();
		return this;
	}

	public AdminUsersNewAddPage click_adminUsers_btn() {
		admin_users.click();
		return new AdminUsersNewAddPage(driver);
	}

	public AdminUsers_UserSearchPage click_AdminUsers_button() {
		admin_users.click();
		return new AdminUsers_UserSearchPage(driver);
	}

	public ManageNews_AddNews click_manageNews_btn() {
		manage_news.click();
		return new ManageNews_AddNews(driver);
	}

	public ManageCategory_AddSubCategory click_manageSubcategory_btn() {
		manage_Subcategory_button.click();
		return new ManageCategory_AddSubCategory(driver);
	}

	public ManageCategory_SearchSubCategory clickSearchSubCategory() {
		manage_Subcategory_button.click();
		return new ManageCategory_SearchSubCategory(driver);
	}

	public ManageContacts click_ManageContactButton() {
		manage_contact_button.click();
		return new ManageContacts(driver);
	}
}
