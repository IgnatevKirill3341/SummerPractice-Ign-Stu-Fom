package Pages;

import Base.BasePage;
import Elements.Basis.AElement;
import Elements.Basis.ButtonElement;
import Elements.Basis.InputElement;
import Elements.Basis.SpanElement;
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
    private final static String SEARCH_DIV_CLASS = "search-catalog__block search-catalog--active";
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String CARD_DIV_CLASS = "product-card__wrapper";
    private final static String LOADING_DIV_CLASS = "general-preloader";
    private final static String A_LOGIN_HYPERLINK_LINK = "navbar-pc__link j-main-login j-wba-header-item";
    private final static String PHONE_NUMBER_INPUTMODE = "tel";
    private final static String BUTTON_SEND_CODE_ID = "requestCode";
    private final static String CODE_INPUTS_CLASS = "char-input__item j-b-charinput";
    private final static String SPAN_PROFILE_CLASS= "navbar-pc__icon navbar-pc__icon--profile";
    private final static String CLOSE_ADVERTISEMENT_BUTTON = "_close_1b9nk_55 popup__close close";
    private final static int loginInputCount = 6;
    // Элементы страницы
    private final SearchElement searchElement = SearchElement.byClass(SEARCH_DIV_CLASS);
    private final CardElement cardElement = CardElement.byClass(CARD_DIV_CLASS);
    private final LoadingElement loadingElement = LoadingElement.byClass(LOADING_DIV_CLASS);
    private final AElement loginHyperlink = AElement.byClass(A_LOGIN_HYPERLINK_LINK);
    private final InputElement phoneNumber = InputElement.byInputMode(PHONE_NUMBER_INPUTMODE);
    private final ButtonElement sendCode = ButtonElement.byId(BUTTON_SEND_CODE_ID);
    private final SpanElement profileHyperlink = SpanElement.byClass(SPAN_PROFILE_CLASS);
    private final ButtonElement closeAdvertisement = ButtonElement.byClass(CLOSE_ADVERTISEMENT_BUTTON);
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
        super(MainPage.class, MAIN_TAG_XPATH);
        Selenide.open(url);
    }
    /**
     * Проверяет, отображаются ли карточки товаров на странице.
     * Используется для подтверждения успешной загрузки главной страницы.
     */
    public void isDisplayed(){
         cardElement.isDisplayed();
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
        phoneNumber.setValue(dotenv.get("PHONE_TO_LOG_IN_2"));
        sendCode.click();
        StringBuilder code = GetNoty.getNoty();

        for (int i = 0; i < loginInputCount; i++){
            InputElement codeInput = InputElement.byClass(CODE_INPUTS_CLASS, i);
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
