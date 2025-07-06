package Pages;

import Base.BasePage;
import Elements.Basis.*;
import Elements.Composite.RecommendedProductsElement;
import Elements.Composite.SearchElement;
import com.codeborne.selenide.Selenide;

/**
 * Класс, представляющий страницу товара в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для взаимодействия со всеми элементами страницы товара.
 * 
 * Инкапсулирует:
 *   Основную информацию о товаре (название, цена)
 *   Изображение товара
 *   Элементы управления (добавление в корзину/избранное)
 *   Рейтинг товара
 *   Систему быстрого заказа
 * 
 * Содержит бизнес-логику для основных сценариев работы со страницей товара.
 */
public class ProductPage extends BasePage {
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String H_PRODUCT_NAME_CLASS = "product-page__title";
    private final static String SPAN_PRODUCT_PRICE_CLASS = "price-block__wallet-price red-price";
    private final static String CANVAS_PRODUCT_IMAGE_CLASS = "photo-zoom__preview j-image-canvas";
    private final static String BUTTON_ADD_TO_CART_ARIA_LABEL = "Добавить в корзину";
    private final static String A_DATA_WBA_HEADER_NAME_GO_TO_CART = "Cart";
    private final static String A_COLOR_ARIA_LABEL = "черный";
    private final static String BUTTON_ADD_TO_FAVORITES_CLASS = "";
    private final static String A_DATA_WBA_HEADER_NAME_GO_TO_FAVORITES = "Favorites";
    private final static String SPAN_RATING_CLASS = "product-review__rating address-rate-mini address-rate-mini--sm";
    private final static String BUTTON_BUY_IN_ONE_CLICK_CLASS = "order__button order__btn-buy btn-base";
    private final static String SEARCH_DIV_CLASS = "search-catalog__block search-catalog--active";
    private final static String RECOMMENDATIONS_CLASS = "j-b-recommended-goods-wrapper goods-carousel";
    // Элементы страницы товара
    private final HElement productName = HElement.byClass(H_PRODUCT_NAME_CLASS);
    private final SpanElement productPrice = SpanElement.byClass(SPAN_PRODUCT_PRICE_CLASS, 3);
    private final CanvasElement productImg = CanvasElement.byClass(CANVAS_PRODUCT_IMAGE_CLASS);
    private final ButtonElement addToCart = ButtonElement.byAriaLabel(BUTTON_ADD_TO_CART_ARIA_LABEL, 1);
    private final AElement goToCart = AElement.byDataWbaHeaderName(A_DATA_WBA_HEADER_NAME_GO_TO_CART);
    private final AElement color = AElement.byAriaLabel(A_COLOR_ARIA_LABEL);
    private final ButtonElement addToFavorites = ButtonElement.byClass(BUTTON_ADD_TO_FAVORITES_CLASS);
    private final AElement goToFavorites = AElement.byDataWbaHeaderName(A_DATA_WBA_HEADER_NAME_GO_TO_FAVORITES);
    private final SpanElement rating = SpanElement.byClass(SPAN_RATING_CLASS);
    private final ButtonElement buyInOneCLick = ButtonElement.byClass(BUTTON_BUY_IN_ONE_CLICK_CLASS,1 );
    private final SearchElement searchElement = SearchElement.byClass(SEARCH_DIV_CLASS);
    private final RecommendedProductsElement recommendedProductsElement = RecommendedProductsElement.byClass(RECOMMENDATIONS_CLASS);
    /**
     * Конструктор страницы товара.
     * 
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public ProductPage(){
        super(MainPage.class, MAIN_TAG_XPATH);
    }
    /**
     * Проверяет, отображается ли название товара.
     *
     * @return {@code true} если название товара видимо, {@code false} в противном случае
     */
    public boolean isProductNameDisplayed(){
        return productName.isDisplayed();
    }
    /**
     * Получает текст названия товара.
     *
     * @return Название товара
     */
    public String getProductName(){
        return productName.getText();
    }
    /**
     * Проверяет, отображается ли цена товара.
     *
     * @return {@code true} если цена товара видима, {@code false} в противном случае
     */
    public boolean isProductPriceDisplayed(){
        return productPrice.isDisplayed();
    }
    /**
     * Получает текст цены товара.
     *
     * @return Цена товара
     */
    public String getProductPrice(){
        return productPrice.getText();
    }
    /**
     * Проверяет, загружено ли изображение товара с указанными размерами.
     *
     * @param width  Ожидаемая ширина изображения
     * @param height Ожидаемая высота изображения
     * @return {@code true} если изображение загружено с указанными размерами, {@code false} в противном случае
     */
    public boolean isCanvasImageLoaded(String width, String height){
        return productImg.isLoaded(width, height);
    }
    /**
     * Добавляет товар в корзину.
     */
    public void addToCart(){
        addToCart.click();
    }
    /**
     * Переходит в корзину.
     */
    public void goToCart(){
        goToCart.click();
    }
    /**
     * Изменяет цвет товара и возвращает новую страницу товара.
     *
     * @param className Класс страницы для возврата (обычно ProductPage)
     * @return Экземпляр новой страницы товара после смены цвета
     */
    public <T extends BasePage> T changeColor(Class<T> className){
        color.click();
        return page(className);
    }
    /**
     * Добавляет товар в избранное.
     */
    public void addToFavorites(){
        addToFavorites.click();
    }
    /**
     * Переходит в раздел избранного.
     *
     * @param className Класс страницы избранного (FavoritesPage)
     * @return Экземпляр страницы избранного
     */
    public <T extends BasePage> T  goToFavorites(Class<T> className){
        goToFavorites.click();
        return page(className);
    }
    /**
     * Проверяет, отображается ли рейтинг товара.
     *
     * @return {@code true} если рейтинг видим, {@code false} в противном случае
     */
    public boolean isRatingDisplayed(){
        return rating.isDisplayed();
    }
    /**
     * Получает числовое значение рейтинга товара.
     *
     * @return Значение рейтинга в виде числа с плавающей точкой
     */
    public float getRating(){
        return Float.parseFloat(rating.getText().replace(',', '.'));
    }
    /**
     * Оформляет быстрый заказ товара.
     *
     * @param className Класс страницы оформления заказа
     * @return Экземпляр страницы оформления заказа
     */
    public <T extends BasePage> T buyNow(Class<T> className){
        buyInOneCLick.click();
        return page(className);
    }
    /**
     * Открывает новую страницу приложения.
     *
     * @param className Класс страницы, которую нужно открыть
     * @return Экземпляр запрошенной страницы
     */
    public <T extends BasePage> T openNewPage(Class<T> className){
        return page(className);
    }
    public boolean hTwoIsVisible(){

        return recommendedProductsElement.hTwoIsVisible();
    }
    public boolean cardIsVisible(){
        return recommendedProductsElement.cardIsVisible();
    }
    public <T extends BasePage> T goToCard(Class<T> className){
        recommendedProductsElement.goToProduct();
        return page(className);
    }
    public void scroll(){
        Selenide.executeJavaScript("window.scrollBy(0,1500)");
    }


}