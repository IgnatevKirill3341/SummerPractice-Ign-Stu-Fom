package Elements.Composite;

import Elements.BaseElement;
import com.codeborne.selenide.Selenide;
/**
 * Класс, представляющий оверлейный элемент (наложение) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и предоставляет метод для программного удаления оверлея.
 * Используется для работы с элементами, перекрывающими основной контент (например, модальные окна, затемнения),
 * которые могут мешать взаимодействию с другими элементами.
 */
public class OverlayElement extends BaseElement {
    /**
     * Конструктор для создания оверлейного элемента по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public OverlayElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Программно удаляет оверлейный элемент со страницы с помощью JavaScript.
     * Этот метод эффективен, когда стандартные методы скрытия или закрытия оверлея недоступны.
     * Удаление элемента из DOM позволяет взаимодействовать с элементами, которые были перекрыты.
     */
    public void deleteOverlay(){
        Selenide.executeJavaScript("arguments[0].remove();", element);
    }
    /**
     * Фабричный метод для создания оверлейного элемента по значению класса CSS.
     * Использует XPath-шаблон для поиска div-элементов с указанным классом.
     *
     * @param attribute  Значение класса CSS (например, "overlay overlay--search hide-mobile")
     * @return Экземпляр OverlayElement
     */
    public static OverlayElement byClass(String attribute){
        return new OverlayElement("//div[@class='%s']", attribute);
    }
}
