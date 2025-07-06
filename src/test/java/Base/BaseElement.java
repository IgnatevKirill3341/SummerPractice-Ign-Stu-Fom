package Base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$x;
/**
 * Базовый абстрактный класс для представления веб-элементов.
 * Предоставляет общие методы для работы с элементами на веб-странице с использованием Selenide.
 * Наследники должны реализовать специфичную для элемента логику.
 */
abstract public class BaseElement{
    private final static int firstElementOfCollection = 0;
    protected SelenideElement element;
    /**
     * Конструктор для создания элемента по XPath-шаблону с подстановкой значения атрибута.
     * Использует первый элемент из найденной коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения атрибута (%s)
     * @param attributeValue  Значение атрибута для подстановки в шаблон
     */
    protected BaseElement(String xpathTemplate, String attributeValue){
        element = $$x(String.format(xpathTemplate, attributeValue)).get(firstElementOfCollection);
    }
    /**
     * Конструктор для создания элемента по XPath-шаблону с подстановкой значения атрибута
     * и указанным индексом в коллекции.
     *
     * @param xpathTemplate   XPath-шаблон с плейсхолдером для значения атрибута (%s)
     * @param attributeValue  Значение атрибута для подстановки в шаблон
     * @param index           Индекс элемента в коллекции найденных элементов
     */
    protected BaseElement(String xpathTemplate, String attributeValue, int index){
        element = $$x(String.format(xpathTemplate, attributeValue)).get(index);
    }
    /**
     * Проверяет, отображается ли элемент на странице.
     *
     * @return {@code true} если элемент видим, {@code false} если элемент невидим или отсутствует
     */
    public boolean isDisplayed(){
        try{
            element.shouldBe(Condition.visible);
            return true;
        } catch (AssertionError e){
            return false;
        }
    }
    /**
     * Проверяет, доступен ли элемент для взаимодействия (не заблокирован).
     *
     * @return {@code true} если элемент доступен, {@code false} если элемент недоступен
     */
    public boolean isEnabled(){
        try{
            element.shouldBe(Condition.enabled);
            return true;
        } catch (AssertionError e){
            return false;
        }
    }
    /**
     * Получает значение указанного атрибута элемента.
     *
     * @param attributeName  Название атрибута (например, "id", "class", "href")
     * @return Значение атрибута или {@code null}, если элемент не найден
     */
    public String getAttribute(String attributeName){
        try {
            return element.getAttribute(attributeName);
        } catch (NoSuchElementException e){
            return null;
        }
    }
}
