package testCasePackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import startUp.Base;

import java.awt.*;
import java.util.List;

public class TestCase12 extends Base {
    @Test
    public void addProductsToCartTest() throws InterruptedException, AWTException {

        var productPage = homePage.clickProducts();
        Thread.sleep(3000);
        var cartPage = productPage.addProductsToCart();
        java.util.List<String> productNames = cartPage.getProductsNames();
        Assert.assertEquals(productNames.size(),2,"verify both products added to cart");
        java.util.List<String> productsPrice = cartPage.getProductsPrice();
        java.util.List<String> productsQuantity = cartPage.getProductQuantity();
        List<String> productsTotalPrice = cartPage.getProductsTotalPrice();
        for (int i = 0; i < 2; i++){
            Assert.assertEquals(productsPrice.get(i),productsTotalPrice.get(i), "Verify their prices and total price");
            Assert.assertEquals(productsQuantity.get(i),"1","Verify Quantity equals 1");
            System.out.println(i + ". Prices = Total Prices | " + productsPrice.get(i) + " = " + productsTotalPrice.get(i));
            System.out.println(i + ". Quantity = 1 | " + productsQuantity.get(i).equals("1"));
        }

    }

}
