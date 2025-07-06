package Elements.Basis;

import Elements.BaseElement;
import com.codeborne.selenide.Condition;

import java.time.Duration;

/**
 * Класс, представляющий элемент div на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и предоставляет специфичные для div операции.
 * Предоставляет методы для работы с текстовым содержимым и проверки появления элемента,
 * а также фабричные методы для создания экземпляров с различными стратегиями поиска.
 */
public class DivElement extends BaseElement {
    /**
     * Конструктор для создания div-элемента по XPath-шаблону и значению атрибута.
     * Использует первый элемент в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     */
    public DivElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания div-элемента по XPath-шаблону, значению атрибута и индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения
     * @param attributeValue  Значение для подстановки в шаблон
     * @param index           Индекс элемента в коллекции
     */
    public DivElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Получает текстовое содержимое div-элемента.
     *
     * @return Видимый текст внутри элемента
     */
    public String getText(){
        return element.getText();
    }
    /**
     * Проверяет, появился ли элемент в течение заданного времени (10 секунд).
     * Используется для ожидания появления динамически загружаемых элементов.
     * @return {@code true} если элемент стал видимым в течение 10 секунд, {@code false} в противном случае
     */
    public boolean elementAppeared(){
        return element.is(Condition.visible, Duration.ofSeconds(10));
    }
    // Ниже представлены фабричные методы для создания экземпляров с различными стратегиями поиска

    /**
     * Создает элемент ссылки по значению атрибута ID.
     *
     * @param id     Значение атрибута "id"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byId(String id, int index) {
        return new DivElement("//div[@id='%s']", id, index);
    }
    /**
     * Создает элемент ссылки по части текстового содержимого.
     *
     * @param text   Текст или часть текста ссылки
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byText(String text, int index) {
        return new DivElement("//div[contains(text(),'%s')]", text, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byClass(String className, int index) {
        return new DivElement("//div[@class='%s']", className, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byType(String type, int index) {
        return new DivElement("//div[@type='%s']", type, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр DivElement
     */
    public static DivElement byId(String id) {
        return new DivElement("//div[@id='%s']", id);
    }
    /**
     * Создает элемент ссылки по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста ссылки
     * @return Экземпляр DivElement
     */
    public static DivElement byText(String text) {
        return new DivElement("//div[contains(text(),'%s')]", text);
    }
    /**
     * Создает элемент ссылки по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр DivElement
     */
    public static DivElement byClass(String className) {
        return new DivElement("//div[@class='%s']", className);
    }
    /**
     * Создает элемент ссылки по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр DivElement
     */
    public static DivElement byType(String type) {
        return new DivElement("//div[@type='%s']", type);
    }
    /**
     * Создает элемент ссылки по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр DivElement
     */
    public static DivElement byAriaLabel(String ariaLabel) {
        return new DivElement("//div[@aria-label='%s']", ariaLabel);
    }
    /**
     * Создает элемент ссылки по произвольному XPath выражению.
     * Использует шаблон "%s", что позволяет передавать любой XPath напрямую.
     *
     * @param xpath  Полный XPath выражения для поиска элемента
     * @return Экземпляр DivElement
     */
    public static DivElement byXPath(String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new DivElement("%s", xpath);
    }
    /**
     * Создает элемент ссылки по значению атрибута data-wba-header-name (первый элемент в коллекции).
     *
     * @param dataWbaHeaderName  Значение атрибута "data-wba-header-name"
     * @return Экземпляр DivElement
     */
    public static DivElement byDataWbaHeaderName(String dataWbaHeaderName) {
        return new DivElement("//div[@data-wba-header-name='%s']", dataWbaHeaderName);
    }


}
