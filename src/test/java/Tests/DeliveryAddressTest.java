package Tests;

import Base.BaseTest;
import Pages.BuyPage;
import Pages.MapPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

public class DeliveryAddressTest extends BaseTest {
    private final static String originalAddress = "Санкт-Петербург, проспект Медиков 9Б";
    private final static String expectedAddress = "Санкт-Петербург, Аптекарский Проспект 18\nПроверьте, что выбран нужный адрес доставки";
    @Test
    public void deliveryAddressTest(){
        ProductPage productPage= getProductPage();
        BuyPage buyPage = productPage.buyNow(BuyPage.class);
        buyPage.openDeliveryMethod();
        MapPage mapPage = buyPage.addAddress(MapPage.class);
        mapPage.setAddress(originalAddress);
        mapPage.searchAddress();
        mapPage.selectAddress();
        BuyPage newBuyPage = mapPage.confirmAddress(BuyPage.class);
        Assert.assertEquals(expectedAddress,newBuyPage.getDeliveryAddress());
    }


}
