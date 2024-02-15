package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ResultsPage class represents the page displaying search results.
 * It extends the Page class to inherit common functionality.
 */
public class ResultsPage extends Page {
	// Locator for the next page button
	private By nextPageLocator;

	// Locator for the search results
	private By searchResultsLocator;
	
	/**
     * Constructor to initialize the ResultsPage with WebDriver and locator selectors.
     * @param driver WebDriver instance used for interacting with the web elements.
     * @param nextPageBtnSelector CSS selector for the next page button.
     * @param searchResultsSelector CSS selector for the search results.
     */
	public ResultsPage(WebDriver driver, String nextPageBtnSelector, String searchResultsSelector) {
		super(driver);
		this.nextPageLocator = By.cssSelector(nextPageBtnSelector);
		this.searchResultsLocator = By.cssSelector(searchResultsSelector);
	}

	/**
     * Method to check if pagination exists (next page button exists).
     * @return true if pagination exists, false otherwise.
     */
     public boolean isPaginationExist() {
        try {
    		WebElement nextPageButton = driver.findElement(nextPageLocator);
            return nextPageButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

	/**
     * Method to navigate to the next page of search results.
     */
	public void goToNextPage() {	
		WebElement nextPageButton = driver.findElement(nextPageLocator);
		nextPageButton.click();
	}
	
	/**
     * Method to get the number of search results on the current page.
     * @return The number of search results.
     */
	public int getNumberOfResults() {
		List<WebElement> searchResults = driver.findElements(searchResultsLocator);
		return searchResults.size();
	}

}
