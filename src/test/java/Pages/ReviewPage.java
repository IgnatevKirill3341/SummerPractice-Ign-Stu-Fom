package Pages;

import Base.BasePage;
import Elements.Basis.DivElement;
import Elements.Composite.FeedBackFormElement;
import Elements.Composite.ReviewElement;

/**
 * Страница отзывов о товаре в веб-приложении.
 * Наследуется от {@link BasePage} и предоставляет методы для
 * взаимодействия с отзывами и формой обратной связи.

 * Инкапсулирует:
 *   Просмотр и взаимодействие с отдельным отзывом
 *   Открытие и отправку формы обратной связи (жалобы/отзыва)
 *   Проверку появления уведомления после отправки формы

 */
public class ReviewPage extends BasePage {
    private final static String MAIN_TAG_XPATH = "//main";
    private final static String REVIEW_CLASS = "feedback__content";
    private final static String FORM_CLASS = "popup popup-complain-feedback shown";
    private final static String DIV_CLASS = "action-notification show";
    private final ReviewElement review = ReviewElement.byClass(REVIEW_CLASS);
    private final FeedBackFormElement form = FeedBackFormElement.byClass(FORM_CLASS, 0);
    private final DivElement divElement = DivElement.byClass(DIV_CLASS);
    /**
     * Конструктор страницы отзывов.
     *
     * @see BasePage#BasePage(Class, String)
     */
    public ReviewPage(){
        super(MainPage.class, MAIN_TAG_XPATH);
    }
    /**
     * Нажимает кнопку меню обратной связи внутри отзыва.
     */
    public void feedBack(){
        review.feedBackButton();
    }
    /**
     * Открывает форму обратной связи (жалобы/отзыва).
     */
    public void openForm(){
        review.openForm();
    }
    /**
     * Выбирает вариант ответа в форме обратной связи.
     */
    public void selectElement(){
        form.select();
    }
    /**
     * Отправляет форму обратной связи.
     */
    public void send(){
        form.send();
    }
    /**
     * Проверяет, появилось ли уведомление об отправке формы.
     *
     * @return {@code true}, если уведомление отображается на странице
     */
    public boolean isAppears(){
        return divElement.elementAppeared();
    }

}
