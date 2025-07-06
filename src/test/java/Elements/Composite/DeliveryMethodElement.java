package Elements.Composite;

import Base.BaseElement;
import Elements.Basis.ButtonElement;

public class DeliveryMethodElement extends BaseElement {
    private final static String CLASS_XPATH = "//div[@class='%s']";
    private final static String ADD_ADDRESS_AREA_LABEL = "Добавить пункт выдачи или адрес";
    private final ButtonElement addAddress = ButtonElement.byAriaLabel(ADD_ADDRESS_AREA_LABEL, 0);
    public DeliveryMethodElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    public DeliveryMethodElement(String xpathTemplate, String attributeValue, int index){
        super(xpathTemplate, attributeValue, index);
    }
    public void addAddress(){
        addAddress.click();
    }
    public static DeliveryMethodElement byClass(String attribute, int index){
        return new DeliveryMethodElement(CLASS_XPATH, attribute, index);
    }
}
