package Tests;

import Pages.MainPage;
import Pages.ProductPage;
import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;

/**
 * Абстрактный базовый класс для всех тестов в проекте.
 * Предоставляет общие настройки, методы инициализации и завершения работы,
 * а также вспомогательные методы для выполнения стандартных действий.
 * 
 * Содержит:
 * 
 *   Общие конфигурации браузера
 *   Методы жизненного цикла тестов (before/after)
 *   Стандартные рабочие процессы (старт приложения, поиск товаров)
 *   Обработку общих исключений
 * 
 */
abstract public class BaseTest {
    /**
     * Базовый URL тестируемого приложения (Wildberries).
     */
    protected final String BASE_URL = "https://www.wildberries.ru/";
    /**
     * Стандартный артикул товара для тестирования.
     */
    protected final String ARTICLE = "386427060";
    /**
     * Настраивает окружение перед запуском тестов.
     * 
     * Выполняет:
     * 
     *   Установку драйвера для Firefox через WebDriverManager
     *   Указание браузера для Selenide
     *   Установку размера окна браузера
     *   Отключение headless-режима
     * 
     */
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        Configuration.browser="firefox";
        Configuration.browserSize="1920x1080";
        Configuration.headless=false;
    }
    /**
     * Запускает приложение и выполняет стандартную инициализацию.
     * 
     * Шаги:
     * 
     *   Открывает главную страницу
     *   Проверяет загрузку страницы
     *   Выполняет авторизацию
     *   Пытается закрыть рекламное объявление (если присутствует)
     *   Повторно проверяет загрузку страницы
     * 
     *
     * @return Экземпляр главной страницы приложения
     */
    protected MainPage start(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.isDisplayed();
        mainPage.login();
        try {
            mainPage.closeAdvertisement();
        } catch (ElementNotFound | NoSuchElementException ignored){

        }
        mainPage.isDisplayed();
        return mainPage;
    }
    /**
     * Получает страницу товара по стандартному артикулу.
     * 
     * Выполняет поиск товара и переходит на его страницу.
     *
     * @return Экземпляр страницы товара
     */
    protected ProductPage getProductPage(){
        return search(ARTICLE).openNewPage(ProductPage.class);
    }
    /**
     * Выполняет поиск товара по указанному запросу.
     * 
     * Шаги:
     * 
     *   Запускает приложение (start)
     *   Вводит поисковый запрос
     *   Активирует поиск
     *   Ожидает завершения загрузки
     *   Удаляет возможные оверлеи
     * 
     *
     * @param request  Поисковый запрос (артикул или название товара)
     * @return Экземпляр главной страницы после выполнения поиска
     */
    protected MainPage search(String request){
        MainPage mainPage = start();
        mainPage.insertSearchRequest(request);
        mainPage.clickOnSearchButton();
        mainPage.waitUntilLoad();
        mainPage.deleteOverlay();
        return mainPage;
    }
    /**
     * Метод, выполняемый перед каждым тестом (аннотация JUnit @Before).
     * 
     * Инициализирует тестовое окружение через метод setUp().
     */
    @Before
    public void init(){
        setUp();
    }
    /**
     * Метод, выполняемый после каждого теста (аннотация JUnit @After).
     * 
     * Закрывает веб-драйвер и очищает ресурсы.
     */
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
