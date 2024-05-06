package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProcessInformation
{
    // WebDriver instance and locators for elements on the process information page
    WebDriver driver;
    By FinishButton = By.id("finish");
    By ProcessConfirmation = By.className("title");

    // Constructor to initialize the WebDriver instance
    public ProcessInformation(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click the "Finish" button on the process information page
    public void clickFinishButton() {
        driver.findElement(FinishButton).click();
    }

    // Method to retrieve the text of the confirmation page header on the process information page
    public String confirmationPageHeader() {
        return driver.findElement(ProcessConfirmation).getText();
    }
}
