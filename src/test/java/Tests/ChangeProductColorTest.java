package Tests;

import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки функционала смены цвета товара на странице товара.
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * Содержит один тестовый метод, который проверяет:
 *   Смену цвета товара на странице товара</li>
 *   Корректность обновления названия товара после смены цвета</li>
 * 
 */
public class ChangeProductColorTest extends BaseTest {
    /**
     * Ожидаемое название товара после смены цвета.
     * Используется для сравнения с фактическим названием после изменения цвета.
     */
    private final String anotherColorProductName = "Бейсболка Nike женские мужские Кепка с вышивкой";
    /**
     * Тест смены цвета товара.
     * Шаги теста:
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}</li>
     *   Изменяем цвет товара через метод {@link ProductPage#changeColor(Class)}</li>
     *   Получаем обновленную страницу товара с новым цветом</li>
     *   Сравниваем фактическое название товара с ожидаемым значением</li>
     * 
     *
     * Тест использует проверку:
     *   Assert.assertEquals() для сравнения ожидаемого и фактического названия товара</li>
     * 
     *
     * Примечание: тест предполагает, что смена цвета товара приводит к изменению его названия.
     */
    @Test
    public void changeProductColorTest(){
        ProductPage productPage = getProductPage();
        ProductPage anotherColorProduct = productPage.changeColor(ProductPage.class);
        Assert.assertEquals(anotherColorProductName, anotherColorProduct.getProductName());
    }
}
