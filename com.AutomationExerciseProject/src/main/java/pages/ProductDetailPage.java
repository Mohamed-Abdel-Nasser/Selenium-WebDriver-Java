package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductDetailPage {
    WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

    //Verify product detail page open successfully
    public boolean verifyProductDetailsDisplay() {
        return driver.findElement(By.className("product-information")).isDisplayed();
    }
    public boolean verifyNameDisplay() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")).isDisplayed();
    }

    public boolean verifyCategoryDisplay() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")).isDisplayed();
    }

    public boolean verifyPriceDisplay() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")).isDisplayed();
    }

    public boolean verifyAvilabilityDisplay() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")).isDisplayed();
    }

    public boolean verifyConditionDisplay() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b")).isDisplayed();
    }

    public boolean verifyBrandDisplay() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b")).isDisplayed();
    }
    //Set product quantity equals 4
    public void changeProductQuantity(){
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4");

    }
    //click add to cart button
    public void clickAddToCart(){
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
    }
    public CartPage clickViewCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
       WebElement viewCart =  driver.findElement(By.cssSelector("a[href='/view_cart'] u"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , viewCart);

        viewCart.click();
        return new CartPage(driver);


    }



}
