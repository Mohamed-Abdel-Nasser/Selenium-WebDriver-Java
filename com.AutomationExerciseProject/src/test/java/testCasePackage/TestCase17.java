package testCasePackage;

import org.testng.annotations.Test;
import startUp.Base;

import static org.testng.Assert.assertTrue;

public class TestCase17 extends Base {
    @Test
    public void removeProductsFromCartTest(){
        homePage.clickSignUp();
        loginPage.loginEmail(props.getProperty("Email"));
        loginPage.loginPassword(props.getProperty("Password"));
        loginPage.clickLoginButton();
        assertTrue(loginPage.loggedAsUserDisplay());

        //Add Products to Cart
        var productPage = homePage.clickProducts();

        var cartPage = productPage.addProductsToCart();
        assertTrue(cartPage.verifyCartPageDisplay());

        //Delete products
        cartPage.clickXButton1();
        cartPage.clickXButton2();
        //verify cart is empty
        assertTrue(cartPage.verifyEmptyCart());


    }

}
