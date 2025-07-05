package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    private final SelenideElement name = $x("//h1[@class='product-page__title']");
    private final ElementsCollection price = $$x("//span[@class='price-block__wallet-price red-price']");
    private final SelenideElement img = $x("//canvas[@class='photo-zoom__preview j-image-canvas']");
    private final ElementsCollection addToCartButton = $$x("//button[@class='order__button btn-main']");
    private final SelenideElement goToCart = $x("//a[@data-wba-header-name='Cart']");
    private final SelenideElement color = $x("//a[@aria-label='черный']");
    private final ElementsCollection addToFavoritesButton = $$x("//button[@aria-label='Добавить в избранное']");
    private final SelenideElement goToFavoritesButton = $x("//a[@data-wba-header-name='Favorites']");
    private final SelenideElement rating = $x("//span[@class='product-review__rating address-rate-mini address-rate-mini--sm']");
    private final SelenideElement searchBoxInput = $x("//input[@id='searchInput']");
    private final SelenideElement buttonSearch = $x("//button[@id='applySearchBtn']");
    private final ElementsCollection buyNowButton = $$x("//button[@class='order__button order__btn-buy btn-base']");
    public SelenideElement getProductName() {
        return name;
    }

    public SelenideElement getProductPrice() {
        return price.last();
    }

    public SelenideElement getElementCanvas() {
        return img;
    }
    public CartPage addAndGoToCart(){
        addToCartButton.last().click();
        goToCart.click();
        return new CartPage();
    }
    public void changeColor(){
        color.click();
    }
    public void addProductToFavorites(){
        addToFavoritesButton.last().click();
    }
    public FavoritesPage goToFavorites(){
        goToFavoritesButton.click();
        return new FavoritesPage();
    }
    public SelenideElement getRating(){
        return rating;
    }
    public SearchPage search(String search_str){
        searchBoxInput.setValue(search_str);
        buttonSearch.click();
        SelenideElement overlay = $x("//div[@class='overlay overlay--search hide-mobile']");
        Selenide.executeJavaScript("arguments[0].remove();", overlay);
        return new SearchPage();
    }
    public BuyPage buyNow(){
        buyNowButton.last().click();
        return new BuyPage();
    }
}