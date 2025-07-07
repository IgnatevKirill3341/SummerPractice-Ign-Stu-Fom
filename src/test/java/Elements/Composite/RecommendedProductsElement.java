package Elements.Composite;

import Elements.BaseElement;

/**
 * Класс, представляющий блок рекомендованных товаров на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и предоставляет
 * методы для работы с внутренними элементами карточек рекомендаций.
 */
public class RecommendedProductsElement extends BaseElement {
    private final CardElement card = CardElement.byClass("product-card j-product-item j-analitics-item   ");
    /**
     * Конструктор для создания элемента блока рекомендованных товаров по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение атрибута class для подстановки в шаблон
     */
    public RecommendedProductsElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Проверяет, отображается ли карточка товара в блоке рекомендаций.
     *
     * @return {@code true}, если карточка видима на странице; {@code false} в противном случае
     */
    public boolean cardIsVisible(){
        return card.isDisplayed();
    }
    /**
     * Переходит на страницу товара, кликнув по карточке внутри блока рекомендаций.
     */
    public void goToProduct(){
        card.goToProduct();
    }
    /**
     * Скроллит страницу до блока рекомендованных товаров.
     */
    public void scrollToRecommends(){
        element.scrollTo();
    }
    /**
     * Извлекает название товара из первой карточки в блоке рекомендаций.
     *
     * @return Название товара в виде строки
     */
    public String getCardName(){
        return card.getCardName();
    }
    /**
     * Фабричный метод для создания первого блока рекомендованных товаров по значению CSS-класса.
     *
     * @param attributeValue Значение CSS-класса контейнера блока рекомендаций
     * @return Новый экземпляр {@link RecommendedProductsElement}
     */
    public static RecommendedProductsElement byClass(String attributeValue){
        return new RecommendedProductsElement("//div[@class='%s']", attributeValue);
    }
}
