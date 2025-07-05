package Tests;

import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

public class ChangeProductColorTest extends BaseTest{
    private final String anotherColorProductName = "Бейсболка Nike женские мужские Кепка с вышивкой";

    @Test
    public void changeProductColorTest(){
        ProductPage productPage = openAppAndGoToProduct();
        productPage.changeColor();
        ProductPage anotherColorProduct = new ProductPage();
        Assert.assertEquals(anotherColorProductName, anotherColorProduct.getProductName().text());
    }
}
