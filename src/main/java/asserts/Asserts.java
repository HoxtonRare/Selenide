package asserts;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.AlertNotFoundError;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Asserts {

    public static void checkTextOfAlert(String text, String actual) {
        assertEquals(text, actual);
    }

    public static void checkOfNullableAlert() {
        Configuration.timeout = 100;
        assertThrows(AlertNotFoundError.class, () -> Selenide.switchTo().alert());
    }

    public static void checkForPage(String url) {
        webdriver().shouldHave(url(url));
    }

    public static void checkTextByXpath(String xpath, String expected) {
        $(By.xpath(xpath)).shouldHave(text(expected));
    }

    public static void checkEmptyInputById(String id) {
        $(By.id(id)).shouldBe(empty);
    }

    public static void checkForVisibleByXpath(String xpath) {
        $(By.xpath(xpath)).shouldBe(visible);
    }
}
