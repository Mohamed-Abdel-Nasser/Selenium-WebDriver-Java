package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    By accountInformationTitle = By.xpath("//b[contains(text(), 'Enter Account Information')]");



    public SignUpPage(WebDriver driver){
        this.driver = driver;

    }

    public boolean signUpDisplay(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        return driver.findElement(By.xpath("//h2[contains(text(), 'Login to your account')]")).isDisplayed();

    }
    public void setUserName(String name){
        driver.findElement(By.name("name")).sendKeys(name);


    }
    public void setEmail(String email){
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);

    }
    public void clickSignUpButton(){
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

    }

    public boolean accountInfoDisplay() {
        return driver.findElement(accountInformationTitle).isDisplayed();
    }
    public void setPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }
    public void selectDay(String day){
        Select setDay = new Select(driver.findElement(By.id("days")));
        setDay.selectByValue(day);
    }
    public void selectMonth(String month){
        Select setMonth = new Select(driver.findElement(By.id("months")));
        setMonth.selectByValue(month);
    }
    public void selectYear(String year){
        Select setYear = new Select(driver.findElement(By.id("years")));
        setYear.selectByValue(year);
    }
    public void checkNewsLetter(){
        driver.findElement(By.id("newsletter")).click();
    }
    public void setFirstName(String firstName){
        driver.findElement(By.id("first_name")).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        driver.findElement(By.id("last_name")).sendKeys(lastName);
    }
    public void setAdress(String adress){
        driver.findElement(By.id("address1")).sendKeys(adress);
    }
    public void setState(String state){
        driver.findElement(By.id("state")).sendKeys(state);
    }
    public void setcity(String city){
        driver.findElement(By.id("city")).sendKeys(city);
    }
    public void setzipcode(String zipcode){
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
    }
   public void setCountry(String countery){

        Select countrySelector = new Select(driver.findElement(By.id("country")));
        countrySelector.selectByValue(countery);

   }
   public void setCompany (String company){
        driver.findElement(By.id("company")).sendKeys(company);
   }
    public void setMobileNumber(String mobile_number){
        driver.findElement(By.id("mobile_number")).sendKeys(mobile_number);
    }
    public void clickCreateAccountBtn(){
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

    }
    public boolean accountCreatedDisplay() {
        return driver.findElement((By.xpath("//h2[@data-qa='account-created']"))).isDisplayed();
    }
    public void clickContinue(){
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    }
    public boolean loggedAsUserDisplay() {
        return    driver.findElement(By.xpath("//a[@href='/delete_account']")).isDisplayed();


    }
    public void clickDeleteAccount(){
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

    }
    public boolean accountDeletedDisplay() {
        return driver.findElement((By.xpath("//h2[@data-qa='account-deleted']"))).isDisplayed();
    }


    public boolean emailExistErrorDisplay(){
        return driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).isDisplayed();
    }



}
