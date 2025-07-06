package Tests;

import Pages.BuyPage;
import Pages.MapPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;
/**
 * Тестовый класс для проверки процесса выбора и подтверждения адреса доставки.
 * Наследуется от {@link BaseTest}, содержащего общие настройки и методы для инициализации браузера.
 * Сценарий тестирования:
 *   Открыть страницу товара
 *   Оформить покупку в один клик
 *   Перейти к выбору метода доставки
 *   Добавить новый адрес через карту
 *   Ввести исходный адрес и выполнить поиск
 *   Выбрать найденный адрес
 *   Подтвердить адрес и вернуться на страницу заказа
 *   Проверить, что отображается ожидаемый адрес доставки
 */
public class DeliveryAddressTest extends BaseTest {
    private final static String originalAddress = "Санкт-Петербург, проспект Медиков 9Б";
    @Test
    public void deliveryAddressTest(){
        ProductPage productPage= getProductPage();
        BuyPage buyPage = productPage.buyNow(BuyPage.class);
        buyPage.openDeliveryMethod();
        MapPage mapPage = buyPage.addAddress(MapPage.class);
        mapPage.setAddress(originalAddress);
        mapPage.searchAddress();
        String selectedAddress = mapPage.getAddress();
        mapPage.selectAddress();
        BuyPage newBuyPage = mapPage.confirmAddress(BuyPage.class);
        String address = newBuyPage.getDeliveryAddress().split("\\r?\\n|\\r", 2)[0];
        Assert.assertEquals(selectedAddress, address);
    }


}
