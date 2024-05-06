package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage
{
    // WebDriver instance and locators for elements on the Thank You page
    WebDriver driver;
    By BackToHomeButton = By.id("back-to-products");
    By HomePageHeader = By.className("title");

    // Constructor to initialize the WebDriver instance
    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click the "Back to Home" button on the Thank You page
    public void clickBackToHomeButton() {
        driver.findElement(BackToHomeButton).click();
    }

    // Method to retrieve the text of the home page header on the Thank You page
    public String homePageHeader() {
        return driver.findElement(HomePageHeader).getText();
    }
}
