package Tests;

import Base.BaseTest;
import Pages.BuyPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки функционала оформления заказа в один клик ("Купить сейчас").
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * 
 * Содержит один тестовый метод, который проверяет:
 * 
 *   Переход на страницу оформления заказа со страницы товара
 *   Корректность загрузки страницы оформления заказа
 * 
 */
public class BuyNowTest extends BaseTest {
    /**
     * Тест оформления заказа в один клик.
     * 
     * Шаги теста:
     * 
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Инициируем оформление заказа через метод {@link ProductPage#buyNow(Class)}
     *   Получаем экземпляр страницы оформления заказа
     *   Проверяем отображение страницы оформления заказа через {@link BuyPage#isDisplayed()}
     * 
     *
     * Тест использует проверку:
     * 
     *   Assert.assertTrue() для подтверждения успешной загрузки страницы оформления заказа
     * 
     */
    @Test
    public void buyNowTest(){
        ProductPage productPage= getProductPage();
        BuyPage buyPage = productPage.buyNow(BuyPage.class);
        Assert.assertTrue(buyPage.isDisplayed());
    }
}
