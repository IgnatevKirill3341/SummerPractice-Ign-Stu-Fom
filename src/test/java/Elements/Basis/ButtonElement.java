package Elements.Basis;

import Base.BaseElement;
/**
 * Класс, представляющий элемент кнопки (&lt;button&gt;) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные для кнопок операции.
 * Предоставляет фабричные методы для создания экземпляров с различными стратегиями поиска.
 */
public class ButtonElement extends BaseElement {
    private static final String ID_XPATH = "//button[@id='%s']";
    private static final String TEXT_XPATH = "//button[contains(text(),'%s')]";
    private static final String CLASS_XPATH = "//button[@class='%s']";
    private static final String TYPE_XPATH  = "//button[@type='%s']";
    private static final String ARIA_LABEL_XPATH = "//button[@aria-label='%s']";
    /**
     * Конструктор для создания элемента кнопки по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public ButtonElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента кнопки по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public ButtonElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Выполняет клик по элементу кнопки.
     */
    public void click(){
        element.click();
    }
    // Фабричные методы для создания экземпляров

    /**
     * Создает элемент кнопки по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byId(String id, int index) {
        return new ButtonElement(ID_XPATH, id, index);
    }
    /**
     * Создает элемент кнопки по части текстового содержимого.
     *
     * @param text   Текст или часть текста кнопки
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byText(String text, int index) {
        return new ButtonElement(TEXT_XPATH, text, index);
    }
    /**
     * Создает элемент кнопки по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byClass(String className, int index) {
        return new ButtonElement(CLASS_XPATH, className, index);
    }
    /**
     * Создает элемент кнопки по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byType(String type, int index) {
        return new ButtonElement(TYPE_XPATH, type, index);
    }
    /**
     * Создает элемент кнопки по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byId(String id) {
        return new ButtonElement(ID_XPATH, id);
    }
    /**
     * Создает элемент кнопки по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста кнопки
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byText(String text) {
        return new ButtonElement(TEXT_XPATH, text);
    }
    /**
     * Создает элемент кнопки по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byClass(String className) {
        return new ButtonElement(CLASS_XPATH, className);
    }
    /**
     * Создает элемент кнопки по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byType(String type) {
        return new ButtonElement(TYPE_XPATH, type);
    }
    /**
     * Создает элемент кнопки по значению атрибута aria-label с указанным индексом.
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byAriaLabel(String ariaLabel, int index) {
        return new ButtonElement(ARIA_LABEL_XPATH, ariaLabel, index);
    }
    /**
     * Создает элемент кнопки по произвольному XPath выражению.
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр ButtonElement
     */
    public static ButtonElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new ButtonElement("%s", xpath);
    }
}
