package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Page class represents a generic web page in the application.
 */
public class Page {
	// WebDriver instance used for interacting with the web page
	WebDriver driver;

    /**
     * Constructor to initialize the Page with WebDriver.
     * @param driver WebDriver instance used for interacting with the web page.
     */
	public Page(WebDriver driver) {
		this.driver = driver;
	}

    /**
     * Method to scroll to the end of the page.
     * It uses JavaScriptExecutor to execute JavaScript code for scrolling.
     */
	public void scrollDownToEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
