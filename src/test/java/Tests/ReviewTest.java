package Tests;

import Pages.ProductPage;
import Pages.ReviewPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для валидации блока рекомендованных товаров на странице товара.
 * Наследуется от {@link BaseTest}, содержащего общие настройки и методы для инициализации браузера.
 * Сценарии тестирования:
 *   Проверка видимости блока рекомендованных товаров после скролла
 *   Проверка видимости первой рекомендованной карточки товара
 *   Проверка корректного открытия страницы товара по клику на рекомендованную карточку
 */
public class ReviewTest extends BaseTest {
    /**
     * Тестовый сценарий для проверки функции отправки отзыва о товаре.
     * Шаги:
     *   Открыть страницу товара
     *   Перейти в раздел отзывов
     *   Открыть меню обратной связи
     *   Открыть форму жалобы/отзыва
     *   Выбрать опцию в форме
     *   Отправить форму
     *   Проверить, что появилось уведомление о результате отправки
     */
    @Test
    public void reviewTest(){
        ProductPage productPage = getProductPage();
        ReviewPage reviewPage = productPage.openReviews(ReviewPage.class);
        reviewPage.feedBack();
        reviewPage.openForm();
        reviewPage.selectElement();
        reviewPage.send();
        Assert.assertTrue(reviewPage.isAppears());
    }
}
