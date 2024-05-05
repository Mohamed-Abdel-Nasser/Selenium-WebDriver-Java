package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public boolean loginDisplay(){
        return driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]")).isDisplayed();

    }
    public void loginEmail(String loginEmail){
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(loginEmail);

    }
    public void loginPassword(String loginPassword){
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(loginPassword);

    }
    public void clickLoginButton(){
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    }
    public boolean loggedAsUserDisplay() {
        return    driver.findElement(By.xpath("//a[@href='/delete_account']")).isDisplayed();

        // return driver.findElement((By.className("fa-user"))).isDisplayed();
    }
    public void clickDeleteAccount(){
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

    }
    public boolean accountDeletedDisplay() {
        return driver.findElement((By.xpath("//h2[@data-qa='account-deleted']"))).isDisplayed();
    }
    public void clickContinue() {
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
    public boolean errorMessageDisplay(){
        return driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed();

    }
    public void clickLogoutButton(){
        driver.findElement(By.linkText("Logout")).click();
    }

}
