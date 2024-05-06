package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Tests.LoginTest.home;

public class HomeTest
{
    @Test(priority = 1)
    public void addToCartTest() throws InterruptedException
    {
        // Step 1: Add item to cart
        home.AddToCart();

        // Step 2: Wait for the cart to update (simulate asynchronous behavior)
        Thread.sleep(2000);

        // Step 3: Verify the number of items in the cart
        String ExpectedResult = home.getNumberOfItems(); // Get the current number of items in the cart
        String ActualResult = "1"; // Expected number of items after adding one item
        Assert.assertEquals(ExpectedResult, ActualResult, "Number of items in cart is not as expected");

        // Step 4: Output the current number of items in the cart to the console
        System.out.println("Current number of items in the cart: " + home.getNumberOfItems());

        // Step 5: Navigate to the cart page
        home.goToCartPage();

        // Step 6: Wait for the cart page to load
        Thread.sleep(2000);

        // Step 7: Verify that the cart page header is displayed correctly
        String cartPageHeader = home.cartPageHeader(); // Get the header text of the cart page
        String expectedCartPageHeader = "Your Cart"; // Expected cart page header text
        Assert.assertEquals(cartPageHeader, expectedCartPageHeader, "Cart page header is not as expected");
    }

}
