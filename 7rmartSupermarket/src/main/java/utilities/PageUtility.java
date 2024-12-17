package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public void scroll(WebElement scroll) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,500)");
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.moveToElement(source);
		actions.doubleClick(source).perform();
		actions.dragAndDrop(source, destination).build().perform();
	}
}
