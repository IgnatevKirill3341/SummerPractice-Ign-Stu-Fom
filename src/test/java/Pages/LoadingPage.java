package Pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class LoadingPage {
    public void waitUntilLoad(){
        $x("//div[@class='general-preloader']").should(Condition.disappear);
    }
}
