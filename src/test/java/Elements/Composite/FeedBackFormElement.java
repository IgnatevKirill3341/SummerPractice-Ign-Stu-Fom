package Elements.Composite;

import Elements.BaseElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.SpanElement;
/**
 * Класс, представляющий форму обратной связи на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и предоставляет
 * методы для выбора варианта ответа и отправки формы.
 */
public class FeedBackFormElement extends BaseElement {
    private final SpanElement selection = SpanElement.byClass("radio-with-text__decor");
    private final ButtonElement sendButton = ButtonElement.byClass("btn-main");
    /**
     * Конструктор для создания элемента формы обратной связи по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение атрибута class для подстановки в шаблон
     */
    public FeedBackFormElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента формы обратной связи по XPath-шаблону,
     * значению класса и порядковому индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение атрибута class для подстановки в шаблон
     * @param index           Порядковый индекс элемента в списке (начиная с 1)
     */
    public FeedBackFormElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Выполняет выбор (клик) по радио кнопке внутри формы обратной связи.
     */
    public void select(){
        selection.click();
    }
    /**
     * Выполняет клик по кнопке отправки формы обратной связи.
     */
    public void send(){
        sendButton.click();
    }
    /**
     * Фабричный метод для создания элемента формы обратной связи
     * по значению CSS-класса и указанному индексу.
     *
     * @param attributeValue Значение CSS-класса контейнера формы
     * @param index          Порядковый индекс формы в коллекции (начиная с 1)
     * @return Новый экземпляр {@link FeedBackFormElement}
     */
    public static FeedBackFormElement byClass(String attributeValue, int index){
        return new FeedBackFormElement("//div[@class='%s']", attributeValue, index);
    }
}
