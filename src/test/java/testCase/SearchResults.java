package testCase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.HomePage;
import pages.ResultsPage;
import utilities.ReadExternalData;
import utilities.TestUtils;

/**
 * SearchResults class contains test methods related to searching and verifying search results.
 */
public class SearchResults extends BaseTest {

    /**
     * Test method to verify the number of search results across multiple pages.
     * @param testName Name of the test case.
     * @param testDescription Description of the test case.
     * @param url URL of the search page.
     * @param searchText Text to search for.
     * @param searchBoxID ID of the search box element.
     * @param nextPageBtnSelector CSS selector for the next page button.
     * @param searchResultsSelector CSS selector for the search results.
     * @throws Exception if any error occurs during test execution.
     */
	@Test(dataProvider = "testdata", dataProviderClass = ReadExternalData.class)
	public void NumberOfSearchResults(String testName, String testDescription, String url, String searchText,
			String searchBoxID, String nextPageBtnSelector, String searchResultsSelector) throws Exception {

		/**
		 *  create a new test instance with a name and description,
		 *  and then logs an informational message about the search text to the report.
		*/
		ExtentTest test = extent.createTest(testName, testDescription);
		test.info("Search Text: " + searchText);

		try {
			// Set implicit wait for WebDriver
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    // Open the URL
			driver.get(url);
			test.pass("URL opened successfully");

			// Create objects of home page and results page
			HomePage hp = new HomePage(driver);
			ResultsPage rp = new ResultsPage(driver, nextPageBtnSelector, searchResultsSelector);

			// Perform search
			hp.searchForText(searchText, searchBoxID);
			test.pass("Typed and searched successfully");

			// Assert pagination exists
			Assert.assertTrue(rp.isPaginationExist(), "There is no other pages of search results");

			// Scroll to the end, go to next page, and verify number of results on page 2
			rp.scrollDownToEnd();
			rp.goToNextPage();
			test.pass("Scrolled down and navigated to the next page");
			int resultsOnPage2 = rp.getNumberOfResults();

			// Assert pagination exists after navigating to next page
			Assert.assertTrue(rp.isPaginationExist(), "There is no other pages of search results");
			
			// Scroll to the end, go to next page again, and verify number of results on page 3
			rp.scrollDownToEnd();
			rp.goToNextPage();
			test.pass("Scrolled down and navigated to the next page again");
			int resultsOnPage3 = rp.getNumberOfResults();

			// Assert number of results on page 2 and page 3 are the same
			Assert.assertEquals(resultsOnPage2, resultsOnPage3,
					"Number of results in page 2 and page 3 are not the same");
			test.pass("search results are the same in page2 and page3");

		} catch (AssertionError e) {
			// Catch assertion errors and report failure
			test.fail(e.getMessage());

			// Rethrow the assertion error to mark the test as failed in TestNG
			throw e;
		} catch (Exception e) {
			// Catch any other exceptions and report failure
			test.fail("An unexpected error occurred: " + e.getMessage());
			throw e;
		} finally {
			// Add screenshot to the test report whether the test failed or succeeded
			test.addScreenCaptureFromPath(TestUtils.takeScreenShot());
		}
	}

}
