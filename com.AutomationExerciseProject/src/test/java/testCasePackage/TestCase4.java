package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase4 extends Base {
    @Test
    public void logoutTest(){
        homePage.clickSignUp();
        assertTrue(loginPage.loginDisplay());
        loginPage.loginEmail("Zeeda.lanaleen000@gmail.com");
        loginPage.loginPassword("abc123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.loggedAsUserDisplay());
        loginPage.clickLogoutButton();
        assertTrue(loginPage.loginDisplay());


    }
}
