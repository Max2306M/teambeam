package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static base.AbstractBasePage.wait;
import static org.openqa.selenium.By.cssSelector;

public class CommonActions {

    public static void scrollToElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void jsClick(WebElement element, WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void back(WebDriver driver) {
        driver.navigate().back();
    }

    public static void moveCursor(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static List<WebElement> getProductListByCssLocator(String locator, WebDriver driver) {
        int prevSize = 0;
        int newSize = 0;

        List<WebElement> elements;
        do {
            prevSize = newSize;

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -400)");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            elements = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(cssSelector(locator)));
            newSize = elements.size();

        } while (prevSize < newSize);

        return elements;
    }

    public static List<WebElement> getProductListByXPath(String locator, WebDriver driver) {
        int prevSize = 0;
        int newSize = 0;

        List<WebElement> elements;
        do {
            prevSize = newSize;

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -400)");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            elements = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By.xpath(locator)));
            newSize = elements.size();

        } while (prevSize < newSize);

        return elements;
    }

    public static void scrollByPixel(WebDriver driver, String px) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + px + ")");
    }
}
