package Elements.Composite;

import Elements.BaseElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.InputElement;
/**
 * Композитный элемент для поиска адреса на карте.
 * Наследует базовую функциональность от {@link BaseElement} и
 * предоставляет методы для ввода и подтверждения адреса в поле поиска карты.
 * Примеры использования:
 * MapSearchElement search = MapSearchElement.byClass("map-search__input-wrapper");
 * search.setAddress("Адрес");
 * search.findAddress();
 */
public class MapSearchElement extends BaseElement {
    private final InputElement mapSearchInput = InputElement.byClass("map-search__input");
    private final ButtonElement mapSearchButton = ButtonElement.byClass("map-search__confirm-btn");
    /**
     * Конструктор для создания элемента поиска по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для CSS-класса контейнера
     * @param attributeValue  Значение CSS-класса контейнера
     */
    public MapSearchElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Устанавливает текст адреса в поле ввода.
     *
     * @param address Строка адреса для поиска
     */
    public void setAddress(String address){
        mapSearchInput.setValue(address);
    }
    /**
     * Нажимает кнопку поиска адреса на карте.
     */
    public void findAddress(){
        mapSearchButton.click();
    }
    /**
     * Фабричный метод для создания элемента поиска по CSS-классу контейнера.
     *
     * @param attribute Значение CSS-класса контейнера
     * @return Экземпляр {@link MapSearchElement}
     */
    public static MapSearchElement byClass(String attribute){
        return new MapSearchElement("//div[@class='%s']", attribute);
    }
}
