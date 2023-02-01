package CS.New.pages;

import org.openqa.selenium.By;

import CS.New.resources.Utilities;
import CS.New.test.BaseTest;

public class LandingPage extends BaseTest {
	By linkAdmin = By.xpath("//div[@id='app']//li[1]/a");

	public LandingPage() {
		super(); // reads config.proeprties
	}

	public void clickOnAdminLink() {
		Utilities.clickOnElement(linkAdmin);
		// driver.findElement(linkAdmin).click();
	}

	public String landingPageTitle() {
		return driver.getTitle();
	}

}
