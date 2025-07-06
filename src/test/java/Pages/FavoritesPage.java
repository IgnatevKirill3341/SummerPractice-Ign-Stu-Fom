package Pages;

import Base.BasePage;
import Elements.Composite.ProductInFavoritesElement;
/**
 * Класс, представляющий страницу избранного в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для работы с избранными товарами.
 * Использует композитный элемент {@link ProductInFavoritesElement} для взаимодействия с товарами в разделе избранного.
 */
public class FavoritesPage extends BasePage {
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String PRODUCT_IN_FAVORITES_CLASS = "goods-card__container";
    /**
     * Элемент товара в разделе избранного.
     * Используется для проверки наличия и взаимодействия с товарами.
     */
    private final ProductInFavoritesElement product = ProductInFavoritesElement.byClass(PRODUCT_IN_FAVORITES_CLASS);
    /**
     * Конструктор страницы избранного.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public FavoritesPage(){
        super(MainPage.class, MAIN_TAG_XPATH);
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
