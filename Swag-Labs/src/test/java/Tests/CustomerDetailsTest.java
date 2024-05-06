package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Tests.LoginTest.customer;

public class CustomerDetailsTest
{
    @Test(priority = 3)
    public void fillCustomerData() throws InterruptedException {
        // Step 1: Enter the first name of the customer
        customer.enterFirstName();
        Thread.sleep(2000);

        // Step 2: Enter the last name of the customer
        customer.enterLastName();
        Thread.sleep(2000);

        // Step 3: Enter the postal code of the customer
        customer.enterPostalCode();
        Thread.sleep(2000);

        // Step 4: Click the 'Continue' button to proceed
        customer.clickContinueButton();
        Thread.sleep(2000);

        // Step 5: Output the header of the information processing page to the console
        System.out.println(customer.processInformationHeader());

        // Step 6: Verify that the header of the information processing page is displayed correctly
        Assert.assertEquals(customer.processInformationHeader(), "Checkout: Overview");
    }
}
