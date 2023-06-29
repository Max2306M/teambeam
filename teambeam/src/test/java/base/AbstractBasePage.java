package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

abstract public class AbstractBasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait;
    private int BASE_WAIT = 15000;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ofMillis(BASE_WAIT));
    }

    protected WebElement waitUntilElementToBeVisibleByXpath(String locator) {
        return wait.until(visibilityOfElementLocated(By.xpath(locator)));
    }
    protected List<WebElement> listWaitUntilElementsToBeVisibleByXpath(String locator) {
        return wait.until(visibilityOfAllElementsLocatedBy(By.xpath(locator)));
    }

    protected WebElement waitUntilElementToBeVisibleByCss(String locator) {
        return wait.until(visibilityOfElementLocated(cssSelector(locator)));
    }

    protected static WebElement waitUntilElementToBeClickableByXpath(String locator) {
        return wait.until(elementToBeClickable(By.xpath(locator)));
    }

    protected static WebElement waitUntilElementToBeClickableByCss(String locator) {
        return wait.until(elementToBeClickable(cssSelector(locator)));
    }

    protected WebElement waitUntilPresenceOfElementByXpath(String locator) {
        return wait.until(presenceOfElementLocated(By.xpath(locator)));
    }

    protected WebElement waitUntilPresenceOfElementByCss(String locator) {
        return wait.until(presenceOfElementLocated(cssSelector(locator)));
    }

    protected List<WebElement> waitUntilPresenceOfAllElementsByXpath(String locator) {
        return wait.until(presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    protected List<WebElement> waitUntilPresenceOfAllElementsByCss(String locator) {
        return wait.until(presenceOfAllElementsLocatedBy(cssSelector(locator)));
    }

    public void goToNextTab(int tabNumber) {
        waitUntilNumberOfTabToBe(tabNumber);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber - 1));
    }

    public void waitUntilNumberOfTabToBe(int tabNumber) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabNumber));
    }

    public static void scrollToElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void moveToNextPage() {
        ArrayList<String> switchToWindow = new ArrayList<>
                (driver.getWindowHandles());
        driver.switchTo().window(switchToWindow.get(1));
    }

    public static String dataTestId(String id) {
        final String cssSelector = String.format("[data-test-id='%s']", id);
        return cssSelector;
    }
    protected void moveCursor(WebElement element, WebDriver driver){
        Actions actions = new Actions(this.driver);
        actions.moveToElement(element).build().perform();
    }

    public static String dataAutomationId(String id) {
        final String cssSelector = String.format("[data-automation-id='%s']", id);
        return cssSelector;
    }
}
