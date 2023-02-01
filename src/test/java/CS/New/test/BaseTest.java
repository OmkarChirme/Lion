package CS.New.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static FileInputStream fis = null;
	public static Properties prop = null;

	/**
	 * default constructor : zero args
	 */
	public BaseTest() {
		String fileName = System.getProperty("user.dir") + "/src/test/java/CS/New/resources/config.properties";
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in loading properties file : " + fileName);
		}
	}

	// initialization of browser and url to launch
	public void init() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			throw new RuntimeException("Invalid Browser : " + browserName);

		String URL = prop.getProperty("url");
		driver.get(URL);
		int timeout = Integer.parseInt(prop.getProperty("timeout"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		boolean maximize = Boolean.parseBoolean(prop.getProperty("maximize"));
		if (maximize) // maximize == true
			driver.manage().window().maximize();
	}

}
