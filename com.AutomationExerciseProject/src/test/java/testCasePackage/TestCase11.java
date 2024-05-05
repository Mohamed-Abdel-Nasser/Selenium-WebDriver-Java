package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase11 extends Base {
    @Test
    public void verifySubscriptionCartPageTest(){
        var cartPage = homePage.clickCartPage();
        assertTrue(cartPage.verifyCartPageDisplay());
        assertTrue(cartPage.verifySubscriptionCartDisplay());
        cartPage.setSubscriptionCartEmail("sadia.@gmail.com");
        cartPage.clickSubscriptionCartButton();
        assertTrue(cartPage.verifySubscriptionCartAlert());

    }
}
