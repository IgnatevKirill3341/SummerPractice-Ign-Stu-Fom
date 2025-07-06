package Elements.Composite;

import Base.BaseElement;
import Base.BasePage;
import Elements.Basis.ButtonElement;
import Elements.Basis.InputElement;
import Elements.Basis.SpanElement;

public class MapSearchElement extends BaseElement {
    private static final String CLASS_XPATH = "//div[@class='%s']";
    private static final String MAP_SEARCH_INPUT = "map-search__input";
    private static final String MAP_SEARCH_BUTTON = "map-search__confirm-btn";
    private final InputElement mapSearchInput = InputElement.byClass(MAP_SEARCH_INPUT);
    private final ButtonElement mapSearchButton = ButtonElement.byClass(MAP_SEARCH_BUTTON);
    public MapSearchElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    public void setAddress(String address){
        mapSearchInput.setValue(address);
    }
    public void findAddress(){
        mapSearchButton.click();
    }

    public static MapSearchElement byClass(String attribute){
        return new MapSearchElement(CLASS_XPATH, attribute);
    }
}
