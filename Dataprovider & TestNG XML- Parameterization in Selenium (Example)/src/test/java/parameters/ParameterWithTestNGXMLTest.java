package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * ParameterWithTestNGXMLTest: Test class demonstrating parameterization using TestNG XML.
 */
public class ParameterWithTestNGXMLTest {

    // Path to the GeckoDriver executable
   // String driverPath = "C:\\geckodriver.exe";
    WebDriver driver;

    /**
     * Test method using parameters supplied by TestNG XML.
     *
     * @param author    The author parameter provided by TestNG XML.
     * @param searchKey The searchKey parameter provided by TestNG XML.
     * @throws InterruptedException If any thread has interrupted the current thread.
     */
    @Test
    @Parameters({"author", "searchKey"})
    public void testParameterWithXML(@Optional("Abc") String author, String searchKey) throws InterruptedException {

        // Step 1: Set system property for GeckoDriver
       // System.setProperty("webdriver.gecko.driver", driverPath);

        // Step 2: Initialize WebDriver (Firefox driver in this case)
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Step 3: Navigate to Google homepage
        driver.get("https://google.com");

        // Step 4: Find the search text box on Google homepage
        WebElement searchText = driver.findElement(By.name("q"));

        // Step 5: Input the search key into the search text box
        searchText.sendKeys(searchKey);

        // Display information about the test
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        System.out.println("Thread will sleep now");

        // Step 6: Pause execution for 3 seconds (simulating some activity)
        Thread.sleep(3000);

        // Step 7: Display information about the search text box values
        System.out.println("Value in Google Search Box = " + searchText.getAttribute("value") +
                " ::: Value given by input = " + searchKey);

        // Step 8: Verify that the value in the search text box matches the input search key
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));

        // Step 9: Close the WebDriver instance
        driver.quit();
    }


}
