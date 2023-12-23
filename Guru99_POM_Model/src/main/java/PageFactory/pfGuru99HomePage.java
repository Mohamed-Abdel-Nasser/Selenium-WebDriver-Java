package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageFactory class for Guru99 Home Page.
 */
public class pfGuru99HomePage {
    // Step 1: WebDriver instance
    WebDriver driver;

    // Step 2: Web element representing the home page username
    @FindBy(xpath="//table//tr[@class='heading3']")
    WebElement homePageUserName;

    /**
     * Constructor for pfGuru99HomePage class.
     *
     * @param driver The WebDriver instance to be used for page interactions.
     */
    public pfGuru99HomePage(WebDriver driver) {
        // Step 3: Assign the WebDriver instance
        this.driver = driver;

        // Step 4: Initialize PageFactory elements
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to get the username displayed on the home page.
     *
     * @return The text of the home page username.
     */
    public String getHomePageDashboardUserName() {
        // Step 5: Get the text of the home page username
        return homePageUserName.getText();
    }
}
