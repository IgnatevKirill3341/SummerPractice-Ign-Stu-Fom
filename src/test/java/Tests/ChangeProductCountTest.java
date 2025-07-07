package Tests;

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
     *   Получаем страницу товара через {@link BaseTest#getProductPage(boolean)}
     *   Добавляем товар в корзину через {@link ProductPage#addToCart()}
     *   Переходим в корзину через {@link ProductPage#goToCart()}
     *   Создаем экземпляр страницы корзины через {@link ProductPage#openNewPage(Class)}
     *   Увеличиваем количество товара через {@link CartPage#increaseProductCount()}
     *   Проверяем соответствие фактического количества ожидаемому значению
     * 
     */
    @Test
    public void changeProductCountTest(){
        ProductPage productPage = getProductPage(false);
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);
        cartPage.increaseProductCount();
        String productCount = cartPage.getProductCount();
        Assert.assertEquals(expectedProductCountAfterEncrease, productCount);
    }
    /**
     * Тест проверки уменьшения количества товара в корзине.
     * Шаги теста:
     *   Получаем страницу товара через {@link BaseTest#getProductPage(boolean)
     *   Добавляем товар в корзину через {@link ProductPage#addToCart()}
     *   Переходим в корзину через {@link ProductPage#goToCart()}
     *   Создаем экземпляр страницы корзины через {@link ProductPage#openNewPage(Class)}
     *   Увеличиваем количество товара {@link CartPage#increaseProductCount()}
     *   Уменьшаем Количество товара {@link  CartPage#deleteProduct()}
     *   Проверяем количество товара (должно быть 1)
     * 
     */
    @Test
    public void decreaseProductCountTest(){
        ProductPage productPage = getProductPage(false);
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);
        cartPage.increaseProductCount();
        cartPage.decreaseProductCount();
        String productCount = cartPage.getProductCount();
        Assert.assertEquals(expectedProductCountAfterDecrease, productCount);
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
        ProductPage productPage = getProductPage(false);
        productPage.addToCart();
        productPage.goToCart();
        CartPage cartPage = productPage.openNewPage(CartPage.class);
        Assert.assertFalse(cartPage.isProductInCart());
    }
}
