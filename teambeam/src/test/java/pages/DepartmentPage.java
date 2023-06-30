package pages;

import elements.DepartmentElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepartmentPage extends DepartmentElements {

    public DepartmentPage(WebDriver driver) {
        super(driver);
    }

    public DepartmentPage moveDepartmetn() {
        moveCursor(waitUntilElementToBeVisibleByXpath(DEPARTMENT_BUTTON), driver);
        return this;
    }

    public DepartmentPage clickFindDepartmentButton() {
        waitUntilElementToBeClickableByXpath(FIND_DEPARTMENT_BUTTON).click();
        return this;
    }

    public DepartmentPage closeCookie() {
        waitUntilElementToBeClickableByXpath(CLOSE_COOKIE).click();
        return this;
    }
    public DepartmentPage clickDeliveryButton() {
        waitUntilElementToBeClickableByXpath(DELIVERY_BUTTON).click();
        return this;
    }
    public WebElement getDateTimeField() {
       return waitUntilElementToBeVisibleByXpath(GET_TIME);
    }

}
