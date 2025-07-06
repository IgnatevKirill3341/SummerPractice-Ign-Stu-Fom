package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки функционала добавления товара в корзину.
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * 
 * Содержит один тестовый метод, который проверяет:
 * 
 *   Добавление товара в корзину со страницы товара
 *   Переход в корзину
 *   Наличие добавленного товара в корзине
 * 
 */
public class AddToCartTest extends BaseTest {
    /**
     * Тест добавления товара в корзину.
     * 
     * Шаги теста:
     * 
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Добавляем товар в корзину через метод {@link ProductPage#addToCart()}
     *   Переходим в корзину через {@link ProductPage#goToCart()}
     *   Создаем экземпляр страницы корзины через {@link ProductPage#openNewPage(Class)}
     *   Проверяем наличие товара в корзине через {@link CartPage#isProductInCart()}
     * 
     *
     * Тест использует проверку:
     * 
     *   Assert.assertTrue() для подтверждения наличия товара в корзине
     * 
     */
    @Test
    public void addToCartTest(){
        ProductPage productPage = getProductPage();
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);
        Assert.assertTrue(cartPage.isProductInCart());
    }
}
