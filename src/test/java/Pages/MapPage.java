package Pages;

import Elements.Basis.ButtonElement;
import Elements.Basis.SpanElement;
import Elements.Composite.MapSearchElement;
/**
 * Страница с картой для выбора и подтверждения адреса.
 * Наследуется от {@link BasePage} и предоставляет методы для поиска,
 * выбора и подтверждения адреса на карте.
 */
public class MapPage extends BasePage {

    private final ButtonElement confirmButton = ButtonElement.byClass("details-self__btn btn-main");
    private final SpanElement destinationAddress = SpanElement.byClass("address-item__name-text");
    private final MapSearchElement mapSearchElement = MapSearchElement.byClass("map-search__input-wrapper");
    /**
     * Конструктор страницы карты.
     * Устанавливает родительскую страницу для навигации и локатор корневого элемента.
     */
    public MapPage(){
        super(MainPage.class, "//main");
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
     * Возвращает найденный адрес.
     * @return Найденный адрес.
     */
    public String getAddress(){
        return destinationAddress.getText();
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
