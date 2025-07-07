package Elements.Basis;

import Elements.BaseElement;
/**
 * Класс, представляющий элемент ссылки (&lt;a&gt;) на веб-странице.
 * Предоставляет специализированные методы и фабричные методы для создания экземпляров
 * с различными стратегиями поиска.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные для ссылок операции.
 */
public class AElement extends BaseElement {
    /**
     * Конструктор для создания элемента по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public AElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public AElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }

    /**
     * Выполняет клик по элементу ссылки.
     */
    public void click(){
        element.click();
    }
    /**
     * Получает текстовое содержимое элемента ссылки.
     *
     * @return Видимый текст ссылки
     */
    public String getText(){
        return element.getText();
    }
    // Ниже представлены фабричные методы для создания экземпляров с различными стратегиями поиска
    public String getAttribute(String s){return  element.getAttribute(s);}
    /**
     * Создает элемент ссылки по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр AElement
     */
    public static AElement byId(String id, int index) {
        return new AElement("//a[@id='%s']", id, index);
    }
    /**
     * Создает элемент ссылки по части текстового содержимого.
     *
     * @param text   Текст или часть текста ссылки
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр AElement
     */
    public static AElement byText(String text, int index) {
        return new AElement("//a[contains(text(),'%s')]", text, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр AElement
     */
    public static AElement byClass(String className, int index) {
        return new AElement("//a[@class='%s']", className, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр AElement
     */
    public static AElement byType(String type, int index) {
        return new AElement("//a[@type='%s']", type, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр AElement
     */
    public static AElement byId(String id) {
        return new AElement("//a[@id='%s']", id);
    }
    /**
     * Создает элемент ссылки по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста ссылки
     * @return Экземпляр AElement
     */
    public static AElement byText(String text) {
        return new AElement("//a[contains(text(),'%s')]", text);
    }
    /**
     * Создает элемент ссылки по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр AElement
     */
    public static AElement byClass(String className) {
        return new AElement("//a[@class='%s']", className);
    }
    /**
     * Создает элемент ссылки по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр AElement
     */
    public static AElement byType(String type) {
        return new AElement("//a[@type='%s']", type);
    }
    /**
     * Создает элемент ссылки по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр AElement
     */
    public static AElement byAriaLabel(String ariaLabel) {
        return new AElement("//a[@aria-label='%s']", ariaLabel);
    }
    /**
     * Создает элемент ссылки по произвольному XPath выражению.
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр AElement
     */
    public static AElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new AElement("%s", xpath);
    }
    /**
     * Создает элемент ссылки по значению атрибута data-wba-header-name (первый элемент в коллекции).
     *
     * @param dataWbaHeaderName  Значение атрибута "data-wba-header-name"
     * @return Экземпляр AElement
     */
    public static AElement byDataWbaHeaderName(String dataWbaHeaderName) {
        return new AElement("//a[@data-wba-header-name='%s']", dataWbaHeaderName);
    }
}
