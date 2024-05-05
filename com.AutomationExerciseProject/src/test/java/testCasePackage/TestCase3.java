package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase3 extends Base {
    //Login user with incorrect email and password
    @Test
    public void loginWithIncorrectEmailAndPasswordTest() {
        homePage.clickSignUp();
        loginPage.loginEmail("Zeedan@gmail.com");
        loginPage.loginPassword("abc55123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.errorMessageDisplay());

    }
}
