package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase8 extends Base {
    @Test
    public void verifyAllProductsAndProductDetailTest() throws InterruptedException {
        var productPage = homePage.clickProducts();
        Thread.sleep(3000);
        assertTrue(productPage.verifyProductsDisplay());
        var productDetailPage= productPage.clickFirstProduct();
        Thread.sleep(3000);
        assertTrue(productDetailPage.verifyProductDetailsDisplay());
        assertTrue(productDetailPage.verifyNameDisplay());
        assertTrue(productDetailPage.verifyCategoryDisplay());
        assertTrue(productDetailPage.verifyPriceDisplay());
        assertTrue(productDetailPage.verifyAvilabilityDisplay());
        assertTrue(productDetailPage.verifyConditionDisplay());
        assertTrue(productDetailPage.verifyBrandDisplay());
    }

}
