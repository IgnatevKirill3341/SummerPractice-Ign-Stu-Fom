package Tests;

import Pages.BuyPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

public class BuyNowTest extends BaseTest{
    private final String expectedName = "Оформление заказа";
    @Test
    public void buyNowTest(){
        ProductPage productPage= openAppAndGoToProduct();
        BuyPage buyPage = productPage.buyNow();
        Assert.assertEquals(expectedName, buyPage.getNamePage());
    }
}
