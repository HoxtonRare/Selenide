package asserts;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.AlertNotFoundError;

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
}
