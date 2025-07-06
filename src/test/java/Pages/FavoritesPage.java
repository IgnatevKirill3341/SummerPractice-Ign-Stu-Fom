package Pages;

import Elements.Composite.ProductInFavoritesElement;
/**
 * Класс, представляющий страницу избранного в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для работы с избранными товарами.
 * Использует композитный элемент {@link ProductInFavoritesElement} для взаимодействия с товарами в разделе избранного.
 */
public class FavoritesPage extends BasePage {
    /**
     * Элемент товара в разделе избранного.
     * Используется для проверки наличия и взаимодействия с товарами.
     */
    private final ProductInFavoritesElement product = ProductInFavoritesElement.byClass("goods-card__container");
    /**
     * Конструктор страницы избранного.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public FavoritesPage(){
        super(MainPage.class, "//main");
    }
    /**
     * Проверяет, отображается ли хотя бы один товар в разделе избранного.
     * Метод использует проверку видимости элемента товара для определения наличия избранных товаров.
     *
     * @return {@code true} если товар отображается (избранное не пусто), {@code false} в противном случае
     */
    public boolean isDisplayed(){
        return product.isDisplayed();
    }
}
