package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    // WebDriver instance and locators for elements on the home page
    WebDriver driver = null;
    By AddToCart = By.id("add-to-cart-sauce-labs-backpack");
    By CartLogo = By.className("shopping_cart_link");
    By NumberOfItems = By.className("shopping_cart_badge");
    By CartPageHeader = By.className("title");

    // Constructor to initialize the WebDriver instance
    public HomePage ( WebDriver driver)
    {
        this.driver = driver;
    }

    // Method to click on the "Add to Cart" button
    public void AddToCart ()
    {
        driver.findElement(AddToCart).click();
    }

    // Method to retrieve the number of items in the cart
    public String getNumberOfItems ()
    {
        return driver.findElement(NumberOfItems).getText();
    }

    // Method to navigate to the cart page by clicking on the cart logo
    public void goToCartPage ()
    {
        driver.findElement(CartLogo).click();
    }

    // Method to retrieve the cart page header text
    public String cartPageHeader ()
    {
        return driver.findElement(CartPageHeader).getText();
    }
}
