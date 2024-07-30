import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static asserts.Asserts.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testWbUi {

    @BeforeEach
    void setUp() {
        Configuration.timeout = 7000;
        open(DataForTests.WB);
        $(By.xpath(DataForTests.XPATH_FOR_FIRST_PRODUCT_ON_MAIN_PAGE)).shouldBe(enabled);
    }


    @Test
    void testSearchInput() {
        $(By.id(DataForTests.ID_SEARCH_INPUT)).setValue(DataForTests.SEARCH_VALUE).pressEnter();

        checkTextByXpath(DataForTests.XPATH_FOR_TEXT_AFTER_SEARCH ,DataForTests.TEXT_AFTER_SEARCH);
        checkTextByXpath(DataForTests.XPATH_FOR_FIRST_FILTER ,DataForTests.SEARCH_VALUE);
        checkTextByXpath(DataForTests.XPATH_FOR_SORTING ,DataForTests.SORTING_SEARCH);
        checkTextByXpath(DataForTests.XPATH_FOR_MANUFACTURER ,DataForTests.FILTER_MANUFACTURER);

        $(By.xpath(DataForTests.XPATH_FOR_CLEAR_SEARCH_INPUT)).click();

        checkEmptyInputById(DataForTests.ID_SEARCH_INPUT);
    }

    @Test
    void testChangeCity() {
        $(By.xpath(DataForTests.XPATH_FOR_ADRESS_ON_MAIN_PAGE)).click();
        $(By.xpath(DataForTests.XPATH_FOR_INPUT_ADRESS)).shouldBe(visible)
                .setValue(DataForTests.CITY_VALUE).pressEnter();
        String firstAddress = $(By.xpath(DataForTests.XPATH_FOR_GET_FIRST_ADRESS)).getText();
        $(By.xpath(DataForTests.XPATH_FOR_FIRST_ADRESS)).click();
        $(By.xpath(DataForTests.XPATH_FOR_CARD_OF_ADRESS)).shouldBe(visible);

        checkTextByXpath(DataForTests.XPATH_FOR_ADRESS, firstAddress);

        $(By.xpath(DataForTests.XPATH_FOR_APPLY_ADRESS)).click();

        checkForPage(DataForTests.WB);
        checkTextByXpath(DataForTests.XPATH_FOR_ADRESS_ON_MAIN_PAGE, firstAddress);
    }

    @Test
    void testFilters() {
        $(By.xpath(DataForTests.XPATH_FOR_OPEN_CATALOG)).click();
        $(By.xpath(DataForTests.XPATH_FOR_ELECTRONIC)).shouldBe(clickable).hover();
        $(By.xpath(DataForTests.XPATH_FOR_COMPUTERS_AND_LAPTOPS)).shouldBe(clickable).click();
        $(By.xpath(DataForTests.XPATH_FOR_LAPTOPS)).shouldBe(clickable).click();

        checkForPage(DataForTests.PAGE_AFTER_SEARCH);

        $(By.xpath(DataForTests.XPATH_FOR_ALL_FILTERS)).click();
        $(By.xpath(DataForTests.XPATH_FOR_START_PRICE_FILTER)).setValue(DataForTests.START_PRICE);
        $(By.xpath(DataForTests.XPATH_FOR_END_PRICE_FILTER)).setValue(DataForTests.END_PRICE);
        $(By.xpath(DataForTests.XPATH_FOR_DELIVERY_THREE_DAYS_FILTER)).click();
        $(By.xpath(DataForTests.XPATH_FOR_MANUFACTURER_FILTER)).click();
        $(By.xpath(DataForTests.XPATH_FOR_DIAGONAL_FILTER)).click();

        Selenide.sleep(500);

        String expected = "";
        expected = DataForTests.getExpetedCountOfProductAfterFilters(expected);

        $(By.xpath(DataForTests.XPATH_FOR_APPLY_FILTERS)).click();

        checkForPage(DataForTests.PAGE_WITH_FILTERS);
        checkTextByXpath(DataForTests.XPATH_FOR_COUNT_OF_PRODUCT_ON_PAGE, expected);
        checkTextByXpath(DataForTests.XPATH_FOR_FIRST_FILTER_ON_PAGE,DataForTests.FILTER_DELIVERY);
        checkTextByXpath(DataForTests.XPATH_FOR_SECOND_FILTER_ON_PAGE,DataForTests.FILTER_MANUFACTURER);
        checkTextByXpath(DataForTests.XPATH_FOR_THIRD_FILTER_ON_PAGE,DataForTests.FILTER_PRICE);
        checkTextByXpath(DataForTests.XPATH_FOR_FOURTH_FILTER_ON_PAGE,DataForTests.FILTER_DIAGONAL);
        checkForVisibleByXpath(DataForTests.XPATH_FOR_RESET_FILTERS);
    }
}
