package Elements.Basis;

import Base.BaseElement;

public class DivElement extends BaseElement {
    private static final String ID_XPATH = "//div[@id='%s']";
    private static final String TEXT_XPATH = "//div[contains(text(),'%s')]";
    private static final String CLASS_XPATH = "//div[@class='%s']";
    private static final String TYPE_XPATH  = "//div[@type='%s']";
    private static final String ARIA_LABEL_XPATH = "//div[@aria-label='%s']";
    private static final String DATA_WBA_HEADER_NAME = "//div[@data-wba-header-name='%s']";

    public DivElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    public DivElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }

    public String getText(){
        return element.getText();
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
        return new DivElement(ID_XPATH, id, index);
    }
    /**
     * Создает элемент ссылки по части текстового содержимого.
     *
     * @param text   Текст или часть текста ссылки
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byText(String text, int index) {
        return new DivElement(TEXT_XPATH, text, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута class.
     *
     * @param className  Значение атрибута "class"
     * @param index      Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byClass(String className, int index) {
        return new DivElement(CLASS_XPATH, className, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута type.
     *
     * @param type   Значение атрибута "type"
     * @param index  Индекс элемента в коллекции
     * @return Экземпляр DivElement
     */
    public static DivElement byType(String type, int index) {
        return new DivElement(TYPE_XPATH, type, index);
    }
    /**
     * Создает элемент ссылки по значению атрибута ID (первый элемент в коллекции).
     *
     * @param id  Значение атрибута "id"
     * @return Экземпляр DivElement
     */
    public static DivElement byId(String id) {
        return new DivElement(ID_XPATH, id);
    }
    /**
     * Создает элемент ссылки по части текстового содержимого (первый элемент в коллекции).
     *
     * @param text  Текст или часть текста ссылки
     * @return Экземпляр DivElement
     */
    public static DivElement byText(String text) {
        return new DivElement(TEXT_XPATH, text);
    }
    /**
     * Создает элемент ссылки по значению атрибута class (первый элемент в коллекции).
     *
     * @param className  Значение атрибута "class"
     * @return Экземпляр DivElement
     */
    public static DivElement byClass(String className) {
        return new DivElement(CLASS_XPATH, className);
    }
    /**
     * Создает элемент ссылки по значению атрибута type (первый элемент в коллекции).
     *
     * @param type  Значение атрибута "type"
     * @return Экземпляр DivElement
     */
    public static DivElement byType(String type) {
        return new DivElement(TYPE_XPATH, type);
    }
    /**
     * Создает элемент ссылки по значению атрибута aria-label (первый элемент в коллекции).
     *
     * @param ariaLabel  Значение атрибута "aria-label"
     * @return Экземпляр DivElement
     */
    public static DivElement byAriaLabel(String ariaLabel) {
        return new DivElement(ARIA_LABEL_XPATH, ariaLabel);
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
        return new DivElement(DATA_WBA_HEADER_NAME, dataWbaHeaderName);
    }
}
