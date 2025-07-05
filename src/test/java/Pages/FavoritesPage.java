package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FavoritesPage {
    private final ElementsCollection favorites = $$x("//a[@data-lk-header-wba='LK_Favorites']");
    private final SelenideElement product_name = $x("//span[@class='favorites-card__name']");
    private final SelenideElement product = $x("//a[@class='goods-card__container']");
    public String getProductNameFromFav(){
        return product_name.getText();
    }
    public SelenideElement getProductFromFav(){
        return product;
    }
    public String getNamePage(){
        return favorites.last().getText();
    }
}
