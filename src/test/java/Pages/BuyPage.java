package Pages;

import Base.BasePage;
import Base.BaseTest;
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
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String PAGE_NAME_CLASS = "basket-section__header active";
    private final static String EDIT_ADDRESS_BUTTON = "btn-edit basket-order__edit";
    private final static String DELIVERY_METHOD_CLASS = "popup popup-choose-address shown";
    private final static String DIV_ADDRESS_CLASS = "b-delivery__address";
    /**
     * Элемент заголовка страницы корзины.
     * Используется для проверки успешной загрузки страницы.
     */
    private final HElement pageName = HElement.byClass(PAGE_NAME_CLASS);
    /**
     * Кнопка изменения и добавления адреса доставки.
     * Используется для изменения адреса доставки.
     */
    private final ButtonElement openDeliveryMethod = ButtonElement.byClass(EDIT_ADDRESS_BUTTON);
    private final DeliveryMethodElement deliveryMethodElement = DeliveryMethodElement.byClass(DELIVERY_METHOD_CLASS, 0);
    private final DivElement divAddress = DivElement.byClass(DIV_ADDRESS_CLASS);
    /**
     * Конструктор страницы корзины.
     * Инициализирует страницу, передавая в базовый класс:
     * - Класс главной страницы ({@link MainPage}) как контекст
     * - XPath основного тега страницы ({@code <main>}) как базовый элемент
     */
    public BuyPage(){
        super(MainPage.class, MAIN_TAG_XPATH);
    }
    public void openDeliveryMethod(){
        openDeliveryMethod.click();
    }
    public  <T extends BasePage> T addAddress(Class<T> className){
        deliveryMethodElement.addAddress();
        return page(className);
    }
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
