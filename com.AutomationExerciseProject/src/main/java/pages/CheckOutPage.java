package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public List<String> grtDeliveryAddress (){
        List<WebElement> deliveryAddress= driver.findElements(By.xpath("//ul[@id='address_delivery']//li"));
        return deliveryAddress.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }
    public List<String> getBillingAddress(){
        List<WebElement> billingAddress= driver.findElements(By.xpath("//ul[@id='address_invoice']//li"));
        return billingAddress.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }
}
