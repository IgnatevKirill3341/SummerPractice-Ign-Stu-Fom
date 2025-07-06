package Elements.Composite;

import Elements.BaseElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.InputElement;
/**
 * Класс, представляющий комплексный элемент поиска на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и инкапсулирует все компоненты поисковой системы.
 * Объединяет:

 *   Поле ввода поискового запроса
 *   Кнопку выполнения поиска
 *   Оверлей (наложение)
 *   Элемент автодополнения
 * Предоставляет методы для полного цикла работы с поиском: ввод запроса, управление автодополнением, выполнение поиска.
 */
public class SearchElement extends BaseElement {
    // Внутренние элементы поисковой системы
    private final InputElement searchBoxInput = InputElement.byId("searchInput");
    private final ButtonElement buttonSearch = ButtonElement.byId("applySearchBtn");
    private final OverlayElement overlayElement = OverlayElement.byClass("overlay overlay--search hide-mobile");
    private final AutocompliteElement autocompliteElement =AutocompliteElement.byClass("autocomplete__content");
    /**
     * Конструктор для создания поискового элемента по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public SearchElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Вводит поисковый запрос в поле ввода.
     *
     * @param request  Текст поискового запроса
     */
    public void insertRequest(String request){
        searchBoxInput.setValue(request);
    }
    /**
     * Удаляет элемент автодополнения с помощью JavaScript.
     * Используется, когда автодополнение мешает дальнейшим действиям.
     */
    public void autocompleteDelete(){autocompliteElement.deleteAutocomplete();}
    /**
     * Активирует поиск путем клика по кнопке поиска.
     */
    public void pressSearchButton(){
        buttonSearch.click();
    }
    /**
     * Удаляет оверлейное наложение с помощью JavaScript.
     * Используется, когда оверлей блокирует взаимодействие с другими элементами.
     */
    public void deleteOverlay(){
        overlayElement.deleteOverlay();
    }
    /**
     * Фабричный метод для создания элемента поиска по значению класса CSS.
     *
     * @param attribute  Значение класса CSS контейнера поисковой системы
     * @return Экземпляр SearchElement
     */
    public static SearchElement byClass(String attribute){
        return new SearchElement("//div[@class='%s']", attribute);
    }
}
