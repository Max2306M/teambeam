package pages;

import elements.DeliveryElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryPage extends DeliveryElements {

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    public DeliveryPage moveDepartmetn() {
        moveCursor(waitUntilElementToBeVisibleByXpath(DEPARTMENT_BUTTON), driver);
        return this;
    }

    public DeliveryPage clickFindDepartmentButton() {
        waitUntilElementToBeClickableByXpath(FIND_DEPARTMENT_BUTTON).click();
        return this;
    }


    public DeliveryPage clickDeliveryButton() {
        waitUntilElementToBeClickableByXpath(DELIVERY_BUTTON).click();
        return this;
    }

    public WebElement getDateTimeField() {
        return waitUntilElementToBeVisibleByXpath(GET_TIME);
    }

    public WebElement fieldTime() {
        return waitUntilElementToBeVisibleByXpath(FIELD_TIME);
    }

}
