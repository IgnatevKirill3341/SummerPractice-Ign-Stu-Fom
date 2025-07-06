package Pages;

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
    private final ReviewElement review = ReviewElement.byClass("feedback__content");
    private final FeedBackFormElement form = FeedBackFormElement.byClass("popup popup-complain-feedback shown", 0);
    private final DivElement divElement = DivElement.byClass("action-notification show");
    /**
     * Конструктор страницы отзывов.
     *
     * @see BasePage#BasePage(Class, String)
     */
    public ReviewPage(){
        super(MainPage.class, "//main");
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
