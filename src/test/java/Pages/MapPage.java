package Pages;

import Base.BasePage;
import Elements.Basis.ButtonElement;
import Elements.Basis.SpanElement;
import Elements.Composite.MapSearchElement;
/**
 * Страница с картой для выбора и подтверждения адреса.
 * Наследуется от {@link BasePage} и предоставляет методы для поиска,
 * выбора и подтверждения адреса на карте.
 */
public class MapPage extends BasePage {
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String CONFIRM_ADDRESS_BUTTON = "details-self__btn btn-main";
    private final static String DESTINATION_ADDRESS_CLASS = "address-item__name-text";
    private final static String MAP_SEARCH_CLASS = "map-search__input-wrapper";
    private final ButtonElement confirmButton = ButtonElement.byClass(CONFIRM_ADDRESS_BUTTON);
    private final SpanElement destinationAddress = SpanElement.byClass(DESTINATION_ADDRESS_CLASS);
    private final MapSearchElement mapSearchElement = MapSearchElement.byClass(MAP_SEARCH_CLASS);
    /**
     * Конструктор страницы карты.
     * Устанавливает родительскую страницу для навигации и локатор корневого элемента.
     */
    public MapPage(){
        super(MainPage.class, MAIN_TAG_XPATH);
    }
    /**
     * Вводит строку адреса в поле поиска на карте.
     *
     * @param address Строка адреса для поиска
     */
    public void setAddress(String address){
        mapSearchElement.setAddress(address);
    }
    /**
     * Запускает поиск адреса, уже введённого в поле.
     */
    public void searchAddress(){
        mapSearchElement.findAddress();
    }
    /**
     * Выбирает найденный адрес, кликнув по элементу с текстом адреса.
     */
    public void selectAddress(){
        destinationAddress.click();
    }
    /**
     * Подтверждает выбранный адрес и переходит на указанную страницу.
     *
     * @param <T>       Тип страницы, на которую будет выполнен переход после подтверждения
     * @param className Класс страницы, на которую нужно перейти
     * @return Экземпляр страницы указанного класса
     */
    public <T extends BasePage> T confirmAddress(Class<T> className){
        confirmButton.click();
        return page(className);
    }

}
