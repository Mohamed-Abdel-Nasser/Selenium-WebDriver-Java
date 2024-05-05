package startUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class Base {
    WebDriver driver;
    protected HomePage homePage;
    protected SignUpPage signUpPage;
    protected LoginPage loginPage;
    public static Properties props = new Properties();

    @BeforeMethod

    public void launchBrowser() throws IOException {
        File file= new File("src/main/java/properties/config.properties");
        FileInputStream fis = new FileInputStream(file);
        props.load(fis);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");

        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);


    }
    @Test
    public void launchBrowserTest(){
        assertEquals(driver.getTitle(), "Automation Exercise", "browser couldn't launch");


    }


}
