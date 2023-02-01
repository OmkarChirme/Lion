package CS.New.resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CS.New.test.BaseTest;

public class Utilities extends BaseTest {
	public static void enterValue(By by, String data) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(data);
	}

	public static void clickOnElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
	}

	public static String getElementLable(By by) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
	}

}
