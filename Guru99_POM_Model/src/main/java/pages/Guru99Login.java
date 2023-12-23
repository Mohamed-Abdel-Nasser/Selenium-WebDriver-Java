package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Login {
    WebDriver driver;

    //Create Attributes
    By user99GuruName = By.name("uid");
    By password99Guru = By.name("password");
    By titleText =By.className("barone");
    By login = By.name("btnLogin");

    //Create Constructor

    public Guru99Login(WebDriver driver){
        this.driver = driver;
    }

    /*
    Create 5 Methods
        1}-setUserName      To Set userName in textbox
        2}-setPassword      To Set password in password textbox
        3}-clickLogin       To Click on login button
        4}-getLoginTitle    To Get the title of Login Page
        5}-loginToGuru99

     */

    // 1}-setUserName      To Set userName in textbox
    public void setUserName(String strUserName){
        driver.findElement(user99GuruName).sendKeys(strUserName);
    }

    //2}-setPassword      To Set password in password textbox
    public void setPassword(String strPassword){
        driver.findElement(password99Guru).sendKeys(strPassword);
    }


    //3}-clickLogin       To Click on login button
    public void clickLogin(){
        driver.findElement(login).click();
    }

    //4}-getLoginTitle    To Get the title of Login Page
    public String getLoginTitle(){
        return    driver.findElement(titleText).getText();
    }


    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */
    //5}-loginToGuru99
    public void loginToGuru99(String strUserName,String strPasword){
        //Fill userName
        this.setUserName(strUserName);

        //Fill password
        this.setPassword(strPasword);

        //Click Login button
        this.clickLogin();
    }
}

