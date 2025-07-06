package Elements.Composite;

import Base.BaseElement;
import Elements.Basis.ButtonElement;
/**
 * Композитный элемент метода доставки на странице оформления заказа.
 * Наследует базовое поведение от {@link BaseElement} и предоставляет
 * функциональность для добавления нового адреса или пункта выдачи.
 *
 * Используется на странице выбора метода доставки (например, в корзине или при оформлении).
 */
public class DeliveryMethodElement extends BaseElement {
    private final static String CLASS_XPATH = "//div[@class='%s']";
    private final static String ADD_ADDRESS_AREA_LABEL = "Добавить пункт выдачи или адрес";
    private final ButtonElement addAddress = ButtonElement.byAriaLabel(ADD_ADDRESS_AREA_LABEL, 0);
    /**
     * Конструктор для создания элемента метода доставки по XPath-шаблону и значению CSS-класса.
     * Использует первый найденный элемент в DOM.
     *
     * @param xpathTemplate  XPath-шаблон с плейсхолдером для CSS-класса контейнера
     * @param attributeValue Значение CSS-класса контейнера метода доставки
     */
    public DeliveryMethodElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента метода доставки по XPath-шаблону,
     * значению CSS-класса и индексу в коллекции.
     *
     * @param xpathTemplate  XPath-шаблон с плейсхолдером для CSS-класса контейнера
     * @param attributeValue Значение CSS-класса контейнера метода доставки
     * @param index          Порядковый номер элемента в коллекции (начиная с 1)
     */
    public DeliveryMethodElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Нажимает кнопку добавления нового адреса или пункта выдачи.
     * Открывает соответствующий интерфейс для ввода адреса или выбора пункта выдачи.
     */
    public void addAddress(){
        addAddress.click();
    }

    /**
     * Фабричный метод для создания элемента метода доставки по CSS-классу контейнера
     * с указанием индекса в случае нескольких элементов на странице.
     *
     * @param attributeValue Значение CSS-класса контейнера метода доставки
     * @param index          Порядковый номер элемента в коллекции (начиная с 1)
     * @return Экземпляр {@link DeliveryMethodElement}
     */
    public static DeliveryMethodElement byClass(String attributeValue, int index){
        return new DeliveryMethodElement(CLASS_XPATH, attributeValue, index);
    }
}
