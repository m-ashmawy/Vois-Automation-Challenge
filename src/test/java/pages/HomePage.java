package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * HomePage class represents the home page of the application.
 * It extends the Page class to inherit common functionality.
 */
public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}

    /**
     * Method to search for text in the search box and submit the search.
     * @param searchText The text to be entered into the search box.
     * @param searchBoxID The ID of the search box WebElement.
     */
	public void searchForText(String searchText, String searchBoxID) {
		// Find the search box WebElement using its ID
		WebElement searchBox = this.driver.findElement(By.id(searchBoxID));
		// Enter the search text into the search box
		searchBox.sendKeys(searchText);
		// Submit the search form
		searchBox.submit();
	}
}
