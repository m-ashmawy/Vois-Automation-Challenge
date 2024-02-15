package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentManager;




/**
 * BaseTest class initializes WebDriver, loads configuration properties, and performs setup and teardown operations for tests.
 */
public class BaseTest {
	
	// WebDriver instance
	public static WebDriver driver = null;
	
	// ExtentReports instance for reporting
	public static ExtentReports extent;
	
	// Configuration properties
	public static Properties config = new Properties();
	public static FileReader fr_con;

    /**
     * Method executed before tests start. It sets up WebDriver, loads configuration properties.
     * @throws IOException if configuration properties file cannot be loaded.
     */
	@BeforeTest
	public void setUp() throws IOException  {
		// Initialize ExtentReports
		extent = ExtentManager.getInstance();
		
		// Load configuration properties
		fr_con = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configFiles/config.properties");
		config.load(fr_con);
		
		// Initialize WebDriver based on browser specified in config.properties
		char browser = config.getProperty("browser").charAt(0);
		switch (Character.toUpperCase(browser)) {
		case 'C':
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case 'E':
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case 'F':
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		// Set system information for ExtentReports
		extent.setSystemInfo("Operating System", System.getProperty("os.name")); 
		extent.setSystemInfo("Browser", driver.toString());
	}

    /**
     * Method executed after tests finish. It quits the WebDriver and flushes the ExtentReports instance.
     */
	@AfterTest
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

}
