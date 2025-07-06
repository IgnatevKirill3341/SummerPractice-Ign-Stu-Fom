package Elements.Basis;

import Base.BaseElement;

/**
 * Класс, представляющий элемент заголовка первого уровня (&lt;h1&gt;) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные для заголовков операции.
 * Предоставляет методы для работы с текстом заголовка и фабричные методы для создания экземпляров.
 */
public class HElement extends BaseElement {
    private static final String ID_XPATH = "//h1[@id='%s']";
    private static final String TEXT_XPATH = "//h1[contains(text(),'%s')]";
    private static final String CLASS_XPATH = "//h1[@class='%s']";
    private static final String TYPE_XPATH  = "//h1[@type='%s']";
    private static final String ARIA_LABEL_XPATH = "//h1[@aria-label='%s']";
    /**
     * Конструктор для создания элемента заголовка по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public HElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента заголовка по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public HElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Получает текстовое содержимое элемента заголовка.
     *
     * @return Видимый текст заголовка
     */
    public String getText(){
        return element.getText();
    }
    // Фабричные методы для создания экземпляров

    /**
     * Создает элемент заголовка по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр HElement
     */
    public static HElement byId(String id, int index) {
        return new HElement(ID_XPATH, id, index);
    }
    /**
     * Создает элемент заголовка по части текстового содержимого.
     *
     * @param text   Текст или часть текста заголовка
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр HElement
     */
    public static HElement byText(String text, int index) {
        return new HElement(TEXT_XPATH, text, index);
    }
    /**
     * Создает элемент заголовка по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр HElement
     */
    public static HElement byClass(String className, int index) {
        return new HElement(CLASS_XPATH, className, index);
    }
    /**
     * Создает элемент заголовка по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр HElement
     */
    public static HElement byType(String type, int index) {
        return new HElement(TYPE_XPATH, type, index);
    }
    /**
     * Создает элемент заголовка по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр HElement
     */
    public static HElement byId(String id) {
        return new HElement(ID_XPATH, id);
    }

    /**
     * Создает элемент заголовка по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста заголовка
     * @return Экземпляр HElement
     */
    public static HElement byText(String text) {
        return new HElement(TEXT_XPATH, text);
    }
    /**
     * Создает элемент заголовка по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр HElement
     */
    public static HElement byClass(String className) {
        return new HElement(CLASS_XPATH, className);
    }

    /**
     * Создает элемент заголовка по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр HElement
     */
    public static HElement byType(String type) {
        return new HElement(TYPE_XPATH, type);
    }
    /**
     * Создает элемент заголовка по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр HElement
     */
    public static HElement byAriaLabel(String ariaLabel) {
        return new HElement(ARIA_LABEL_XPATH, ariaLabel);
    }

    /**
     * Создает элемент заголовка по произвольному XPath выражению.

     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр HElement
     */
    public static HElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new HElement("%s", xpath);
    }
}
