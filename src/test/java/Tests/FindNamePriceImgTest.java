package Tests;

import Pages.LoadingPage;
import Pages.MainPage;
import Pages.ProductPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.attribute;

public class FindNamePriceImgTest extends BaseTest{
    private final String name = "Бейсболка белая Nike женские мужские Кепка с вышивкой";
    private final String price = "470 ₽";
    @Test
    public void findName(){
        ProductPage productPage = openAppAndGoToProduct();

        SelenideElement realProductName = productPage.getProductName();
        Assert.assertEquals(name, realProductName.getText());
        realProductName.shouldBe(Condition.visible);
    }
    @Test
    public void findPrice(){
        ProductPage productPage = openAppAndGoToProduct();

        SelenideElement realProductPrice =productPage.getProductPrice();
        Assert.assertEquals(price, realProductPrice.getText());
        realProductPrice.shouldBe(Condition.visible);
    }
    @Test
    public void findImg(){
        ProductPage productPage = openAppAndGoToProduct();

        SelenideElement realCanvasImg = productPage.getElementCanvas();
        realCanvasImg
                .shouldBe(Condition.visible)
                .shouldHave(attribute("width", "900"))
                .shouldHave(attribute("height", "1200"));
    }
}
