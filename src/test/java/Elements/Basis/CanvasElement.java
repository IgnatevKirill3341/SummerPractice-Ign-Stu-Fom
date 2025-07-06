package Elements.Basis;

import Base.BaseElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.attribute;
/**
 * Класс, представляющий элемент холста (&lt;canvas&gt;) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные для canvas операции.
 * Предоставляет методы для проверки состояния холста и фабричные методы для создания экземпляров.
 */
public class CanvasElement extends BaseElement {
    private static final String ID_XPATH = "//canvas[@id='%s']";
    private static final String TEXT_XPATH = "//canvas[contains(text(),'%s')]";
    private static final String CLASS_XPATH = "//canvas[@class='%s']";
    private static final String TYPE_XPATH  = "//canvas[@type='%s']";
    private static final String ARIA_LABEL_XPATH = "//canvas[@aria-label='%s']";
    /**
     * Конструктор для создания элемента холста по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public CanvasElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента холста по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public CanvasElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Проверяет, загружен ли холст с указанными размерами.
     * Выполняет три проверки:
     *   Элемент видим на странице
     *   Атрибут "width" соответствует заданному значению
     *   Атрибут "height" соответствует заданному значению
     *
     * @param width   Ожидаемая ширина холста в пикселях
     * @param height  Ожидаемая высота холста в пикселях
     * @return {@code true} если все условия выполнены, {@code false} если хотя бы одно условие не выполнено
     */
    public boolean isLoaded(String width, String height){
        try {
            element.shouldBe(Condition.visible)
                    .shouldHave(attribute("width", width))
                    .shouldHave(attribute("height", height));
        return true;
        } catch (AssertionError e){
            return false;
        }
    }
    // Фабричные методы для создания экземпляров

    /**
     * Создает элемент холста по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byId(String id, int index) {
        return new CanvasElement(ID_XPATH, id, index);
    }
    /**
     * Создает элемент холста по текстовому содержимому (редко используется для canvas).
     *
     * @param text   Текст или часть текста внутри тега canvas
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byText(String text, int index) {
        return new CanvasElement(TEXT_XPATH, text, index);
    }
    /**
     * Создает элемент холста по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byClass(String className, int index) {
        return new CanvasElement(CLASS_XPATH, className, index);
    }
    /**
     * Создает элемент холста по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byType(String type, int index) {
        return new CanvasElement(TYPE_XPATH, type, index);
    }
    /**
     * Создает элемент холста по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byId(String id) {
        return new CanvasElement(ID_XPATH, id);
    }
    /**
     * Создает элемент холста по текстовому содержимому (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста внутри тега canvas
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byText(String text) {
        return new CanvasElement(TEXT_XPATH, text);
    }
    /**
     * Создает элемент холста по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byClass(String className) {
        return new CanvasElement(CLASS_XPATH, className);
    }

    /**
     * Создает элемент холста по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byType(String type) {
        return new CanvasElement(TYPE_XPATH, type);
    }
    /**
     * Создает элемент холста по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byAriaLabel(String ariaLabel) {
        return new CanvasElement(ARIA_LABEL_XPATH, ariaLabel);
    }
    /**
     * Создает элемент холста по произвольному XPath выражению.
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр CanvasElement
     */
    public static CanvasElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new CanvasElement("%s", xpath);
    }
}
