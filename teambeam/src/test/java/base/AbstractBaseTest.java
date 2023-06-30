package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.ArrayList;

abstract public class AbstractBaseTest {

    protected WebDriver driver;

    @BeforeMethod

    public void openNovaPostHomePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://novaposhta.ua/");

        HomePage homePage = new HomePage(driver);
        homePage.closeCookie();

    }


    @AfterMethod
    public void closeWindow() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public boolean urlContains(String urlPath) {
        return driver.getCurrentUrl().contains(urlPath);
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(tabNumber - 1));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}
