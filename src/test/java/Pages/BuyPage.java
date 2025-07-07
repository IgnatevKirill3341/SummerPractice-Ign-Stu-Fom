package Pages;

import Elements.Basis.ButtonElement;
import Elements.Basis.DivElement;
import Elements.Basis.HElement;
import Elements.Composite.DeliveryMethodElement;


/**
 * Класс, представляющий страницу корзины покупок (Buy Page) в веб-приложении.
 * Наследует функциональность от {@link BasePage} и предоставляет специфичные методы для работы со страницей корзины.
 * Содержит элементы и методы для проверки отображения страницы корзины.
 */
public class BuyPage extends BasePage {
    private final HElement pageName = HElement.byClass("basket-section__header active");
    private final ButtonElement openDeliveryMethod = ButtonElement.byClass("btn-edit basket-order__edit");
    private final DeliveryMethodElement deliveryMethodElement = DeliveryMethodElement.byClass("popup popup-choose-address shown", 0);
    private final DivElement divAddress = DivElement.byClass("b-delivery__address");
    /**
     * Конструктор страницы корзины.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public BuyPage(){
        super(MainPage.class, "//main");
    }

    /**
     * Открывает раздел выбора способа доставки.
     */
    public void openDeliveryMethod(){
        openDeliveryMethod.click();
    }

    /**
     * Открывает странницу выбора адреса доставки.
     * @param className Класс страницы избранного (FavoritesPage)
     * @return Экземпляр страницы избранного
     */
    public  <T extends BasePage> T addAddress(Class<T> className){
        deliveryMethodElement.addAddress();
        return page(className);
    }

    /**
     * Возвращает текущий адрес.
     * @return Текущий выбранный адрес.
     */
    public String getDeliveryAddress(){
        return divAddress.getText();
    }
    /**
     * Проверяет, отображается ли страница корзины.
     * Метод определяет видимость заголовка страницы корзины.
     *
     * @return {@code true} если заголовок страницы видим, {@code false} в противном случае
     */
    public boolean isDisplayed(){
        return pageName.isDisplayed();
    }
}
