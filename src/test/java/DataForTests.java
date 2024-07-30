import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DataForTests {
    // Данные для тестов
    public static final String WB = "https://www.wildberries.ru/";
    public static final String SEARCH_VALUE = "Iphone 13";
    public static final String TEXT_AFTER_SEARCH = "По запросу Iphone 13 найдено";
    public static final String SORTING_SEARCH = "По популярности";
    public static final String CITY_VALUE = "Санкт-Петербург";
    public static final String PAGE_AFTER_SEARCH = "https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki";
    public static final String PAGE_WITH_FILTERS = "https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki?sort=popular&page=1&fdlvr=72&fbrand=6049&priceU=10000000%3B14900000&f4474=8071618";
    public static final String FILTER_DELIVERY = "до 3 дней";
    public static final String FILTER_MANUFACTURER = "Apple";
    public static final String FILTER_PRICE = "от 100 000 до 149 000";
    public static final String FILTER_DIAGONAL = "13.3\"";
    public static final String START_PRICE = "100000";
    public static final String END_PRICE = "149000";

    // Xpath для тестов
    public static final String XPATH_FOR_FIRST_PRODUCT_ON_MAIN_PAGE = "//div[@class='main-page__content']/descendant::article[1]/div/a";
    public static final String XPATH_FOR_CLEAR_SEARCH_INPUT = "//button[@aria-label = 'Очистить поиск']";
    public static final String XPATH_FOR_INPUT_ADRESS = "//input [@autocomplete = 'off'][@placeholder = 'Введите адрес']";
    public static final String XPATH_FOR_GET_FIRST_ADRESS = "//div[@id='pooList']/div[1]//span[@class = 'address-item__name-text']";
    public static final String XPATH_FOR_FIRST_ADRESS = "//div[@id='pooList']/div[1]";
    public static final String XPATH_FOR_CARD_OF_ADRESS = "//div[@class = 'geo-block__info-wrap']";
    public static final String XPATH_FOR_APPLY_ADRESS = "//button[text() = 'Выбрать']";
    public static final String XPATH_FOR_OPEN_CATALOG = "//button[@aria-label = 'Навигация по сайту']";
    public static final String XPATH_FOR_ELECTRONIC = "//span[text() = 'Электроника']";
    public static final String XPATH_FOR_COMPUTERS_AND_LAPTOPS = "//span[text() = 'Ноутбуки и компьютеры']";
    public static final String XPATH_FOR_LAPTOPS = "//a[text() = 'Ноутбуки']";
    public static final String XPATH_FOR_ALL_FILTERS = "//button[text() = 'Все фильтры']";
    public static final String XPATH_FOR_START_PRICE_FILTER = "//input[@name = 'startN']";
    public static final String XPATH_FOR_END_PRICE_FILTER = "//input[@name = 'endN']";
    public static final String XPATH_FOR_MANUFACTURER_FILTER = "//span[@class = 'checkbox-with-text__text'][text() = 'Apple']";
    public static final String XPATH_FOR_DIAGONAL_FILTER = "//span[@class = 'checkbox-with-text__text'][text() = '13.3\"']";
    public static final String XPATH_FOR_DELIVERY_THREE_DAYS_FILTER = "//span[text() = 'до 3 дней']";
    public static final String XPATH_FOR_COUNT_PRODUCT_AFTER_FILTERS = "//p[@class = 'filters-desktop__count-goods']";
    public static final String XPATH_FOR_APPLY_FILTERS = "//button[text() = 'Показать']";


    //Xpath для ассертов
    public static final String XPATH_FOR_TEXT_AFTER_SEARCH = "//h1";
    public static final String XPATH_FOR_FIRST_FILTER = "//*[@class = 'dropdown-filter__btn'][1]";
    public static final String XPATH_FOR_SORTING = "//div[@class='dropdown-filter'][1]/button";
    public static final String XPATH_FOR_MANUFACTURER = "//div[@class='product-card-list']/descendant::article[1]//span[@class = 'product-card__brand']";
    public static final String ID_SEARCH_INPUT = "searchInput";
    public static final String XPATH_FOR_ADRESS = "//span[@class = 'details-self__name-text']";
    public static final String XPATH_FOR_ADRESS_ON_MAIN_PAGE = "//li[@class = 'simple-menu__item j-geocity-wrap']";
    public static final String XPATH_FOR_COUNT_OF_PRODUCT_ON_PAGE = "//span[@class = 'goods-count']";
    public static final String XPATH_FOR_FIRST_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[1]";
    public static final String XPATH_FOR_SECOND_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[2]";
    public static final String XPATH_FOR_THIRD_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[3]";
    public static final String XPATH_FOR_FOURTH_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[4]";
    public static final String XPATH_FOR_RESET_FILTERS = "//button[@class = 'your-choice__btn']";

    //Методы для работы с данными
    public static String getExpetedCountOfProductAfterFilters(String expected) {
        expected = $(By.xpath(DataForTests.XPATH_FOR_COUNT_PRODUCT_AFTER_FILTERS)).getText();
        return expected.replace("Нашли ", "");
    }
}
