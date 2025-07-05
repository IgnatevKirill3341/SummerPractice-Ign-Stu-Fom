package Tests;

import Pages.LoadingPage;
import Pages.MainPage;
import Pages.ProductPage;
import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.$x;

/*Абстрактный класс для тестовых классов*/
abstract public class BaseTest {
    protected final String BASE_URL = "https://www.wildberries.ru/";
    protected final String ARTICLE = "386427060";

    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        Configuration.browser="firefox";
        Configuration.browserSize="1360x768";
        Configuration.headless=false;
    }


    public ProductPage openAppAndGoToProduct(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.login();
        ProductPage productPage = mainPage.search(ARTICLE);
        LoadingPage loadingPage = new LoadingPage();
        loadingPage.waitUntilLoad();
        SelenideElement overlay = $x("//div[@class='overlay overlay--search hide-mobile']");
        Selenide.executeJavaScript("arguments[0].remove();", overlay);
        return productPage;
    }
    @Before
    public void init(){
        setUp();
    }
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
