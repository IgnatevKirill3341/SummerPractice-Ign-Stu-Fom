package Elements.Composite;

import Base.BaseElement;
/**
 * Класс, представляющий элемент товара в разделе избранного на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и служит основой для работы с товарами в избранном.
 * Предоставляет фабричный метод для создания экземпляров элемента. Может быть расширен для добавления специфичных операций
 * с товарами в избранном (например, удаление, перемещение в корзину, проверка свойств товара).
 */
public class ProductInFavoritesElement extends BaseElement {
    private final static String CLASS_XPATH = "//div[@class='%s']";
    /**
     * Конструктор для создания элемента товара в избранном по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public ProductInFavoritesElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }

    /**
     * Фабричный метод для создания элемента товара в избранном по значению класса CSS.

     * Использует XPath-шаблон для поиска div-элементов с указанным классом.
     *
     * @param attribute  Значение класса CSS контейнера товара в избранном
     * @return Экземпляр ProductInFavoritesElement
     */
    public static ProductInFavoritesElement byClass(String attribute){
        return new ProductInFavoritesElement(CLASS_XPATH, attribute);
    }
}
