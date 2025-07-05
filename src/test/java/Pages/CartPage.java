package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement product_name = $x("//span[@class='good-info__good-name']");
    private final SelenideElement plusOneProduct = $x("//button[@class='count__plus plus']");
    private final SelenideElement minusOneProduct = $x("//button[@class='count__minus minus']");
    private final SelenideElement productCount = $x("//input[@type='number']");
    private final SelenideElement deleteProductButton = $x("//button[@class='btn__del j-basket-item-del']");
    private final SelenideElement product = $x("//div[@class='list-item__wrap']");

    public SelenideElement getProduct(){
        return product;
    }
    public String getProductName(){
        return product_name.text();
    }
    public void increaseProductCount(){
        plusOneProduct.click();
    }
    public void decreaseProductCount(){
        minusOneProduct.click();
    }
    public void deleteProduct(){
        deleteProductButton.click();
    }
    public String getProductCount(){
        return productCount.getValue();
    }
}
