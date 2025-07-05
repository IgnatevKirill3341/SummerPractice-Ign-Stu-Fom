package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BuyPage {
    private final SelenideElement pageName = $x("//h1[@class='basket-section__header active']");
    public String getNamePage(){
        return pageName.getText();
    }
}
