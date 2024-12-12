package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void selectByIndex(WebElement usertype_val, int index) {
		Select user_type = new Select(usertype_val);
		user_type.selectByIndex(index);
	}

	public void selectByIndex1(WebElement category_val, int index) {
		Select category = new Select(category_val);
		category.selectByIndex(index);
	}

}
