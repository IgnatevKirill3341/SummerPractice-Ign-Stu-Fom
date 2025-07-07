package Pages;

import Elements.Basis.AElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.InputElement;
import Elements.Composite.CardElement;
import Elements.Composite.LoadingElement;
import Elements.Composite.SearchElement;
import com.codeborne.selenide.Selenide;
import io.github.cdimascio.dotenv.Dotenv;


import utils.GetNoty;
/**
 * Класс, представляющий главную страницу веб-приложения.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для взаимодействия со всеми основными элементами главной страницы.
 * Инкапсулирует:
 *   Поисковую систему
 *   Карточки товаров
 *   Индикатор загрузки
 *   Систему авторизации
 *   Рекламные элементы
 * Содержит бизнес-логику для основных сценариев использования главной страницы.
 */
public class MainPage extends BasePage {

    private final static int loginInputCount = 6;
    // Элементы страницы
    private final SearchElement searchElement = SearchElement.byClass("search-catalog__block search-catalog--active");
    private final CardElement cardElement = CardElement.byClass("product-card j-product-item j-analitics-item   ");
    private final LoadingElement loadingElement = LoadingElement.byClass("general-preloader");
    private final AElement loginHyperlink = AElement.byClass("navbar-pc__link j-main-login j-wba-header-item");
    private final InputElement phoneNumber = InputElement.byInputMode("tel");
    private final ButtonElement sendCode = ButtonElement.byId("requestCode");
    private final ButtonElement closeAdvertisement = ButtonElement.byClass("_close_1b9nk_55 popup__close close");
    /**
     * Конструктор главной страницы.
     * Выполняет:
     * 1. Открытие указанного URL
     * 2. Инициализацию базового элемента страницы (тег {@code <main>})
     * 3. Передачу контекста текущего класса в базовый конструктор
     *
     * @param url URL главной страницы
     */
    public MainPage(String url){
        super(MainPage.class, "//main");
        Selenide.open(url);
    }
    /**
     * Проверяет, отображаются ли карточки товаров на странице.
     * Используется для подтверждения успешной загрузки главной страницы.
     */
    public boolean isDisplayed(){
        return cardElement.isDisplayed();
    }
    /**
     * Вводит поисковый запрос в поисковую систему.
     *
     * @param request Текст поискового запроса
     */
    public void insertSearchRequest(String request){
        searchElement.insertRequest(request);
    }
    /**
     * Активирует поиск путем клика по кнопке поиска.
     */
    public void clickOnSearchButton(){
        searchElement.pressSearchButton();
    }
    /**
     * Ожидает завершения загрузки контента.
     * Блокирует выполнение до исчезновения индикатора загрузки.
     */
    public void waitUntilLoad(){loadingElement.waitUntilLoad();}
    /**
     * Удаляет оверлейное наложение (если присутствует).
     * Используется, когда оверлей блокирует взаимодействие с элементами.
     */
    public void deleteOverlay(){searchElement.deleteOverlay();}
    /**
     * Удаляет элемент автодополнения (если присутствует).
     * Используется, когда автодополнение мешает дальнейшим действиям.
     */
    public void deleteAutocomplete(){searchElement.autocompleteDelete();}
    /**
     * Открывает новую страницу приложения.
     * Использует механизм навигации базовой страницы для создания экземпляра указанной страницы.
     *
     * @param className Класс страницы, которую нужно открыть
     * @return Экземпляр запрошенной страницы
     */
    public <T extends BasePage> T openNewPage(Class<T> className){
        return page(className);
    }

    /**
     * Выполняет процесс авторизации пользователя.
     * Шаги авторизации:
     *   Клик по ссылке авторизации
     *   Ожидание загрузки формы
     *   Ввод номера телефона из .env файла
     *   Запрос SMS-кода
     *   Получение кода через утилиту GetNoty
     *   Ввод кода в соответствующие поля
     * Требует наличия файла .env с переменной PHONE_TO_LOG_IN в директории src/test/java/
     */

    public void login(){
        Dotenv dotenv = Dotenv.configure().directory("./src/test/java/").load();
        loginHyperlink.click();

        waitUntilLoad();
        phoneNumber.setValue(dotenv.get("PHONE_TO_LOG_IN_1"));
        sendCode.click();
        StringBuilder code = GetNoty.getNoty();

        for (int i = 0; i < loginInputCount; i++){
            InputElement codeInput = InputElement.byClass("char-input__item j-b-charinput", i);
            codeInput.setValue(String.valueOf(code.charAt(i)));
        }
    }
    /**
     * Закрывает рекламное объявление (если присутствует).
     * Используется для устранения блокирующих рекламных элементов.
     */
    public void closeAdvertisement(){
        closeAdvertisement.click();
    }

}
