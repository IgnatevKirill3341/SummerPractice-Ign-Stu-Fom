package Elements.Composite;

import Base.BaseElement;
import Elements.Basis.HTwoElement;


public class RecommendedProductsElement extends BaseElement {
    private final static String CLASS_XPATH = "//div[@class='%s']";
    private final static String HEADING_CLASS = "goods-slider__header section-header";
    private final static String CARD_CLASS = "product-card__wrapper";
    private final HTwoElement hTwoElement = HTwoElement.byClass(HEADING_CLASS, 0);
    private final CardElement card = CardElement.byClass(CARD_CLASS);
    public RecommendedProductsElement(String xpathTemplate, String attributeValue){
        super(xpathTemplate, attributeValue);
    }
    public boolean hTwoIsVisible(){
        hTwoElement.scroll();
        return hTwoElement.isDisplayed();
    }
    public boolean cardIsVisible(){
        return card.isDisplayed();
    }
    public void goToProduct(){
        card.goToProduct();
    }
    public static RecommendedProductsElement byClass(String attributes){
        return new RecommendedProductsElement(CLASS_XPATH, attributes);
    }
}
