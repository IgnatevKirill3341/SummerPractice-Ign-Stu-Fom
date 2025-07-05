package Tests;

import Pages.CartPage;
import Pages.ProductPage;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;

public class ChangeProductCountTest extends BaseTest{
    private final String expectedProductCountAfterEncrease = "2";
    private final String expectedProductCountAfterDecrease = "1";
    @Test
    public void changeProductCountTest(){
        ProductPage productPage = openAppAndGoToProduct();
        CartPage cartPage = productPage.addAndGoToCart();

        cartPage.increaseProductCount();
        Assert.assertEquals(cartPage.getProductCount(), expectedProductCountAfterEncrease);
    }
    @Test
    public void decreaseProductCountTest(){
        ProductPage productPage = openAppAndGoToProduct();
        CartPage cartPage = productPage.addAndGoToCart();
        cartPage.decreaseProductCount();
        Assert.assertEquals(cartPage.getProductCount(), expectedProductCountAfterDecrease);
    }
    @Test
    public void deleteProductTest(){
        ProductPage productPage = openAppAndGoToProduct();
        CartPage cartPage = productPage.addAndGoToCart();
        cartPage.deleteProduct();
        cartPage.getProduct().shouldBe(Condition.disappear);
    }
}
