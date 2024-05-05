package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUp() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        // return new SignUpPage(driver);

    }

    public ContactUsPage clickContactUsButton() {
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickTestCases() {
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
        return new TestCasesPage(driver);
    }

    public ProductsPage clickProducts(){
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        return new ProductsPage(driver);
    }
    public boolean verifySubscriptionDisplay(){
        return driver.findElement(By.xpath("//div[@class='single-widget']//h2")).isDisplayed();
    }
    public void setSubscriptionEmail(String subEmail){
        driver.findElement(By.id("susbscribe_email")).sendKeys(subEmail);
    }
    public void clickSubscriptionButton(){
        driver.findElement(By.id("subscribe")).click();
    }
    public Boolean verifySubscriptionAlert(){
        return driver.findElement(By.id("success-subscribe")).isDisplayed();
    }
    public CartPage clickCartPage(){
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        return new CartPage(driver);

    }
    //verify category products
    public boolean verifyCategoryProducts(){
        return driver.findElement(By.id("accordian")).isDisplayed();
    }
    //Click women category
    public void clickWomenCategory(){
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
    }
    //click dress women category
    public ProductsPage clickDressWomenCategory(){
        WebElement dressCategory= driver.findElement(By.xpath("//a[@href='/category_products/1']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(dressCategory));
        dressCategory.click();
        return new  ProductsPage(driver);
    }



    //Click View Product link
    public ProductDetailPage clickViewProduct(){
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        return new ProductDetailPage(driver);
    }

}