package Elements.Basis;

import Base.BaseElement;
/**
 * Класс, представляющий элемент ввода (&lt;input&gt;) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные для полей ввода операции.
 * Предоставляет методы для взаимодействия с текстовыми полями и фабричные методы для создания экземпляров.
 */
public class InputElement extends BaseElement {
    private static final String ID_XPATH = "//input[@id='%s']";
    private static final String TEXT_XPATH = "//input[contains(text(),'%s')]";
    private static final String CLASS_XPATH = "//input[@class='%s']";
    private static final String TYPE_XPATH  = "//input[@type='%s']";
    private static final String ARIA_LABEL_XPATH = "//input[@aria-label='%s']";
    private static final String INPUT_MODE_XPATH = "//input[@inputmode='%s']";
    /**
     * Конструктор для создания элемента ввода по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public InputElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента ввода по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public InputElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Устанавливает значение в поле ввода.
     * Заменяет текущее содержимое поля указанным значением.
     *
     * @param value  Текст для ввода в поле
     */
    public void setValue(String value){
        element.setValue(value);
    }
    /**
     * Получает текущее значение из поля ввода.
     *
     * @return Текущее содержимое поля ввода
     */
    public String getValue(){
        return element.getValue();
    }
    // Фабричные методы для создания экземпляров

    /**
     * Создает элемент ввода по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр InputElement
     */
    public static InputElement byId(String id, int index) {
        return new InputElement(ID_XPATH, id, index);
    }
    /**
     * Создает элемент ввода по текстовому содержимому (редко используется для input).
     *
     * @param text   Текст или часть текста связанного с полем ввода
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр InputElement
     */
    public static InputElement byText(String text, int index) {
        return new InputElement(TEXT_XPATH, text, index);
    }
    /**
     * Создает элемент ввода по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр InputElement
     */
    public static InputElement byClass(String className, int index) {
        return new InputElement(CLASS_XPATH, className, index);
    }
    /**
     * Создает элемент ввода по значению атрибута type.
     *
     * @param type   Значение атрибута "type" (например, "text", "password", "email")
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр InputElement
     */
    public static InputElement byType(String type, int index) {
        return new InputElement(TYPE_XPATH, type, index);
    }
    /**
     * Создает элемент ввода по значению атрибута aria-label.
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр InputElement
     */
    public static InputElement byAriaLabel(String ariaLabel, int index) {
        return new InputElement(ARIA_LABEL_XPATH, ariaLabel, index);
    }
    /**
     * Создает элемент ввода по произвольному XPath выражению с указанным индексом.
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр InputElement
     */
    public static InputElement byXPath(String xpath, int index) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new InputElement("%s", xpath, index);
    }
    /**
     * Создает элемент ввода по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр InputElement
     */
    public static InputElement byId(String id) {
        return new InputElement(ID_XPATH, id);
    }
    /**
     * Создает элемент ввода по текстовому содержимому (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста связанного с полем ввода
     * @return Экземпляр InputElement
     */
    public static InputElement byText(String text) {
        return new InputElement(TEXT_XPATH, text);
    }

    /**
     * Создает элемент ввода по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр InputElement
     */
    public static InputElement byClass(String className) {
        return new InputElement(CLASS_XPATH, className);
    }
    /**
     * Создает элемент ввода по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type" (например, "text", "password", "email")
     * @return Экземпляр InputElement
     */
    public static InputElement byType(String type) {
        return new InputElement(TYPE_XPATH, type);
    }
    /**
     * Создает элемент ввода по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр InputElement
     */
    public static InputElement byAriaLabel(String ariaLabel) {
        return new InputElement(ARIA_LABEL_XPATH, ariaLabel);
    }
    /**
     * Создает элемент ввода по произвольному XPath выражению (первый элемент в коллекции).
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр InputElement
     */
    public static InputElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new InputElement("%s", xpath);
    }
    /**
     * Создает элемент ввода по значению атрибута inputmode (первый элемент в коллекции).
     * Атрибут inputmode определяет тип клавиатуры для ввода на мобильных устройствах.
     *
     * @param inputMode  Значение атрибута "inputmode" (например, "text", "numeric", "email")
     * @return Экземпляр InputElement
     */
    public static InputElement byInputMode(String inputMode){
        return new InputElement(INPUT_MODE_XPATH, inputMode);
    }
}
