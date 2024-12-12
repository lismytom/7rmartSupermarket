package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public WebDriver driver;

	public void sendKeysFileupload(WebElement choosefile_button, String TESTIMAGEFILE) {
		choosefile_button.sendKeys(TESTIMAGEFILE);
	}

	public void robotFileUpload(WebElement choosefile_button, String TESTIMAGEFILE) throws AWTException {
		StringSelection select = new StringSelection(TESTIMAGEFILE);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		robot.delay(50);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
