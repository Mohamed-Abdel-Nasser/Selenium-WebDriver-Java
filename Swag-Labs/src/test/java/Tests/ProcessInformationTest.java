package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Tests.LoginTest.info;

public class ProcessInformationTest
{
        @Test(priority = 4)
        public void confirmProcess() throws InterruptedException {
        // This test method confirms the completion of the checkout process.

        // Step 1: Click on the Finish button on the process information page.
        info.clickFinishButton();
        Thread.sleep(2000); // Introducing a delay to allow the next page to load.

        // Step 2: Output the header of the confirmation page to the console.
        System.out.println(info.confirmationPageHeader());

        // Step 3: Verify that the header of the confirmation page matches the expected value.
        Assert.assertEquals(info.confirmationPageHeader(), "Checkout: Complete!");
    }
}
