import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestExpectation {
    private static final String VALUE = "22";
    private static final String TEXT = "Hello World!";

    @BeforeEach
    void setUp() {
        open("http://the-internet.herokuapp.com/");
    }

    @Test
    @Description("Ожидание определенного текста")
    void testExpForText() {
        $(By.xpath("//h1")).shouldHave(text("Welcome to the-internet"));
    }

    @Test
    @Description("Ожидание появления элемента")
    void testExpForVisible() {
        $(By.xpath("//a[text() = 'Add/Remove Elements']")).click();
        $(By.xpath("//button[text() = 'Add Element']")).click();

        $(By.xpath("//button[@class = 'added-manually']")).shouldBe(visible);
    }

    @Test
    @Description("Ожидание исчезновения элемента")
    void testExpForDisappear() {
        $(By.xpath("//a[text() = 'Add/Remove Elements']")).click();
        $(By.xpath("//button[text() = 'Add Element']")).click();
        $(By.xpath("//button[@class = 'added-manually']")).click();

        $(By.xpath("//button[@class = 'added-manually']")).should(disappear);
    }

    @Test
    @Description("Ожидание определенного значения")
    void testExpForValue() {
        $(By.xpath("//a[text() = 'Inputs']")).click();
        $(By.xpath("//input")).setValue(VALUE);

        $(By.xpath("//input")).shouldHave(value(VALUE));
    }

    @Test
    @Description("Ожидание атрибута")
    void testExpForAttribute() {
        $(By.xpath("//a[text() = 'Drag and Drop']")).click();

        $(By.id("column-a")).shouldHave(attribute("draggable", "true"));
    }

    @Test
    @Description("Таймауты")
    void testTimeout() {
        Configuration.timeout = 10000;
        $(By.xpath("//a[text() = 'Dynamic Loading']")).click();
        $(By.xpath("//a[2]")).click();
        $(By.xpath("//button")).click();

        $(By.id("finish")).shouldHave(text(TEXT));
    }

    @Test
    @Description("Sleep")
    void testSleep() {
        $(By.xpath("//a[text() = 'Dynamic Loading']")).click();
        $(By.linkText("Example 1: Element on page that is hidden")).click();
        $(By.xpath("//button")).click();
        Selenide.sleep(3000);

        $(By.id("finish")).shouldBe(visible);
    }

    @Test
    @Description("Ожидание исчезновения и появления элемента")
    void testDynamicRemove() {
        $(By.xpath("//a[text() = 'Dynamic Controls']")).click();
        $(By.xpath("//button[text() = 'Remove']")).click();

        $(By.id("checkbox")).should(disappear);

        $(By.xpath("//button[text() = 'Add']")).click();

        $(By.id("checkbox")).shouldBe(visible);
    }

    @Test
    @Description("Ожидание получения и запрета доступа")
    void testDynamicEnable() {
        $(By.xpath("//a[text() = 'Dynamic Controls']")).click();
        $(By.xpath("//button[text() = 'Enable']")).click();

        $(By.xpath("//input [@type = 'text']")).shouldBe(enabled);

        $(By.xpath("//button[text() = 'Disable']")).click();
        $(By.xpath("//input [@type = 'text']")).shouldBe(disabled);
    }

    @Test
    @Description("Ожидание атрибута")
    void testAlert() {
        $(By.xpath("//a[text() = 'Entry Ad']")).click();

        $(By.id("modal")).shouldHave(attribute("style", "display: block;"));
    }
}
