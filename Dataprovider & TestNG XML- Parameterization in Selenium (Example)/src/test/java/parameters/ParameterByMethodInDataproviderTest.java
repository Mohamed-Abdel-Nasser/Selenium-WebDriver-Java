package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ParameterByMethodInDataproviderTest {

    /**
     * WebDriver instance for performing browser automation.
     */
    WebDriver driver;

    /**
     * Path to the GeckoDriver executable.
     */
 //   String driverPath = "C:\\geckodriver.exe";


    /**
     * Setup method executed before the test.
     * Initializes the WebDriver, configures implicit wait, and navigates to the Google homepage.
     */
    @BeforeTest
    public void setup() {
        // Step 1: (Optional) Set system property for GeckoDriver path if needed
        // System.setProperty("webdriver.gecko.driver", driverPath);

        // Step 2: Initialize WebDriver (Firefox driver in this case)
        driver = new FirefoxDriver();

        // Step 3: Configure implicit wait to wait for elements to be found
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Step 4: Navigate to Google homepage
        driver.get("https://google.com");
    }

    /**
     * Test method for group A, using data provided by the "SearchProvider" DataProvider.
     *
     * @param author    The author parameter provided by the DataProvider.
     * @param searchKey The searchKey parameter provided by the DataProvider.
     * @throws InterruptedException If any thread has interrupted the current thread.
     */
    @Test(dataProvider="SearchProvider")
    public void testMethodA(String author, String searchKey) throws InterruptedException {
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
     * Test method for group B, using data provided by the "SearchProvider" DataProvider.
     *
     * @param searchKey The searchKey parameter provided by the DataProvider.
     * @throws InterruptedException If any thread has interrupted the current thread.
     */
    @Test(dataProvider="SearchProvider")
    public void testMethodB(String searchKey) throws InterruptedException {
        // Step 1: Find the Google search box
        WebElement searchText = driver.findElement(By.name("q"));

        // Step 2: Enter the search key into the Google search box
        searchText.sendKeys(searchKey);

        // Step 3: Display information about the test
        System.out.println("Welcome ->Unknown user Your search key is->" + searchKey);

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
     * DataProvider method providing Object array with test data based on the test method name.
     *
     * @param m The test method for which data is being provided.
     * @return Object[][] where the first column contains 'author' and the second column contains 'searchKey'
     *         if the test method is "testMethodA", or only 'searchKey' if the test method is "testMethodB".
     */
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(Method m) {
        // Step 1: Check the name of the test method and provide data accordingly
        if (m.getName().equalsIgnoreCase("testMethodA")) {
            // Step 2: Provide test data for testMethodA
            return new Object[][] {
                    { "Guru99", "India" },
                    { "Krishna", "UK" },
                    { "Bhupesh", "USA" }
            };
        } else {
            // Step 3: Provide default test data for other test methods
            return new Object[][] {
                    { "Canada" },
                    { "Russia" },
                    { "Japan" }
            };
        }
    }
}
