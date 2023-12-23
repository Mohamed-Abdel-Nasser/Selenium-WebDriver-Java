package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParameterByITestContextInDataproviderTest {

    // Declare a WebDriver instance for interaction with a web browser.
    WebDriver driver;

    // Specify the path to the Firefox driver executable.
    //String driverPath = "C:\\geckodriver.exe";

    /**
     * Setup method executed before the test for groups A and B.
     * Initializes the WebDriver, sets the system property for GeckoDriver path,
     * configures implicit wait, and navigates to the Google homepage.
     */
    @BeforeTest(groups={"A","B"})
    public void setup() {
        // Step 1: Set system property for GeckoDriver path
      //  System.setProperty("webdriver.gecko.driver", driverPath);

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

    @Test(dataProvider="SearchProvider", groups="A")
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
    @Test(dataProvider="SearchProvider", groups="B")
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
     * DataProvider method providing Object array based on the included groups in ITestContext.
     *
     * @param c The ITestContext providing information about the current test run.
     * @return Object[][] representing test data for different groups.
     */
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(ITestContext c) {
        // Initialize the two-dimensional array to store test data
        Object[][] groupArray = null;

        // Iterate over the included groups in the ITestContext
        for (String group : c.getIncludedGroups()) {
            // Check if the group is "A" (case-insensitive comparison)
            if(group.equalsIgnoreCase("A")){
                // Assign the groupArray with test data for group A
                groupArray = new Object[][] {
                        { "Guru99", "India" },
                        { "Krishna", "UK" },
                        { "Bhupesh", "USA" }
                };
                // Break the loop after processing group A
                break;
            }
            // Check if the group is "B" (case-insensitive comparison)
            else if(group.equalsIgnoreCase("B")) {
                // Assign the groupArray with test data for group B
                groupArray = new Object[][] {
                        {  "Canada" },
                        {  "Russia" },
                        {  "Japan" }
                };
            }
            // Break the loop after processing the first group (This may be unintentional)
            break;
        }

        // Return the test data based on the included groups
        return groupArray;
    }

}
