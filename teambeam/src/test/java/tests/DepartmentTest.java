package tests;

import base.AbstractBaseTest;
import org.testng.annotations.Test;
import pages.DepartmentPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DepartmentTest extends AbstractBaseTest {
    @Test
    public void departmentTest() {
        DepartmentPage departmentPage = new DepartmentPage(driver);

        departmentPage
                .closeCookie()
                .clickDeliveryButton();

        assertEquals(driver.getCurrentUrl(), "https://novaposhta.ua/onlineorder/estimatedate");


        String dateTimeText = departmentPage.getDateTimeField().getAttribute("value");
        LocalDateTime currentDateTime = LocalDateTime.now();
        String timeNow = String.valueOf(LocalDateTime.now());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        LocalDateTime dateTimeFromField = LocalDateTime.parse(dateTimeText, formatter);
        System.out.println(dateTimeFromField);


        System.out.println(LocalDateTime.now());
        assertTrue(timeNow.contains(dateTimeFromField.toString()));
    }
}
