package Elements.Basis;

import Elements.BaseElement;
/**
 * Класс, представляющий элемент текстового контейнера (&lt;span&gt;) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные для span операции.
 * Предоставляет методы для взаимодействия с текстовыми элементами и фабричные методы для создания экземпляров.
 */
public class SpanElement extends BaseElement {
    /**
     * Конструктор для создания элемента span по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public SpanElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента span по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public SpanElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }

    /**
     * Получает текстовое содержимое элемента span.
     *
     * @return Видимый текст внутри элемента
     */
    public String getText(){
        return element.getText();
    }

    /**
     * Выполняет клик по элементу span.
     * Может использоваться для интерактивных span-элементов (например, с обработчиками кликов).
     */
    public void click(){
        element.click();
    }
    // Фабричные методы для создания экземпляров

    /**
     * Создает элемент span по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр SpanElement
     */
    public static SpanElement byId(String id, int index) {
        return new SpanElement("//span[@id='%s']", id, index);
    }
    /**
     * Создает элемент span по части текстового содержимого.
     *
     * @param text   Текст или часть текста внутри элемента
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр SpanElement
     */
    public static SpanElement byText(String text, int index) {
        return new SpanElement("//span[contains(text(),'%s')]", text, index);
    }
    /**
     * Создает элемент span по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр SpanElement
     */
    public static SpanElement byClass(String className, int index) {
        return new SpanElement("//span[@class='%s']", className, index);
    }
    /**
     * Создает элемент span по значению атрибута type (редко используется).
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр SpanElement
     */
    public static SpanElement byType(String type, int index) {
        return new SpanElement("//span[@type='%s']", type, index);
    }
    /**
     * Создает элемент span по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр SpanElement
     */
    public static SpanElement byId(String id) {
        return new SpanElement("//span[@id='%s']", id);
    }
    /**
     * Создает элемент span по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста внутри элемента
     * @return Экземпляр SpanElement
     */
    public static SpanElement byText(String text) {
        return new SpanElement("//span[contains(text(),'%s')]", text);
    }
    /**
     * Создает элемент span по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр SpanElement
     */
    public static SpanElement byClass(String className) {
        return new SpanElement("//span[@class='%s']", className);
    }
    /**
     * Создает элемент span по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр SpanElement
     */
    public static SpanElement byType(String type) {
        return new SpanElement("//span[@type='%s']", type);
    }
    /**
     * Создает элемент span по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр SpanElement
     */
    public static SpanElement byAriaLabel(String ariaLabel) {
        return new SpanElement("//span[@aria-label='%s']", ariaLabel);
    }
    /**
     * Создает элемент span по произвольному XPath выражению.
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр SpanElement
     */
    public static SpanElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new SpanElement("%s", xpath);
    }
}
