package CS.New.pages;

import org.openqa.selenium.By;

import CS.New.resources.Utilities;
import CS.New.test.BaseTest;

public class AdminPage extends BaseTest{

	By lable = By.xpath("//div[@id='app']//div[2]/div/span");

	public AdminPage() {
		super();
	}

	public String getLable() {
		return Utilities.getElementLable(lable);
		// return driver.findElement(lable).getText();
	}
}
