package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

/**
 * TestUtils class provides utility methods for the tests.
 */
public class TestUtils extends BaseTest {

	/**
     * Method to take a screenshot of the current WebDriver instance.
     * @return Absolute path of the saved screenshot file.
     * @throws IOException if an I/O error occurs.
     */
	public static String takeScreenShot() throws IOException {
		// Generate a timestamped name for the screenshot
		String screenShotName = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
		
		// Capture screenshot as file
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Define the file path for saving the screenshot
		File filePath = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\" + screenShotName + ".png");
		
		// Copy screenshot file to the specified path
		FileUtils.copyFile(screenShotFile, filePath);

		// Return the absolute path of the saved screenshot file
		return filePath.getAbsolutePath();

	}

}
