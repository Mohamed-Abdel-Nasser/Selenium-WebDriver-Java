package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCase13 extends Base {
    @Test
    public void productQuantityTest(){
        var productDetailPage = homePage.clickViewProduct();

        assertTrue(productDetailPage.verifyProductDetailsDisplay());
        productDetailPage.changeProductQuantity();
        productDetailPage.clickAddToCart();

        var cartPage = productDetailPage.clickViewCart();
        List<String> quantity = cartPage.getProductQuantity();
       assertEquals(quantity.get(0), "4", "Verify quantity in the cart");
    }


}
