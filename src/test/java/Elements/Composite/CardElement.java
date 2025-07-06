package Elements.Composite;

import Base.BaseElement;
import Elements.Basis.AElement;
import Elements.Basis.SpanElement;

/**
 * Класс, представляющий карточку товара (или аналогичный композитный элемент) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и предоставляет доступ к внутренним элементам карточки.
 * Содержит специализированные методы для работы с характеристиками карточки, такие как получение рейтинга.
 */
public class CardElement extends BaseElement {
    private final static String CLASS_XPATH = "//article[@class='%s']";
    private final static String RATING_CLASS = "address-rate-mini address-rate-mini--sm";
    private final static String A_ELEMENT_CLASS = "product-card__link j-card-link j-open-full-product-card";
    // Внутренний элемент рейтинга, находящийся внутри карточки
    private final SpanElement rating = SpanElement.byClass(RATING_CLASS);
    private final AElement aElement = AElement.byClass(A_ELEMENT_CLASS);

    /**
     * Конструктор для создания элемента карточки по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public CardElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента карточки по XPath-шаблону, значению класса и порядковому индексу.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение атрибута class для подстановки в шаблон
     * @param index           Порядковый индекс элемента в списке (начиная с 1)
     */
    public CardElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Получает числовое значение рейтинга из карточки.
     * Метод выполняет:
     *   Извлечение текста из элемента рейтинга
     *   Замену запятых на точки для корректного парсинга
     *   Преобразование строки в число типа float
     *
     *
     * @return Значение рейтинга в виде числа с плавающей точкой
     * @throws NumberFormatException если текст рейтинга не может быть преобразован в число
     */
    public float getRating(){
        return Float.parseFloat(rating.getText().replace(',', '.'));
    }
    /**
     * Фабричный метод для создания элемента карточки по значению класса CSS (первая карточка в коллекции).
     *
     * @param attribute  Значение класса CSS карточки
     * @return Экземпляр CardElement
     */
    public static CardElement byClass(String attribute){
        return new CardElement(CLASS_XPATH, attribute);
    }
    /**
     * Выполняет клик по всей карточке, переходя на страницу товара.
     */
    public void goToProduct(){
        element.click();
    }
    /**
     * Извлекает из текста карточки название товара.
     * Ожидается, что строка с именем товара содержит разделитель {@code " / "}, после которого идёт само название.
     *
     * @return Название товара внутри карточки
     */
    public String getCardName(){
        String[] lines = element.getText().split("\n");
        String productName = "";
        for (String line : lines){
            if (line.contains(" / ")) {
                productName = line.substring(line.indexOf(" / ") + 3);
                break;
            }
        }
        return productName;
    }
    /**
     * Фабричный метод для создания элемента карточки по значению класса CSS с указанным индексом.
     *
     * @param attribute  Значение класса CSS карточки
     * @param index      Порядковый индекс карточки в коллекции (начиная с 1)
     * @return Экземпляр CardElement
     */
    public static CardElement byClass(String attribute, int index){
        return new CardElement(CLASS_XPATH, attribute, index);
    }

}
