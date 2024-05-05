package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    // verify payment page open successfully
    public String verifyPaymentPage(){
       return driver.findElement(By.className("heading")).getText();
    }
    //set card data
    public void setNameOnCard(String nameOnCard){
        driver.findElement(By.name("name_on_card")).sendKeys(nameOnCard);
    }

    public void setCardNumber(String cardNumber){
        driver.findElement(By.name("card_number")).sendKeys(cardNumber);
    }
    public void setCvc(String cvc){
        driver.findElement(By.name("cvc")).sendKeys(cvc);
    }
    public void setExpiryMonth(String expiryMonth){
        driver.findElement(By.name("expiry_month")).sendKeys(expiryMonth);
    }
    public void setExpiryYear(String expiryYear){
        driver.findElement(By.name("expiry_year")).sendKeys(expiryYear);
    }
    //click pay and confirm order
    public void clickPayAndConfirm(){
        driver.findElement(By.id("submit")).click();
    }
    //verify success payment alert
   public boolean verifySuccessAlert(){
        WebElement successAlert = driver.findElement(By.cssSelector("div[class='col-sm-9 col-sm-offset-1'] p"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
               , successAlert);
      return successAlert.isDisplayed();

   }

}
