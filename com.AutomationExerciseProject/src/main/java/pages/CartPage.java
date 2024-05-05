package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyCartPageDisplay() {
       return driver.findElement(By.id("cart_info")).isDisplayed();
    }
    public boolean verifySubscriptionCartDisplay(){
        return driver.findElement(By.xpath("//div[@class='single-widget']//h2")).isDisplayed();
    }
    public void setSubscriptionCartEmail(String subEmail){
        driver.findElement(By.id("susbscribe_email")).sendKeys(subEmail);
    }
    public void clickSubscriptionCartButton(){
        driver.findElement(By.id("subscribe")).click();
    }
    public Boolean verifySubscriptionCartAlert(){
        return driver.findElement(By.id("success-subscribe")).isDisplayed();
    }
    //Get products names in the cart
    public List<String> getProductsNames(){
        List<WebElement> productName= driver.findElements(By.xpath("//td[contains(@class, 'cart_description')]//a"));
     return productName.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }
    //Get products price in the cart
    public List<String> getProductsPrice(){
        List<WebElement>productsPrice = driver.findElements(By.xpath("//td[@class='cart_price']//p"));
        return productsPrice.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    //Get products Quantity in the cart
    public List<String> getProductQuantity(){
        List<WebElement>productsQuantity = driver.findElements(By.xpath("//td[@class='cart_quantity']//button"));
        return productsQuantity.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    //Get products Total in the cart
    public List<String> getProductsTotalPrice(){
        List<WebElement>productsTotalPrice = driver.findElements(By.xpath("//P[@class='cart_total']"));
        return productsTotalPrice.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    //Add a comment
    public void addComment(String comment){
        driver.findElement(By.name("message")).sendKeys(comment);

    }
    //click place order button
    public PaymentPage clickPlaceOrder(){
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        return new PaymentPage(driver);
    }




    //Click proceed to check out
    public void clickProceedToCheckOut(){
        driver.findElement(By.linkText("Proceed To Checkout")).click();
    }
    public SignUpPage clickRegisterLoginLink(){
        WebElement registerOrLogin = driver.findElement(By.xpath("//a[@href='/login']//u"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , registerOrLogin);
        registerOrLogin.click();
        return new SignUpPage(driver);
    }
    //Delete first product
    public void clickXButton1(){
        driver.findElement(By.cssSelector("a[data-product-id='1']")).click();
    }
    //Delete Second product
    public void clickXButton2(){
        driver.findElement(By.cssSelector("a[data-product-id='2']")).click();
    }
    //Verify Cart is empty
    public boolean verifyEmptyCart(){
        WebElement emptyCart = driver.findElement(By.id("empty_cart"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(emptyCart));
        return emptyCart.isDisplayed();

    }

    public CheckOutPage clickLoggedProceedToCheckOut(){
        driver.findElement(By.linkText("Proceed To Checkout")).click();
        return new CheckOutPage(driver);


    }

}
