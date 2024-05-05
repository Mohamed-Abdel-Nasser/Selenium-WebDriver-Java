package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase6 extends Base {
    @Test
    public void ContactusPageTest()  {
        var contactUsPage= homePage.clickContactUsButton();
        assertTrue(contactUsPage.verifyGetInTouchDisplay());
        contactUsPage.setContactName("Leen");
        contactUsPage.setContactEmail("zeeda@gmail.com");
        contactUsPage.setContactSubject("start");
        contactUsPage.setContactMessage("Thank you for this products");
        contactUsPage.clickChooseFile("D:\\testingFiles");
        contactUsPage.clickSubmit();
        contactUsPage.acceptAlert();
        assertTrue(contactUsPage.submitSuccessDisplay());
        contactUsPage.clickHomeButton();

        assertTrue(contactUsPage.homePageDisplay());
    }

}
