package Pages;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;


// This class represents the Customer Details section for checkout
public class CustomerDetails
{
    // WebDriver instance to interact with web elements on the Customer Details section
    WebDriver driver = null;

    // JSONParser and JSONObject for parsing data from a JSON file
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("Utilities\\read.json"));

    // Locators for web elements on the Customer Details section
    By FirstNameTextbox = By.id("first-name");
    By LastNameTextbox = By.id("last-name");
    By PostalCodeTextbox = By.id("postal-code");
    By ContinueButton = By.id("continue");
    By ProcessInformationHeader = By.className("title");


    // Constructor to initialize the WebDriver instance and parse JSON data
    public CustomerDetails (WebDriver driver) throws IOException, ParseException
    {
        this.driver = driver;
    }

    // Method to enter the first name into the corresponding text box
    public void enterFirstName ()
    {
        // Retrieve the first name from the JSON object and enter it into the text box
        driver.findElement(FirstNameTextbox).sendKeys(jsonObject.get("FirstName").toString());
    }

    // Method to enter the last name into the corresponding text box
    public void enterLastName ()
    {
        // Retrieve the last name from the JSON object and enter it into the text box
        driver.findElement(LastNameTextbox).sendKeys(jsonObject.get("LastName").toString());
    }

    // Method to enter the postal code into the corresponding text box
    public void enterPostalCode ()
    {
        // Retrieve the postal code from the JSON object and enter it into the text box
        driver.findElement(PostalCodeTextbox).sendKeys(jsonObject.get("PostalCode").toString());
    }

    // Method to click the Continue button to proceed with checkout
    public void clickContinueButton ()
    {
        // Locate the Continue button and simulate a click action
        driver.findElement(ContinueButton).click();
    }

    // Method to retrieve the text of the process information header after continuing
    public String processInformationHeader ()
    {
        // Find the process information header element and return its text
        return driver.findElement(ProcessInformationHeader).getText();
    }
}
