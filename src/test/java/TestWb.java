import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestWb {
    private static final String EXPECTED = "1 товар";


    @BeforeAll
    static void setUp() {
        open("https://www.wildberries.ru/");
    }


    @Test
    void test() throws InterruptedException {
        $(By.xpath("//div[@class='main-page__content']/descendant::article[1]/div/a")).shouldBe(enabled);
        $(By.id("searchInput")).setValue("мобильный телефон");
        Thread.sleep(1000);
        $(By.id("applySearchBtn")).click();

        $(By.xpath("//div[@class = 'product-card-list']/article[1]")).click();
        $(By.xpath("//div[@class = 'product-page__order-buttons']//button[@class = 'order__button btn-main']")).click();
        $(By.xpath("//span[@class = 'navbar-pc__icon navbar-pc__icon--basket']")).click();

        $(By.xpath("//div[@class = 'accordion__goods-count']")).shouldHave(text(EXPECTED));
    }
}
