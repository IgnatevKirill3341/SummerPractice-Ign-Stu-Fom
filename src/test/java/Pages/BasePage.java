package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Абстрактный базовый класс для представления веб-страниц в фреймворке.
 * Предоставляет общую функциональность для всех страниц, включая навигацию, обновление и базовые элементы.
 * <p>
 * Реализует паттерн "Page Object Model" (POM) для структурирования автоматизированных тестов.
// * @param <T> Тип конкретной страницы-наследника
 */
abstract public class BasePage {
    private static final String BASE_ELEMENT_XPATH="//div[contains(@name,'%s')]";
    /**
     * Базовый элемент страницы, используемый для проверки загрузки страницы.
     * Определяется по XPath-шаблону, содержащему уникальный идентификатор страницы.
     */
    protected final SelenideElement basePage;
    /**
     * Класс конкретной страницы-наследника.
     * Используется для создания новых экземпляров страниц при навигации.
     */
    protected final Class<? extends BasePage> pageClass;
    /**
     * Конструктор базовой страницы.
     * Инициализирует базовый элемент страницы и сохраняет класс страницы для дальнейшего использования.
     *
     * @param pageClass  Класс конкретной страницы-наследника
     * @param type       Уникальный идентификатор страницы для подстановки в XPath-шаблон
     */
    protected BasePage(Class<? extends BasePage> pageClass, String type){
        basePage = $x(String.format(BASE_ELEMENT_XPATH, type));
        this.pageClass=pageClass;
    }
    /**
     * Обновляет текущую страницу и возвращает новый экземпляр текущей страницы.
     * Выполняет следующие действия:
     * 1. Обновление страницы через Selenide.refresh()
     * 2. Создание нового экземпляра страницы того же типа
     *
     * @param pageClass  Класс страницы, которую нужно вернуть после обновления
     * @return Новый экземпляр обновленной страницы
     */
    public <T extends BasePage>T refresh(Class<T> pageClass){
        Selenide.refresh();
        return page(pageClass);
    }
    /**
     * Создает новый экземпляр указанной страницы.
     * Использует рефлексию для создания экземпляра класса страницы через конструктор по умолчанию.
     *
     * @param pageClass  Класс страницы, которую нужно создать
     * @return Новый экземпляр запрошенной страницы
     * @throws RuntimeException если создание экземпляра не удалось
     */
    public <T extends BasePage>T page(Class<T> pageClass){
        try{
            return pageClass.getDeclaredConstructor().newInstance();
        }  catch (Exception e){
            throw new RuntimeException("Failed to create page instance for " + pageClass.getSimpleName(), e);
        }
    }
}
