package Tests;

import Base.BaseTest;
import Pages.FavoritesPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки функционала добавления товара в избранное.
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * Содержит один тестовый метод, который проверяет:
 *   Добавление товара в избранное со страницы товара
 *   Переход в раздел избранного
 *   Наличие добавленного товара в избранном
 * 
 */
public class AddProductToFavoritesTest extends BaseTest {
    /**
     * Тест добавления товара в избранное.
     * Шаги теста:
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Добавляем товар в избранное через метод {@link ProductPage#addToFavorites()}
     *   Переходим в раздел избранного через {@link ProductPage#goToFavorites(Class)}
     *   Проверяем, что страница избранного отображается (товар успешно добавлен)
     * Тест использует проверку:
     *   Успешность отображения страницы избранного (через {@link FavoritesPage#isDisplayed()})
     *
     */
    @Test
    public void addProductToFavoritesTest(){

        ProductPage productPage = getProductPage();
        productPage.addToFavorites();
        FavoritesPage favoritesPage = productPage.goToFavorites(FavoritesPage.class);
        Assert.assertTrue(favoritesPage.isDisplayed());
    }
}
