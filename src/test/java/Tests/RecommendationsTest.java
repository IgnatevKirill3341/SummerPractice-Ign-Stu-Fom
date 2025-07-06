package Tests;

import Base.BaseTest;
import Pages.ProductPage;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

public class RecommendationsTest extends BaseTest {
    @Test
    public void recommendationsTest(){
        ProductPage productPage = getProductPage();
        productPage.scroll();
        Assert.assertTrue(productPage.hTwoIsVisible());
        //ProductPage newProductPage = productPage.goToCard(ProductPage.class);
        //Assert.assertTrue(newProductPage.isProductNameDisplayed());
    }
}
