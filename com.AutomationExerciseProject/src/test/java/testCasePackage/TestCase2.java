package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase2 extends Base {
    @Test
    public void LoginUserWithCorrectEmailAndPasswordTest(){
        homePage.clickSignUp();
        loginPage.loginEmail("Zeeda.lana@gmail.com");
        loginPage.loginPassword("abc123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.loggedAsUserDisplay());
        loginPage.clickDeleteAccount();
        assertTrue(loginPage.accountDeletedDisplay());
        loginPage.clickContinue();

    }
}
