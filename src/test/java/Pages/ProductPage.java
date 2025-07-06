package Pages;

import Elements.Basis.*;
import Elements.Composite.RecommendedProductsElement;

/**
 * Класс, представляющий страницу товара в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для взаимодействия со всеми элементами страницы товара.
 * Инкапсулирует:
 *   Основную информацию о товаре (название, цена)
 *   Изображение товара
 *   Элементы управления (добавление в корзину/избранное)
 *   Рейтинг товара
 *   Систему быстрого заказа
 * Содержит бизнес-логику для основных сценариев работы со страницей товара.
 */
public class ProductPage extends BasePage {
    // Элементы страницы товара
    private final HElement productName = HElement.byClass("product-page__title");
    private final SpanElement productPrice = SpanElement.byClass("price-block__wallet-price red-price", 3);
    private final CanvasElement productImg = CanvasElement.byClass("photo-zoom__preview j-image-canvas");
    private final ButtonElement addToCart = ButtonElement.byAriaLabel("Добавить в корзину", 1);
    private final AElement goToCart = AElement.byDataWbaHeaderName("Cart");
    private final AElement color = AElement.byAriaLabel("черный");
    private final ButtonElement addToFavorites = ButtonElement.byClass("");
    private final AElement goToFavorites = AElement.byDataWbaHeaderName("Favorites");
    private final SpanElement rating = SpanElement.byClass("product-review__rating address-rate-mini address-rate-mini--sm");
    private final ButtonElement buyInOneCLick = ButtonElement.byClass("order__button order__btn-buy btn-base",1 );
    private final RecommendedProductsElement recommendedProductsElement = RecommendedProductsElement.byClass("j-b-recommended-goods-wrapper goods-carousel");
    private final AElement openReviews = AElement.byClass("user-opinion__text");
    /**
     * Конструктор страницы товара.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public ProductPage(){
        super(MainPage.class, "//main");
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
    /**
     * Скроллит до блока рекомендованных товаров.
     */
    public void scrollToRecommends(){
        recommendedProductsElement.scrollToRecommends();
    }
    /**
     * Проверяет, видна ли первая рекомендованная карточка товара.
     *
     * @return {@code true}, если карточка видима
     */
    public boolean isCardVisible(){
        return recommendedProductsElement.cardIsVisible();
    }
    /**
     * Проверяет видимость блока рекомендованных товаров.
     *
     * @return {@code true}, если блок рекомендаций отображается
     */
    public boolean isRecommendedProductsVisible(){
        return recommendedProductsElement.isDisplayed();
    }
    /**
     * Переходит на страницу товара из раздела рекомендованных товаров.
     *
     * @param className Класс целевой страницы товара
     * @param <T>       Тип возвращаемой страницы
     * @return Экземпляр страницы товара
     */
    public <T extends BasePage> T goToProduct(Class<T> className){
        recommendedProductsElement.goToProduct();
        return page(className);
    }
    /**
     * Возвращает название товара из первого рекомендованного блока.
     *
     * @return Название рекомендованного продукта
     */
    public String getCardName(){
        return recommendedProductsElement.getCardName();
    }
    /**
     * Открывает раздел отзывов о товаре.
     *
     * @param className Класс страницы отзывов
     * @param <T>       Тип страницы отзывов
     * @return Экземпляр страницы отзывов
     */
    public <T extends BasePage> T openReviews(Class<T> className){
        openReviews.click();
        return page(className);
    }
}