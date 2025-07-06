package Elements.Composite;

import Base.BaseElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.InputElement;
/**
 * Класс, представляющий элемент товара в корзине на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и инкапсулирует поведение товара в корзине.
 * Предоставляет методы для управления количеством товара и его удаления из корзины.
 */
public class ProductInCartElement extends BaseElement {
    private final static String CLASS_XPATH = "//div[@class='%s']";
    private final static String PLUS_BUTTON_CLASS = "count__plus plus";
    private final static String MINUS_BUTTON_CLASS = "count__minus minus";
    private final static String DELETE_BUTTON_CLASS = "btn__del j-basket-item-del";
    private final static String PRODUCT_COUNT_TYPE = "number";

    // Элементы управления товаром в корзине
    private final ButtonElement plusButton = ButtonElement.byClass(PLUS_BUTTON_CLASS);
    private final ButtonElement minusButton = ButtonElement.byClass(MINUS_BUTTON_CLASS);
    private final ButtonElement deleteButton = ButtonElement.byClass(DELETE_BUTTON_CLASS);
    private final InputElement productCount = InputElement.byType(PRODUCT_COUNT_TYPE);
    /**
     * Конструктор для создания элемента товара в корзине по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public ProductInCartElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Увеличивает количество товара на одну единицу.
     * Выполняет клик по кнопке "+" рядом с товаром.
     */
    public void increaseProductCount(){
        plusButton.click();
    }
    /**
     * Уменьшает количество товара на одну единицу.
     * Выполняет клик по кнопке "-" рядом с товаром.
     * Если количество достигнет 1, дальнейшее уменьшение может быть заблокировано.
     */
    public void decreaseProductCount(){
        minusButton.click();
    }
    /**
     * Удаляет товар из корзины.
     * Выполняет клик по кнопке удаления товара.
     */
    public void deleteProduct(){
        deleteButton.click();
    }
    /**
     * Получает текущее количество товара в корзине.
     * Извлекает значение из поля ввода количества товара.
     *
     * @return Текущее количество товара в виде строки
     */
    public String getProductCount(){
        return productCount.getValue();
    }
    /**
     * Фабричный метод для создания элемента товара в корзине по значению класса CSS.
     *
     * @param attribute  Значение класса CSS контейнера товара в корзине
     * @return Экземпляр ProductInCartElement
     */
    public static ProductInCartElement byClass(String attribute){
        return new ProductInCartElement(CLASS_XPATH, attribute);
    }
}
