package Pages;

import Base.BasePage;
import Elements.Basis.ButtonElement;
import Elements.Basis.SpanElement;
import Elements.Composite.MapSearchElement;

public class MapPage extends BasePage {
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String CONFIRM_ADDRESS_BUTTON = "details-self__btn btn-main";
    private final static String DESTINATION_ADDRESS_CLASS = "address-item__name-text";
    private final static String MAP_SEARCH_CLASS = "map-search__input-wrapper";
    private final ButtonElement confirmButton = ButtonElement.byClass(CONFIRM_ADDRESS_BUTTON);
    private final SpanElement destinationAddress = SpanElement.byClass(DESTINATION_ADDRESS_CLASS);
    private final MapSearchElement mapSearchElement = MapSearchElement.byClass(MAP_SEARCH_CLASS);
    public MapPage(){
        super(MainPage.class, MAIN_TAG_XPATH);
    }
    public void setAddress(String address){
        mapSearchElement.setAddress(address);
    }
    public void searchAddress(){
        mapSearchElement.findAddress();
    }
    public void selectAddress(){
        destinationAddress.click();
    }
    public <T extends BasePage> T confirmAddress(Class<T> className){
        confirmButton.click();
        return page(className);
    }
}
