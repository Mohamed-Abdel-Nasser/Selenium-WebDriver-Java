package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase10 extends Base{
    @Test
    public void verifySubscriptionHomePageTest(){
        assertTrue(homePage.verifySubscriptionDisplay());
        homePage.setSubscriptionEmail("saadia@gmail.com");
        homePage.clickSubscriptionButton();
        assertTrue(homePage.verifySubscriptionAlert());

    }
}
