package Elements.Composite;

import Base.BaseElement;
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
    private static final String CLASS_XPATH = "//div[@class='%s']";
    private static final String SEARCH_BOX_INPUT_ID = "searchInput";
    private static final String BUTTON_SEARCH_ID = "applySearchBtn";
    private static final String OVERLAY_CLASS = "overlay overlay--search hide-mobile";
    private final static String AUTOCOMPLETE_CLASS = "autocomplete__content";

    // Внутренние элементы поисковой системы
    private final InputElement searchBoxInput = InputElement.byId(SEARCH_BOX_INPUT_ID);
    private final ButtonElement buttonSearch = ButtonElement.byId(BUTTON_SEARCH_ID);
    private final OverlayElement overlayElement = OverlayElement.byClass(OVERLAY_CLASS);
    private final AutocompliteElement autocompliteElement =AutocompliteElement.byClass(AUTOCOMPLETE_CLASS);
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
        return new SearchElement(CLASS_XPATH, attribute);
    }
}
