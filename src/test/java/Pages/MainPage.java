/**
 * Главная страница сайта Ozon
 */
package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement searchBoxInput = $x("//input[@id='searchInput']");
    private final SelenideElement buttonSearch = $x("//button[@id='applySearchBtn']");
    private final SelenideElement loginButton = $x("//a[@class='navbar-pc__link j-main-login j-wba-header-item']");
    private final SelenideElement phoneNumber = $x("//input[@inputmode='tel']");
    private final SelenideElement sendCode = $x("//button[@id='requestCode']");
    private final ElementsCollection codeInput = $$x("//input[@class='char-input__item j-b-charinput']");
    private final ElementsCollection profileButton = $$x("//a[@class='navbar-pc__link j-wba-header-item']");
    private final SelenideElement closeAdvertisment = $x("//button[@class='_close_1b9nk_55 popup__close close']");
    public MainPage(String url){
        Selenide.open(url);
        $x("//div[@class='product-card__wrapper']").should(Condition.appear);
    }

    public ProductPage search(String art){
        searchBoxInput.setValue(art);
        buttonSearch.click();

        return new ProductPage();
    }
    public StringBuilder getNoty(){
        StringBuilder code = new StringBuilder();
        try {
            // Создаем процесс с правильными аргументами
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "dbus-monitor",
                    "interface='org.freedesktop.Notifications',member='Notify'"
            );

            // Объединяем стандартный вывод и ошибки
            processBuilder.redirectErrorStream(true);

            // Запускаем процесс
            Process process = processBuilder.start();

            Pattern pattern = Pattern.compile("\\s*(\\d+) — никому его не говорите");

            // Поток для чтения вывода в реальном времени
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream())
                )) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("string \"")) {
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                code.append(matcher.group(1)); // Извлекаем цифры из первой группы
                                process.destroy();
                            }

                        }
                    }
                } catch (Exception e) {

                }
            }).start();

            // Ожидаем завершения с таймаутом (для длительных процессов)
            process.waitFor(5, TimeUnit.MINUTES);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    public void login(){
        loginButton.click();
        Dotenv dotenv = Dotenv.configure().directory("./src/test/java/").load();
        phoneNumber.setValue(dotenv.get("PHONE_TO_LOG_IN"));
        sendCode.click();
        StringBuilder code = getNoty();
        for (int i = 0; i < 6; i++){
            codeInput.get(i).setValue(String.valueOf(code.charAt(i)));
        }
        profileButton.get(2).shouldHave(Condition.text("Профиль"), Duration.ofSeconds(10));
        closeAdvertisment.click();
    }
}
