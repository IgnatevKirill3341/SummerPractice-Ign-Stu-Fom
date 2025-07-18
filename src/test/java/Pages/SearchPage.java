package Pages;

import Elements.Composite.CardElement;
import Elements.Composite.DropDownMenuElement;
/**
 * Класс, представляющий страницу результатов поиска в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для взаимодействия с результатами поиска.
 * Инкапсулирует:
 *   Выпадающее меню сортировки
 *   Карточки товаров в результатах поиска
 * Содержит методы для управления сортировкой и сбора рейтингов товаров.
 */
public class SearchPage extends BasePage {
    /**
     * Элемент выпадающего меню для сортировки результатов поиска.
     */
    private final DropDownMenuElement dropDownMenu = DropDownMenuElement.byClass("dropdown-filter__btn-name");
    /**
     * Количество товаров, для которых нужно собрать рейтинги.
     */
    private final static int countElementsToAdd = 20;
    /**
     * Конструктор страницы результатов поиска.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public SearchPage(){
        super(MainPage.class, "//main");
    }
    /**
     * Открывает выпадающее меню сортировки результатов поиска.
     */
    public void openDropdown(){
        dropDownMenu.openDropDownMenu();
    }
    /**
     * Выбирает вариант сортировки в выпадающем меню.
     * В текущей реализации выбирает предопределенный вариант (обычно "По рейтингу").
     * Перед использованием этого метода необходимо открыть меню с помощью {@link #openDropdown()}.
     */
    public void chooseFilter(){
        dropDownMenu.chooseDropDownVariant();
    }
    /**
     * Собирает рейтинги для первых N товаров в результатах поиска.
     * Получает числовые значения рейтингов для указанного количества товаров (по умолчанию 20).
     *
     * @return Массив значений рейтингов в порядке следования товаров на странице
     */
    public float[] getRatings(){
        float[] float_ratings = new float[countElementsToAdd];
        for (int i = 0; i<countElementsToAdd; i++){
            CardElement card = CardElement.byClass("product-card__wrapper", i);
            float_ratings[i]= card.getRating();
        }
        return float_ratings;
    }
}
