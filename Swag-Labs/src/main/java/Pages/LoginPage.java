package Pages;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage
{
    WebDriver driver =null;
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("Utilities\\read.json"));
    By userNameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");
    By homePageHeader = By.className("title");

    // Constructor to initialize the WebDriver instance and read JSON data
    public LoginPage (WebDriver driver) throws IOException, ParseException
    {
        this.driver = driver;
    }

    // Method to enter the username on the login page
    public void enterUserName ()
    {
        // Find the username input element and enter the username from JSON data
        driver.findElement(userNameLocator).sendKeys(jsonObject.get("username").toString());
    }

    // Method to enter the password on the login page
    public void enterPassword ()
    {
        // Find the password input element and enter the password from JSON data
        driver.findElement(passwordLocator).sendKeys(jsonObject.get("password").toString());
    }

    // Method to click the login button on the login page
    public void clickLogin ()
    {
        // Find the login button element and click it
        driver.findElement(loginButtonLocator).click();
    }

    // Method to retrieve the text of the home page header after login
    public String homePageHeader ()
    {
        // Find the home page header element and return its text
        return driver.findElement(homePageHeader).getText();
    }
}
