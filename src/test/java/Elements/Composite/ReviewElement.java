package Elements.Composite;

import Elements.BaseElement;
import Elements.Basis.ButtonElement;

/**
 * Класс, представляющий отдельный отзыв (Review) на странице.
 * Наследует базовую функциональность от {@link BaseElement}, предоставляет
 * методы для взаимодействия с кнопками внутри блока отзыва.
 */
public class ReviewElement extends BaseElement {
    private final ButtonElement feedBack = ButtonElement.byClass("feedback__menu");
    private final ButtonElement openForm = ButtonElement.byClass("menu-btn");
    /**
     * Конструктор для создания элемента отзыва по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate  XPath-шаблон с плейсхолдером или самим значением атрибута class
     * @param attributeValue Значение атрибута class для поиска контейнера отзыва
     */
    public ReviewElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Конструктор для создания элемента отзыва по XPath-шаблону, значению класса и индексу.
     *
     * @param xpathTemplate  XPath-шаблон с плейсхолдером или самим значением атрибута class
     * @param attributeValue Значение атрибута class для поиска контейнера отзыва
     * @param index          Порядковый номер отзыва в списке (начиная с 1)
     */
    public ReviewElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    /**
     * Клик по кнопке меню обратной связи в блоке отзыва.
     * Используется для отображения опций взаимодействия с отзывом.
     */
    public void feedBackButton(){
        feedBack.click();
    }
    /**
     * Клик по кнопке открытия формы для отправки отзыва.
     * Открывает модальное окно или блок с формой для ввода текста отзыва.
     */
    public void openForm(){
        openForm.click();
    }
    /**
     * Фабричный метод для создания первого элемента отзыва по значению CSS-класса.
     *
     * @param attributeValue Значение CSS-класса контейнера отзыва
     * @return Новый экземпляр {@link ReviewElement}
     */
    public static ReviewElement byClass(String attributeValue){
        return new ReviewElement("comments__item feedback product-feedbacks__block-wrapper", attributeValue);
    }
    /**
     * Фабричный метод для создания элемента отзыва по значению CSS-класса и указанному индексу.
     *
     * @param attributeValue Значение CSS-класса контейнера отзыва
     * @param index          Порядковый номер отзыва в списке (начиная с 1)
     * @return Новый экземпляр {@link ReviewElement}
     */
    public static ReviewElement byClass(String attributeValue, int index){
        return new ReviewElement("comments__item feedback product-feedbacks__block-wrapper", attributeValue, index);
    }
}
