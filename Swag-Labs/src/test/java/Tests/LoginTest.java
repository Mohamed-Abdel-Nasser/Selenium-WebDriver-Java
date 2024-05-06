package Tests;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class LoginTest
{

    WebDriver driver =null;
    LoginPage loginPage;
    public static HomePage home;
    public static PaymentAndCheckout payment;
    public static CustomerDetails customer;
    public static ProcessInformation info;
    public static ThankYouPage thankyou;


    @BeforeTest
    public void Configuration() throws IOException, ParseException
    {
        WebDriverManager.chromedriver().setup(); // Setup WebDriverManager to manage the ChromeDriver
        driver = new ChromeDriver();  // Initialize a new ChromeDriver instance

        // Initialize Page Object instances using the WebDriver instance
        loginPage = new LoginPage(driver);            // Initialize LoginPage with the WebDriver instance
        home = new HomePage(driver);                   // Initialize HomePage with the WebDriver instance
        payment = new PaymentAndCheckout(driver);      // Initialize PaymentAndCheckout with the WebDriver instance
        customer = new CustomerDetails(driver);        // Initialize CustomerDetails with the WebDriver instance
        info = new ProcessInformation(driver);         // Initialize ProcessInformation with the WebDriver instance
        thankyou = new ThankYouPage(driver);           // Initialize ThankYouPage with the WebDriver instance

        // Maximize the browser window to ensure all elements are visible
        driver.manage().window().maximize();

        // Set implicit wait to handle synchronization issues, waiting up to 20 seconds for elements to be present
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 0)
    public void loginTest() throws InterruptedException
    {
        // Navigate to the Sauce Demo website
        driver.get("https://www.saucedemo.com/");

        // Enter the username on the login page
        loginPage.enterUserName();
        Thread.sleep(2000); // Wait for 2 seconds to ensure username is entered

        // Enter the password on the login page
        loginPage.enterPassword();
        Thread.sleep(2000); // Wait for 2 seconds to ensure password is entered

        // Click the Login button after entering credentials
        loginPage.clickLogin();
        Thread.sleep(2000); // Wait for 2 seconds to ensure login process is completed

        // Print the header of the home page to the console
        System.out.println(loginPage.homePageHeader());

        // Verify that the header of the home page is "Products" using assertion
        Assert.assertEquals(loginPage.homePageHeader(), "Products");
    }

    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }
}
