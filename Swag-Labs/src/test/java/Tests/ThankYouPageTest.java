package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Tests.LoginTest.thankyou;

public class ThankYouPageTest
{
    @Test(priority = 5)
    public void backToHome() throws InterruptedException {
        // This test method verifies the functionality of returning to the home page from the thank you page.

        // Step 1: Click on the "Back to Home" button on the thank you page.
        thankyou.clickBackToHomeButton();
        Thread.sleep(2000); // Introducing a delay to allow the home page to load.

        // Step 2: Output the header of the home page to the console.
        System.out.println(thankyou.homePageHeader());

        // Step 3: Verify that the header of the home page matches the expected value ("Products").
        Assert.assertEquals(thankyou.homePageHeader(), "Products");
    }

}
