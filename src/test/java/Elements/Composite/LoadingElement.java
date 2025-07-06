package Elements.Composite;

import Base.BaseElement;
import com.codeborne.selenide.Condition;

/**
 * Класс, представляющий элемент индикатора загрузки на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и предоставляет метод для ожидания завершения загрузки.
 * Используется для отслеживания состояния загрузки контента, когда на странице отображается индикатор прогресса.
 */
public class LoadingElement extends BaseElement {
    private final static String CLASS_XPATH = "//div[@class='%s']";
    /**
     * Конструктор для создания элемента индикатора загрузки по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public LoadingElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Ожидает исчезновения элемента индикатора загрузки.
     * Этот метод блокирует выполнение до тех пор, пока элемент загрузки не станет невидимым,
     * что сигнализирует о завершении процесса загрузки контента.
     * Использует условие Selenide {@code Condition.disappear} для проверки исчезновения элемента.
     */
    public void waitUntilLoad() {
        element.should(Condition.disappear);
    }
    /**
     * Фабричный метод для создания элемента индикатора загрузки по значению класса CSS.
     *
     * @param attributes  Значение класса CSS индикатора загрузки
     * @return Экземпляр LoadingElement
     */
    public static LoadingElement byClass(String attributes){
        return new LoadingElement(CLASS_XPATH, attributes);
    }
}
