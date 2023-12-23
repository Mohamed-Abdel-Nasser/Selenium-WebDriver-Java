package parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * ParameterByDataprovider: Test class demonstrating parameterization using TestNG DataProvider.
 */
public class ParameterByDataproviderTest {

    // WebDriver instance
    WebDriver driver;
    //String driverPath = "C:\\geckodriver.exe";

    /**
     * Setup method executed before the test.
     * It initializes the WebDriver, configures implicit wait, and navigates to the Google homepage.
     */

    @BeforeTest
    public void setup() {
        // Step 1: Create Firefox driver object
        // <Note>: GeckoDriver path is not set explicitly as it's assumed to be in the system's PATH.
        // System.setProperty("webdriver.gecko.driver", driverPath);

        // Step 2: Initialize WebDriver (Firefox driver in this case)
        driver = new FirefoxDriver();

        // Step 3: Configure implicit wait to wait for elements to be found
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Step 4: Navigate to Google homepage
        driver.get("https://google.com");
    }

    /**
     * Test method to verify the Google search box with parameters provided by the DataProvider.
     *
     * @param author    The author parameter provided by the DataProvider.
     * @param searchKey The searchKey parameter provided by the DataProvider.
     * @throws InterruptedException If any thread has interrupted the current thread.
     */

    @Test(dataProvider = "SearchProvider")
    public void testMethod(String author, String searchKey) throws InterruptedException {
        // Step 1: Find the Google search box
        WebElement searchText = driver.findElement(By.name("q"));

        // Step 2: Enter the search key into the Google search box
        searchText.sendKeys(searchKey);

        // Step 3: Display information about the test
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);

        // Step 4: Pause execution for 3 seconds (simulating some activity)
        Thread.sleep(3000);

        // Step 5: Get the value entered in the search box
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);

        // Step 6: Clear the search box for the next test
        searchText.clear();

        // Step 7: Verify if the value in the Google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }

    /**
     * DataProvider method providing Object array with test data.
     *
     * @return Object[][] where the first column contains 'author' and the second column contains 'searchKey'.
     */
    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataprovider() {
        // Step 1: Define and return the test data for the test case
        return new Object[][]
                {
                        {"Guru99", "India"},
                        {"Krishna", "UK"},
                        {"Bhupesh", "USA"}
                };
    }
}

