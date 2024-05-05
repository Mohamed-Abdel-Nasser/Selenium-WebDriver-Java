package testCasePackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import startUp.Base;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestCase9 extends Base {
    @Test

    public void searchProductsTest() throws InterruptedException {
        var productPage = homePage.clickProducts();
        Thread.sleep(3000);
        assertTrue(productPage.verifyProductsDisplay());
        String searchInput = "white";
        productPage.fillSearchProduct(searchInput);
        productPage.clickSearchButton();
        assertTrue(productPage.verifySearchedProductsDisplay());
        List<String> searchedProductsName = productPage.getSearchedProductsName();
        //Verify All Searched Products related to search input
        for (int i = 0; i < searchedProductsName.size(); i++) {
            Assert.assertTrue(searchedProductsName.get(i).toLowerCase().contains(searchInput.toLowerCase()));
            System.out.println(i + ". " + searchedProductsName.get(i) + " - contain: " + searchInput);

        }
    }
}
