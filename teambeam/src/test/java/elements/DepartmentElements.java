package elements;

import base.AbstractBasePage;
import org.openqa.selenium.WebDriver;

public class DepartmentElements extends AbstractBasePage {
    public DepartmentElements(WebDriver driver) {
        super(driver);
    }
    protected final static String CLOSE_COOKIE = "//i[contains(text(),'закрыть')][1]";
    protected final static String DEPARTMENT_BUTTON = "//a[@href='/office']";
    protected final static String FIND_DEPARTMENT_BUTTON = "//a[contains(text(),'Пошук відділення за номером ')]";
    protected final static String DELIVERY_BUTTON = "//a[@href='/onlineorder/estimatedate']";
    protected final static String GET_TIME = "//input[@id='pickdatetime_today']";

}
