package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки функционала изменения количества товара в корзине.
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * Содержит три тестовых метода, которые проверяют:
 *   Увеличение количества товара в корзине
 *   Проверку начального количества товара
 *   Удаление товара из корзины
 * 
 */
public class ChangeProductCountTest extends BaseTest {
    /**
     * Ожидаемое количество товара после увеличения.
     */
    private final static String expectedProductCountAfterEncrease = "2";
    /**
     * Ожидаемое начальное количество товара (после добавления в корзину).
     */
    private final static String expectedProductCountAfterDecrease = "1";
    /**
     * Тест увеличения количества товара в корзине.
     * Шаги теста:
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Добавляем товар в корзину через {@link ProductPage#addToCart()}
     *   Переходим в корзину через {@link ProductPage#goToCart()}
     *   Создаем экземпляр страницы корзины через {@link ProductPage#openNewPage(Class)}
     *   Увеличиваем количество товара через {@link CartPage#increaseProductCount()}
     *   Проверяем соответствие фактического количества ожидаемому значению
     * 
     */
    @Test
    public void changeProductCountTest(){
        ProductPage productPage = getProductPage();
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);

        cartPage.increaseProductCount();
        Assert.assertEquals(expectedProductCountAfterEncrease, cartPage.getProductCount());
    }
    /**
     * Тест проверки начального количества товара в корзине.
     * Шаги теста:
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Добавляем товар в корзину через {@link ProductPage#addToCart()}
     *   Переходим в корзину через {@link ProductPage#goToCart()}
     *   Создаем экземпляр страницы корзины через {@link ProductPage#openNewPage(Class)}
     *   Проверяем начальное количество товара (должно быть 1)
     * 
     */
    @Test
    public void decreaseProductCountTest(){
        ProductPage productPage = getProductPage();
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);
        Assert.assertEquals(expectedProductCountAfterDecrease, cartPage.getProductCount());
    }
    /**
     * Тест удаления товара из корзины.
     * Шаги теста:
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Добавляем товар в корзину через {@link ProductPage#addToCart()}
     *   Переходим в корзину через {@link ProductPage#goToCart()}
     *   Создаем экземпляр страницы корзины через {@link ProductPage#openNewPage(Class)}
     *   Удаляем товар через {@link CartPage#deleteProduct()}
     *   Проверяем отсутствие товара в корзине
     * 
     */
    @Test
    public void deleteProductTest(){
        ProductPage productPage = getProductPage();
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);
        cartPage.deleteProduct();
        Assert.assertFalse(cartPage.isProductInCart());
    }
}
