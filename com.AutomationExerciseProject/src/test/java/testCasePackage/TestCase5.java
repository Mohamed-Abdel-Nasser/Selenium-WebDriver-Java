package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase5 extends Base {
    @Test
    public void registerWithExistEmail(){
        homePage.clickSignUp();
        assertTrue(signUpPage.signUpDisplay());
        signUpPage.setUserName("Leen");
        signUpPage.setEmail("Zeeda.lana@gmail.com");
        signUpPage.clickSignUpButton();
        assertTrue(signUpPage.emailExistErrorDisplay());

    }
}
