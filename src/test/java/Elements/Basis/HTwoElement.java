package Elements.Basis;

import Elements.BaseElement;

/**
 * Обёртка для HTML-элемента <h2>, предоставляющая методы поиска и взаимодействия.
 * Наследует базовую функциональность от {@link BaseElement}.
 * Поддерживает различные способы локализации: по id, тексту, классу, типу и aria-label.
 */
public class HTwoElement extends BaseElement {
    /**
     * Конструктор для создания элемента заголовка по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public HTwoElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента заголовка по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public HTwoElement(String xpathTemplate, String attributeValue, int index){
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
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byId(String id, int index) {
        return new HTwoElement("//h2[@id='%s']", id, index);
    }
    /**
     * Создает элемент заголовка по части текстового содержимого.
     *
     * @param text   Текст или часть текста заголовка
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byText(String text, int index) {
        return new HTwoElement("//h2[contains(text(),'%s')]", text, index);
    }
    /**
     * Создает элемент заголовка по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byClass(String className, int index) {
        return new HTwoElement("//h2[@class='%s']", className, index);
    }
    /**
     * Создает элемент заголовка по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byType(String type, int index) {
        return new HTwoElement("//h2[@type='%s']", type, index);
    }
    /**
     * Создает элемент заголовка по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byId(String id) {
        return new HTwoElement("//h2[@id='%s']", id);
    }

    /**
     * Создает элемент заголовка по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста заголовка
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byText(String text) {
        return new HTwoElement("//h2[contains(text(),'%s')]", text);
    }
    /**
     * Создает элемент заголовка по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byClass(String className) {
        return new HTwoElement("//h2[@class='%s']", className);
    }

    /**
     * Создает элемент заголовка по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byType(String type) {
        return new HTwoElement("//h2[@type='%s']", type);
    }
    /**
     * Создает элемент заголовка по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byAriaLabel(String ariaLabel) {
        return new HTwoElement("//h2[@aria-label='%s']", ariaLabel);
    }

    /**
     * Создает элемент заголовка по произвольному XPath выражению.

     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр HTwoElement
     */
    public static HTwoElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new HTwoElement("%s", xpath);
    }
}
