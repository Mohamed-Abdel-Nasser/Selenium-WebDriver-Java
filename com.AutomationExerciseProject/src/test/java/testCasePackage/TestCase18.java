package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCase18 extends Base {
    @Test
    public void viewCategoryProductsTest(){
        assertTrue(homePage.verifyCategoryProducts());
        homePage.clickWomenCategory();
       var productsPage= homePage.clickDressWomenCategory();
       assertEquals(productsPage.getProductsTitle(),"WOMEN - DRESS PRODUCTS","verify Women products title");
       //Men category
        productsPage.clickMenCategory();
        productsPage.clickJeansMenCategory();
        assertEquals(productsPage.getProductsTitle(),"MEN - JEANS PRODUCTS","verify Men products title");


    }
}
