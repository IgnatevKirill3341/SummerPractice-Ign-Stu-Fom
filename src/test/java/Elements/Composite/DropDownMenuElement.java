package Elements.Composite;

import Elements.BaseElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.SpanElement;

/**
 * Класс, представляющий выпадающее меню (dropdown) на веб-странице.
 * Наследует базовую функциональность от {@link BaseElement} и инкапсулирует поведение выпадающего меню.
 * Предоставляет методы для взаимодействия с элементами выпадающего меню: открытие меню и выбор варианта.
 */
public class DropDownMenuElement extends BaseElement {
    // Элементы управления выпадающего меню
    private final ButtonElement dropDownMenu = ButtonElement.byClass("dropdown-filter__btn dropdown-filter__btn--sorter  ");
    private final SpanElement dropDownVariants = SpanElement.byText("По рейтингу");
    /**
     * Конструктор для создания элемента выпадающего меню по XPath-шаблону и значению класса.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения класса
     * @param attributeValue  Значение класса для подстановки в шаблон
     */
    public DropDownMenuElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    /**
     * Открывает выпадающее меню путем клика по кнопке меню.
     * Этот метод активирует отображение вариантов выбора в меню.
     */
    public void openDropDownMenu(){
        dropDownMenu.click();
    }
    /**
     * Выбирает предопределенный вариант в выпадающем меню.
     * В текущей реализации всегда выбирает вариант "По рейтингу".
     * Перед использованием этого метода необходимо открыть меню с помощью {@link #openDropDownMenu()}.
     */
    public void chooseDropDownVariant(){
        dropDownVariants.click();
    }
    /**
     * Фабричный метод для создания элемента выпадающего меню по значению класса CSS.
     *
     * @param attribute  Значение класса CSS контейнера выпадающего меню
     * @return Экземпляр DropDownMenuElement
     */
    public static DropDownMenuElement byClass(String attribute){
        return new DropDownMenuElement("//div[@class='%s']", attribute);
    }
}
