package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    WebDriver driver;
    public TestCasesPage(WebDriver driver){
        this.driver =driver;
    }
    public boolean testCasesDisplay(){
       return driver.findElement(By.xpath("//b[contains(text(),'Test Cases')]")).isDisplayed();

    }
}
