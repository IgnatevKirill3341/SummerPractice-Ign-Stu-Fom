package Tests;

import Pages.CartPage;
import Pages.ProductPage;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;

public class AddToCartTest extends BaseTest{
    private final String product_name = "Бейсболка белая Nike женские мужские Кепка с вышивкой";
    @Test
    public void addToCartTest(){
        ProductPage productPage = openAppAndGoToProduct();
        CartPage cartPage = productPage.addAndGoToCart();
        Assert.assertEquals(product_name, cartPage.getProductName());
        cartPage.getProduct().shouldBe(Condition.visible);
    }
}
