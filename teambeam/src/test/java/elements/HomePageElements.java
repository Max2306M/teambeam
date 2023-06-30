package elements;

import base.AbstractBasePage;
import org.openqa.selenium.WebDriver;

public class HomePageElements  extends AbstractBasePage {
    public HomePageElements(WebDriver driver) {
        super(driver);
    }

    protected final static String CLOSE_COOKIE = "//i[contains(text(),'закрыть')][1]";

}
