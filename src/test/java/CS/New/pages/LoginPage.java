package CS.New.pages;

import org.openqa.selenium.By;

import CS.New.resources.Utilities;
import CS.New.test.BaseTest;

public class LoginPage extends BaseTest {
	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin    = By.xpath("//button[@type='submit']");
	
	By errorMsg = By.xpath("//div[@id='app']//div[1]/p");
	By requiredErrorMsg = By.xpath("//div[@id='app']//form//span");
	
	public LoginPage()
	{
		super();  // reads config.properties file
	}
	
	public void enterUsername(String username)
	{   // mistake
		//driver.findElement(txtUsername).sendKeys("admin");
		
		Utilities.enterValue(txtUsername, username);
		//driver.findElement(txtUsername).sendKeys(username);
			
	}
	
	public void enterPassword(String pwd)
	{
		// mistake
//		driver.findElement(txtPassword).sendKeys("admin123");
		
		Utilities.enterValue(txtPassword, pwd);
		//driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		
		Utilities.clickOnElement(btnLogin);

	//	driver.findElement(btnLogin).click();
	}
	
	public LandingPage loginToAppl(String uname, String pwd)
	{
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginBtn();
		return new LandingPage(); // chaining of pages
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyInvaliLoginToAppl(String uname, String pwd)
	{
		String returnMsg=null;
		
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginBtn();
		
		if (!uname.isBlank() && !pwd.isBlank())
			returnMsg = driver.findElement(errorMsg).getText();
		else if (uname.isBlank() || pwd.isBlank())
			returnMsg = driver.findElement(requiredErrorMsg).getText();
		
		return returnMsg;
	}

}
