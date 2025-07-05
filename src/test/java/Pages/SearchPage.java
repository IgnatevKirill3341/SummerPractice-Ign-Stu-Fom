package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    private final SelenideElement dropdownFilter = $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter  ']");
    private final SelenideElement ratingFilter = $(byText("По рейтингу"));
    private final ElementsCollection ratings = $$x("//span[@class= 'address-rate-mini address-rate-mini--sm']");
    private final int countElementsToAdd = 20;
    public void clickOnDropdownAndChooseRating(){
        dropdownFilter.click();
        ratingFilter.click();
    }
    public float[] getRatings(){
        float[] float_ratings = new float[ratings.size()];
        for (int i = 0; i<countElementsToAdd; i++){
            float_ratings[i]=Float.parseFloat(ratings.get(i).getText().replace(',', '.'));
        }
        return float_ratings;
    }
}
