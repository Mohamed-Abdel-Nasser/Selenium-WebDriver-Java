package parameters;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoParameterWithTestNGXMLTest {
        // (1) WebDriver instance
    WebDriver driver;

        // (2) Test Method Declaration
    @Test
    public void testNoParameter() throws InterruptedException {
        // (3) Define test data (author and search keyword)
        String author = "guru99";
        String searchKey = "india";

        // (4) Initialize WebDriver (Firefox driver in this case)
        driver = new FirefoxDriver();
        // (5) Set implicit wait time for elements to be found
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // (6) Navigate to Google homepage
        driver.get("https://google.com");

        // (7) Find the search text box on Google homepage by its name and then Input the search key into the search text box
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);

        // (9) Display information about the test
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        System.out.println("Thread will sleep now");

        // (10) Pause execution for 3 seconds (simulating some activity)
        Thread.sleep(3000);

        // (11) Display information about the search text box values
        System.out.println("Value in Google Search Box = " + searchText.getAttribute("value") +
                " ::: Value given by input = " + searchKey);

        // (12) Verify that the value in the search text box matches the input search key
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));

        driver.quit();
    }
}
