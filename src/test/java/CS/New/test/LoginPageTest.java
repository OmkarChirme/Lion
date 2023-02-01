package CS.New.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CS.New.pages.LandingPage;
import CS.New.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage = null;
	LandingPage landingPage = null;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(); /// reading config.properties
		init(); // launching browser and url
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void LoginTest() {
		landingPage = loginPage.loginToAppl(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(landingPage.landingPageTitle(), "OrangeHRM", "LandingPage Title is NOT matching !!!");
	}

	@Test
	public void verifyLoginPageTitle() {
		Assert.assertEquals(loginPage.getLoginPageTitle(), "OrangeHRM", "LoginPAge Title is not matching");
	}

	@Test(dataProvider = "getData")
	public void verifyInvalidLoginCredentials(String username, String password) {
		String errorMsg = loginPage.verifyInvaliLoginToAppl(username, password);
		System.out.println("errorMsg: " + errorMsg);
		if (!username.isBlank() && !password.isBlank())
			Assert.assertEquals(errorMsg, "Invalid credentials");
		else if (username.isBlank() || password.isBlank())
			Assert.assertEquals(errorMsg, "Required");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "abc";
		data[0][1] = "   ";

		data[1][0] = "   ";
		data[1][1] = "abc";

		data[2][0] = "abc";
		data[2][1] = "abc";

		return data;
	}

}
