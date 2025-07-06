package Tests;

import Base.BaseTest;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.attribute;
/**
 * Тестовый класс для проверки корректности отображения основных атрибутов товара на странице товара.
 * Наследует базовую функциональность тестового окружения от {@link BaseTest}.
 * Содержит три независимых теста, которые проверяют:
 *   Название товара
 *   Цену товара
 *   Изображение товара
 * Для каждого атрибута проверяется как факт отображения, так и соответствие ожидаемому значению.
 */
public class FindNamePriceImgTest extends BaseTest {
    /**
     * Ожидаемое название товара.
     */
    private final static String name = "Бейсболка белая Nike женские мужские Кепка с вышивкой";
    /**
     * Ожидаемая цена товара (с указанием валюты).
     */
    private final static String price = "470 ₽";
    /**
     * Ожидаемые размеры изображения товара (ширина и высота в пикселях).
     */
    private final static String width = "900", height = "1200";
    /**
     * Тест проверки названия товара.
     * 
     * Шаги теста:
     * 
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Проверяем отображение названия товара через {@link ProductPage#isProductNameDisplayed()}
     *   Сравниваем фактическое название с ожидаемым значением
     * 
     *
     * Тест использует проверки:
     * 
     *   Assert.assertTrue() для подтверждения видимости названия
     *   Assert.assertEquals() для сравнения текста названия
     * 
     */
    @Test
    public void findName(){
        ProductPage productPage = getProductPage();
        Assert.assertTrue(productPage.isProductNameDisplayed());
        Assert.assertEquals(name, productPage.getProductName());
    }
    /**
     * Тест проверки цены товара.
     * 
     * Шаги теста:
     * 
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Проверяем отображение цены товара через {@link ProductPage#isProductPriceDisplayed()}
     *   Сравниваем фактическую цену с ожидаемым значением
     * 
     *
     * Тест использует проверки:
     * 
     *   Assert.assertTrue() для подтверждения видимости цены
     *   Assert.assertEquals() для сравнения текста цены
     * 
     */
    @Test
    public void findPrice(){
        ProductPage productPage = getProductPage();
        Assert.assertTrue(productPage.isProductPriceDisplayed());
        Assert.assertEquals(price, productPage.getProductPrice());
    }
    /**
     * Тест проверки изображения товара.
     * 
     * Шаги теста:
     * 
     *   Получаем страницу товара через {@link BaseTest#getProductPage()}
     *   Проверяем загрузку изображения с ожидаемыми размерами через {@link ProductPage#isCanvasImageLoaded(String, String)}
     * 
     *
     * Тест использует проверку:
     * 
     *   Assert.assertTrue() для подтверждения корректной загрузки изображения
     * 
     */
    @Test
    public void findImg(){
        ProductPage productPage = getProductPage();
        Assert.assertTrue(productPage.isCanvasImageLoaded(width, height));
    }
}
