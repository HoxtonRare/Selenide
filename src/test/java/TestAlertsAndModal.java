import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static asserts.Asserts.*;

public class TestAlertsAndModal {
    private static final String DEFAULT_URL = "https://the-internet.herokuapp.com/windows";
    private static final String NEW_URL = "https://the-internet.herokuapp.com/windows/new";

    @Test
    void testModal() {
        open(DEFAULT_URL);
        $(By.linkText("Click Here")).click();
        Selenide.switchTo().window(1);

        webdriver().shouldHave(url(NEW_URL));
        $(By.className("example")).shouldHave(text("New Page"));

        Selenide.closeWindow();
        switchTo().window(0);

        webdriver().shouldHave(url(DEFAULT_URL));
    }

    @Test
    void testAlerts() {
        String expected = "I am a JS Alert";
        String textToAlert = "Hello World";
        String expectedTextAfterAlert = "You entered: Hello World";

        open("https://the-internet.herokuapp.com/javascript_alerts");
        $(By.xpath("//button[@onclick = 'jsAlert()']")).click();
        String actual = Selenide.confirm();

        checkTextOfAlert(expected, actual);
        checkOfNullableAlert();

        $(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
        Selenide.dismiss();

        checkOfNullableAlert();

        $(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        Selenide.prompt(textToAlert);

        $(By.id("result")).shouldHave(text(expectedTextAfterAlert));
    }
}
