package Pages;

import Elements.Composite.ProductInCartElement;
/**
 * Класс, представляющий страницу корзины покупок в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет методы для управления товарами в корзине.
 * Инкапсулирует взаимодействие с элементами товаров через композитный {@link ProductInCartElement}.
 */
public class CartPage extends BasePage {
    /**
     * Элемент товара в корзине, используемый для управления конкретным товаром.
     * Инициализируется по классу CSS-контейнера товара.
     */
    private final ProductInCartElement productInCartElement = ProductInCartElement.byClass("list-item__wrap");
    /**
     * Конструктор страницы корзины.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public CartPage(){
        super(MainPage.class, "//main");
    }
    /**
     * Увеличивает количество первого товара в корзине на одну единицу.
     */
    public void increaseProductCount(){
        productInCartElement.increaseProductCount();
    }
    /**
     * Уменьшает количество первого товара в корзине на одну единицу.
     * Если количество достигнет 1, дальнейшее уменьшение может быть заблокировано.
     */
    public void decreaseProductCount(){
        productInCartElement.decreaseProductCount();
    }
    /**
     * Удаляет первый товар из корзины.
     */
    public void deleteProduct(){
        productInCartElement.deleteProduct();
    }
    /**
     * Получает текущее количество первого товара в корзине.
     *
     * @return Количество товара в виде строки
     */
    public String getProductCount(){
        return productInCartElement.getProductCount();
    }
    /**
     * Проверяет, отображается ли хотя бы один товар в корзине.
     *
     * @return {@code true} если товар отображается, {@code false} если корзина пуста
     */
    public boolean isProductInCart(){
        return productInCartElement.isDisplayed();
    }
}
