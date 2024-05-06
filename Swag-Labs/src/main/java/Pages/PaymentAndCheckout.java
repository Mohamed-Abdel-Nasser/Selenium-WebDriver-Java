package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentAndCheckout
{
    // WebDriver instance and locators for elements on the payment and checkout page
    WebDriver driver;
    By CheckoutButton = By.id("checkout");
    By PaymentPageTitle = By.className("title");

    // Constructor to initialize the WebDriver instance
    public PaymentAndCheckout(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click the "Checkout" button on the payment and checkout page
    public void clickOnCheckoutButton() {
        driver.findElement(CheckoutButton).click();
    }

    // Method to retrieve the text of the payment page title on the payment and checkout page
    public String paymentPageTitle() {
        return driver.findElement(PaymentPageTitle).getText();
    }
}
