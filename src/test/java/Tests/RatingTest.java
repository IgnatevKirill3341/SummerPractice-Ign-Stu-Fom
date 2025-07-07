package Tests;

import Pages.MainPage;
import Pages.ProductPage;
import Pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки функционала рейтинга товаров.
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * 
 * Содержит два тестовых метода, которые проверяют:
 * 
 *   Корректность отображения и значения рейтинга на странице товара
 *   Корректность работы фильтра по рейтингу на странице поиска
 * 
 * Также включает вспомогательный метод для проверки диапазона значений рейтинга.
 */
public class RatingTest extends BaseTest {
    /**
     * Поисковый запрос для тестирования фильтрации по рейтингу.
     */
    private final static String searchStr = "бейсболка";
    /**
     * Тест проверки рейтинга на странице товара.
     * 
     * Шаги теста:
     * 
     *   Получаем страницу товара через {@link BaseTest#getProductPage(boolean)}
     *   Проверяем отображение рейтинга через {@link ProductPage#isRatingDisplayed()}
     *   Проверяем, что значение рейтинга находится в допустимом диапазоне [0.0, 5.0]
     * 
     *
     * Тест использует проверки:
     * 
     *   Assert.assertTrue() для видимости рейтинга
     *   Assert.assertTrue() с вызовом ratingInRange() для проверки значения
     * 
     */
    @Test
    public void productRatingTest(){
        ProductPage productPage = getProductPage(false);
        Assert.assertTrue(productPage.isRatingDisplayed());
        Assert.assertTrue(ratingInRange(productPage.getRating()));
    }
    /**
     * Тест проверки фильтрации по рейтингу на странице поиска.
     * Шаги теста:
     *   Выполняем поиск товаров через {@link BaseTest#search(String)}
     *   Открываем страницу результатов поиска
     *   Открываем выпадающее меню сортировки
     *   Выбираем фильтр по рейтингу (предположительно)
     *   Получаем рейтинги первых N товаров
     *   Проверяем, что все рейтинги находятся в допустимом диапазоне
     * Тест использует проверку:
     *   Assert.assertTrue() для каждого рейтинга в цикле
     */
    @Test
    public void filterRatingTest(){
        MainPage mainPage = search(searchStr, false);
        SearchPage searchPage = mainPage.openNewPage(SearchPage.class);
        searchPage.openDropdown();
        searchPage.chooseFilter();
        float[] ratings = searchPage.getRatings();
        for (float rating : ratings) {
            Assert.assertTrue(ratingInRange(rating));
        }
    }
    /**
     * Вспомогательный метод для проверки, что рейтинг находится в допустимом диапазоне.
     *
     * @param rating Проверяемое значение рейтинга
     * @return {@code true} если рейтинг в диапазоне [0.0, 5.0], {@code false} в противном случае
     */
    private boolean ratingInRange(float rating){
        return rating >= 0.0f && rating <= 5.0f;
    }
}
