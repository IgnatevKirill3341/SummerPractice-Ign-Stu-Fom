package Tests;

import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тестовый класс для валидации блока рекомендованных товаров на странице товара.
 * Наследуется от {@link BaseTest}, содержащего общие настройки и методы для инициализации браузера.
 *
 * Сценарии тестирования:
 *   Проверка видимости блока рекомендованных товаров после скролла
 *   Проверка видимости первой рекомендованной карточки товара
 *   Проверка корректного открытия страницы товара по клику на рекомендованную карточку
 */
public class RecommendationsTest extends BaseTest {
    /**
     * Проверяет, что блок рекомендованных товаров отображается на странице после скролла.
     */
    @Test
    public void recommendationsVisibleTest(){
        ProductPage productPage = getProductPage(false);
        productPage.scrollToRecommends();
        Assert.assertTrue(productPage.isRecommendedProductsVisible());
    }
    /**
     * Проверяет, что первая карточка в блоке рекомендованных товаров отображается на странице.
     */
    @Test
    public void cardVisibleTest(){
        ProductPage productPage = getProductPage(false);
        productPage.scrollToRecommends();
        Assert.assertTrue(productPage.isCardVisible());

    }
    /**
     * Проверяет, что при клике на первую рекомендованную карточку
     * открывается соответствующая страница товара и название совпадает с именем карточки.
     */
    @Test
    public void cardOpenTest(){
        ProductPage productPage = getProductPage(false);
        productPage.scrollToRecommends();
        String cardName = productPage.getCardName();
        ProductPage newProductPage = productPage.goToProduct(ProductPage.class);
        Assert.assertEquals(cardName, newProductPage.getProductName());
    }
}
