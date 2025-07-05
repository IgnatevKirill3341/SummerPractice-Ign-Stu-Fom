package Tests;

import Pages.FavoritesPage;
import Pages.ProductPage;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;

public class AddProductToFavoritesTest extends BaseTest{
    private final String expectedPage = "Избранное";
    private final String expectedProductName = "Бейсболка белая Nike женские мужские Кепка с вышивкой";
    @Test
    public void addProductToFavoritesTest(){
        ProductPage productPage = openAppAndGoToProduct();
        productPage.addProductToFavorites();
        FavoritesPage favoritesPage = productPage.goToFavorites();
        Assert.assertEquals(expectedPage, favoritesPage.getNamePage());
        Assert.assertEquals(expectedProductName, favoritesPage.getProductNameFromFav());
        favoritesPage.getProductFromFav().shouldBe(Condition.visible);
    }
}
