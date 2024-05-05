package testCasePackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import startUp.Base;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCase16 extends Base {
    @Test
    public void placeOrderLoginBeforeCheckOutTest(){
        homePage.clickSignUp();
        loginPage.loginEmail(props.getProperty("Email"));
        loginPage.loginPassword(props.getProperty("Password"));
        loginPage.clickLoginButton();
        assertTrue(loginPage.loggedAsUserDisplay());

        //Add Products to Cart
        var productPage = homePage.clickProducts();
        var cartPage = productPage.addProductsToCart();

        var checkOutPage  = cartPage.clickLoggedProceedToCheckOut();
        List<String> deliveryAddress = checkOutPage.grtDeliveryAddress();
        List<String> billingAddress = checkOutPage.getBillingAddress();
        Assert.assertEquals(deliveryAddress.get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
        Assert.assertEquals(billingAddress.get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

        for (int i = 1; i < 8; i++) {
            Assert.assertEquals(deliveryAddress.get(i), billingAddress.get(i), "Verify Address Details");
        }
        String line1 = ". "+props.getProperty("FirstName")+" "+props.getProperty("LastName");
        String line2 = props.getProperty("Company");
        String line3 = props.getProperty("Address");
        String line5 = props.getProperty("city")+" "+props.getProperty("State")+" "+props.getProperty("zipcode");
        String line6 = props.getProperty("Country");
        String line7 = props.getProperty("MobileNumber");

        assertEquals(deliveryAddress.get(1), line1 , "verify delivery name");
        assertEquals(deliveryAddress.get(2), line2 , "verify delivery company");
        assertEquals(deliveryAddress.get(3), line3 , "verify delivery address");
        assertEquals(deliveryAddress.get(5), line5 , "verify delivery city and state");
        assertEquals(deliveryAddress.get(6), line6 , "verify delivery country");
        assertEquals(deliveryAddress.get(7), line7 , "verify delivery mobile number");

        //Add comment
        cartPage.addComment("Thanks for quality products");
        //click place order button
        var paymentPage = cartPage.clickPlaceOrder();
        assertEquals(paymentPage.verifyPaymentPage() , "Payment", "verify Payment page");
        //set card data
        paymentPage.setNameOnCard(props.getProperty("nameOnCard"));
        paymentPage.setCardNumber(props.getProperty("cardNumber"));
        paymentPage.setCvc(props.getProperty("cvc"));
        paymentPage.setExpiryMonth(props.getProperty("expirationMonth"));
        paymentPage.setExpiryYear(props.getProperty("expirationYear"));

        //click pay and confirm button
        paymentPage.clickPayAndConfirm();

        //verify success payment alert
        assertTrue(paymentPage.verifySuccessAlert(), "verify success payment alert");

        //Delete account
        signUpPage.clickDeleteAccount();
        signUpPage.accountDeletedDisplay();


    }

}
