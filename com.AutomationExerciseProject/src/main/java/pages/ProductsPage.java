package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.SeleniumCdpConnection;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyProductsDisplay() {
        return driver.findElement(By.id("sale_image")).isDisplayed();
    }

    public ProductDetailPage clickFirstProduct() {
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        return new  ProductDetailPage(driver);
    }




    public void fillSearchProduct(String productName) {
        driver.findElement(By.id("search_product")).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(By.id("submit_search")).click();
    }

    public boolean verifySearchedProductsDisplay() {
        return driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).isDisplayed();
    }

    public List<String> getSearchedProductsName() {
        List<WebElement> searchProductName = driver.findElements(By.xpath("//div[contains(@class,'productinfo text-center')]//p"));
        return searchProductName.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickContinueShopping() {
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

    }

    public void clickViewCart() {
        driver.findElement(By.linkText("View Cart")).click();


    }
    //Get title of products
    public String getProductsTitle(){
       WebElement productsTitle =driver.findElement(By.cssSelector(".title.text-center"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(productsTitle));
        return productsTitle.getText();
    }
    //Click Men category
    public void clickMenCategory(){
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
    }
    //click dress women category
    public void clickJeansMenCategory(){
        WebElement jeansMenCategory= driver.findElement(By.xpath("//a[@href='/category_products/6']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(jeansMenCategory));
        jeansMenCategory.click();

    }
    //Verify Brand Products
    public boolean verifyBrandProducts(){
        return driver.findElement(By.className("brands_products")).isDisplayed();
    }
    //Click Polo Brand
    public void clickPoloBrand(){
        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
    }



    //Add first and second products to cart
    public CartPage addProductsToCart()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        WebElement addToCartButton1 = driver.findElement((By.xpath("(//a[@data-product-id='1'])")));
        WebElement addToCartButton2 = driver.findElement(By.xpath("//a[@data-product-id='2']"));

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
              , addToCartButton1);

        addToCartButton1.click();
        clickContinueShopping();
      addToCartButton2.click();
       clickViewCart();
       return new CartPage(driver);
    }



}