package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase1 extends Base {
    @Test
    public void registerUserTest(){
        homePage.clickSignUp();
        assertTrue(signUpPage.signUpDisplay());

        signUpPage.setUserName(props.getProperty("UserName"));
        signUpPage.setEmail(props.getProperty("Email"));
        signUpPage.clickSignUpButton();
        assertTrue(signUpPage.accountInfoDisplay());

        signUpPage.setPassword(props.getProperty("Password"));
        signUpPage.selectDay(props.getProperty("Day"));
        signUpPage.selectMonth(props.getProperty("Month"));
        signUpPage.selectYear(props.getProperty("Year"));
        signUpPage.checkNewsLetter();
        signUpPage.setFirstName(props.getProperty("FirstName"));
        signUpPage.setLastName(props.getProperty("LastName"));
        signUpPage.setAdress(props.getProperty("Address"));
        signUpPage.setState(props.getProperty("State"));
        signUpPage.setcity(props.getProperty("city"));
        signUpPage.setzipcode(props.getProperty("zipcode"));
        signUpPage.setCompany(props.getProperty("Company"));
        signUpPage.setCountry(props.getProperty("Country"));
        signUpPage.setMobileNumber(props.getProperty("MobileNumber"));
        signUpPage.clickCreateAccountBtn();
        assertTrue(signUpPage.accountCreatedDisplay());
        signUpPage.clickContinue();
        //Verify logged As user
        assertTrue(signUpPage.loggedAsUserDisplay());
        //Delete account
        signUpPage.clickDeleteAccount();
       assertTrue(signUpPage.accountDeletedDisplay());
        signUpPage.clickContinue();

    }
}
