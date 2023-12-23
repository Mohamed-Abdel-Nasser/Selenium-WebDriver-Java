package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageFactory class for Guru99 Login Page.
 */
public class pfGuru99Login {
    /**
     * All WebElements are identified by @FindBy annotation
     */

    // Step 1: WebDriver instance
    WebDriver driver;

    // Step 2: Web elements representing different components of the login page
    @FindBy(name="uid")
    WebElement user99GuruName;

    @FindBy(name="password")
    WebElement password99Guru;

    @FindBy(className="barone")
    WebElement titleText;

    @FindBy(name="btnLogin")
    WebElement login;

    /**
     * Constructor for pfGuru99Login class.
     *
     * @param driver The WebDriver instance to be used for page interactions.
     */
    public pfGuru99Login(WebDriver driver) {
        // Step 3: Assign the WebDriver instance
        this.driver = driver;

        // Step 4: Initialize PageFactory elements
        PageFactory.initElements(driver, this);
    }

    /*
        Create 5 Methods
        1}-setUserName      To Set userName in the textbox
        2}-setPassword      To Set password in the password textbox
        3}-clickLogin       To Click on the login button
        4}-getLoginTitle    To Get the title of the Login Page
        5}-loginToGuru99    To perform the complete login process
    */

    // 1}-setUserName      To Set userName in the textbox
    public void setUserName(String strUserName){
        user99GuruName.sendKeys(strUserName);
    }

    // 2}-setPassword      To Set password in the password textbox
    public void setPassword(String strPassword){
        password99Guru.sendKeys(strPassword);
    }

    // 3}-clickLogin       To Click on the login button
    public void clickLogin(){
        login.click();
    }

    // 4}-getLoginTitle    To Get the title of the Login Page
    public String getLoginTitle(){
        return titleText.getText();
    }

    /**
     * This POM method will be exposed in the test case to login in the application.
     *
     * @param strUserName The username to be used for login.
     * @param strPasword The password to be used for login.
     */
    // 5}-loginToGuru99
    public void loginToGuru99(String strUserName, String strPasword){
        // Fill user name
        this.setUserName(strUserName);

        // Fill password
        this.setPassword(strPasword);

        // Click Login button
        this.clickLogin();
    }
}
