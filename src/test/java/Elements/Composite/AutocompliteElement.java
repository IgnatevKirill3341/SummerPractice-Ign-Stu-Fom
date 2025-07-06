package Elements.Composite;

import Base.BaseElement;
import com.codeborne.selenide.Selenide;
/**
 * Класс, представляющий элемент автодополнения (autocomplete) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и добавляет специфичные операции для работы с автодополнением.
 * Предоставляет метод для программного удаления элемента автодополнения и фабричный метод для создания экземпляров.
 */
public class AutocompliteElement extends BaseElement {
    private static final String CLASS_XPATH = "//div[@class='%s']";
    /**
     * Конструктор для создания элемента автодополнения по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public AutocompliteElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Программно удаляет элемент автодополнения со страницы с помощью JavaScript.
     * Этот метод может использоваться для принудительного скрытия автодополнения,
     * когда стандартные методы взаимодействия недоступны или неэффективны.
     */
    public void deleteAutocomplete(){
        Selenide.executeJavaScript("arguments[0].remove();", element);
    }
    /**
     * Фабричный метод для создания элемента автодополнения по значению класса CSS.
     * Использует XPath-шаблон для поиска по атрибуту class.
     *
     * @param attribute  Значение класса CSS (например, "overlay overlay--search hide-mobile")
     * @return Экземпляр AutocompliteElement
     */
    public static AutocompliteElement byClass(String attribute){
        return new AutocompliteElement(CLASS_XPATH, attribute);
    }
}
