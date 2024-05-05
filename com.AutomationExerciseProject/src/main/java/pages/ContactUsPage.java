package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }



    public boolean verifyGetInTouchDisplay() {
        return driver.findElement(By.xpath("//h2[contains(text(),'Get In Touch')]")).isDisplayed();
    }

    public void setContactName(String name) {
        driver.findElement(By.name("name")).sendKeys(name);
    }

    public void setContactEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void setContactSubject(String subject) {
        driver.findElement(By.name("subject")).sendKeys(subject);
    }

    public void setContactMessage(String message) {
        driver.findElement(By.name("message")).sendKeys(message);
    }

    public void clickChooseFile(String file) {
        driver.findElement(By.name("upload_file")).sendKeys(file);

    }

    public void clickSubmit() {
        driver.findElement(By.name("submit")).click();
    }
    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public boolean submitSuccessDisplay(){
        return driver.findElement(By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]")).isDisplayed();

    }
    public void clickHomeButton(){
        driver.findElement(By.xpath("//a[@href='/']")).click();
    }
    public boolean homePageDisplay(){
        return driver.findElement(By.id("slider-carousel")).isDisplayed();
    }
}
