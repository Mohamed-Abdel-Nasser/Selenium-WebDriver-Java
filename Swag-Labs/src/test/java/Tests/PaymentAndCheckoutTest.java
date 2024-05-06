package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Tests.LoginTest.payment;

public class PaymentAndCheckoutTest
{
    @Test(priority = 2)
    public void checkout() throws InterruptedException {
        // This test method simulates the checkout process.

        // Step 1: Click on the checkout button on the payment page.
        payment.clickOnCheckoutButton();
        Thread.sleep(2000); // Introducing a delay to allow the next page to load.

        // Step 2: Output the title of the payment page to the console.
        System.out.println(payment.paymentPageTitle());

        // Step 3: Verify that the title of the payment page matches the expected value.
        Assert.assertEquals(payment.paymentPageTitle(), "Checkout: Your Information");
    }

}
