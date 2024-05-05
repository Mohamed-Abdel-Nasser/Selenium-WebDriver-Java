package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase7 extends Base {
    @Test
    public void verifyTestCasesPageTest() {
        var testCasesPage = homePage.clickTestCases();
        assertTrue(testCasesPage.testCasesDisplay());
    }

}
