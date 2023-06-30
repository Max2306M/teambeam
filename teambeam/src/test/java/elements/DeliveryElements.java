package elements;

import base.AbstractBasePage;
import org.openqa.selenium.WebDriver;

public class DeliveryElements extends AbstractBasePage {
    public DeliveryElements(WebDriver driver) {
        super(driver);
    }
    protected final static String DEPARTMENT_BUTTON = "//a[@href='/office']";
    protected final static String FIND_DEPARTMENT_BUTTON = "//a[contains(text(),'Пошук відділення за номером ')]";
    protected final static String DELIVERY_BUTTON = "//a[@href='/onlineorder/estimatedate']";
    protected final static String GET_TIME = "//input[@id='pickdatetime_today']";
    protected final static String FIELD_TIME = "//input[@class='autocomplete city error']";

}
