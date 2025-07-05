package Tests;

import Pages.ProductPage;
import Pages.SearchPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

public class RatingTest extends BaseTest{
    private final String searchStr = "бейсболка";
    @Test
    public void productRatingTest(){
        ProductPage productPage = openAppAndGoToProduct();
        SelenideElement rating = productPage.getRating().shouldBe(Condition.visible);
        float float_rating = Float.parseFloat(rating.getText().replace(',', '.'));
        Assert.assertTrue(ratingInRange(float_rating));
    }
    @Test
    public void filterRatingTest(){
        ProductPage productPage = openAppAndGoToProduct();
        SearchPage searchPage = productPage.search(searchStr);
        searchPage.clickOnDropdownAndChooseRating();
        float[] ratings = searchPage.getRatings();
        for (float rating : ratings) {
            Assert.assertTrue(ratingInRange(rating));
        }
    }
    public boolean ratingInRange(float rating){
        return rating >= 0.0f && rating <= 5.0f;
    }
}
