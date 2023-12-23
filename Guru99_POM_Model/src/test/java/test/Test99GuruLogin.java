package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Guru99HomePage;
import pages.Guru99Login;


public class Test99GuruLogin {

    //String driverPath = "C:\\geckodriver.exe";
    WebDriver driver;
    Guru99Login objLogin_2;
    Guru99HomePage objHomePage;

    @BeforeTest
    public void setup(){
        //System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");

    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){

//Create Login Page object
        objLogin_2 = new Guru99Login(driver);

//Verify login page title
        String loginPageTitle = objLogin_2.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

//login to application
        objLogin_2.loginToGuru99("mgr123", "mgr!23");

// go the next page
        objHomePage = new Guru99HomePage(driver);

//Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }

}

