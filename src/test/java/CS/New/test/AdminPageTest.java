package CS.New.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CS.New.pages.AdminPage;
import CS.New.pages.LandingPage;
import CS.New.pages.LoginPage;

public class AdminPageTest extends BaseTest {
	LoginPage loginPage = null;
	LandingPage landingPage = null;
	AdminPage adminPage = null;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		init();
		landingPage = loginPage.loginToAppl("admin", "admin123");
		Assert.assertEquals(loginPage.getLoginPageTitle(), "OrangeHRM", "Login Title is not matching");
		adminPage = new AdminPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLable() {
		landingPage.clickOnAdminLink();
//		Assert.assertEquals(adminPage.getLable(), "(54) Records Found");
		Assert.assertTrue(adminPage.getLable().contains("Records123 Found"), "Records Found does not found !!!");
	}

}
