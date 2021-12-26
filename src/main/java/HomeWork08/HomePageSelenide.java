package HomeWork08;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Базовый класс для главной страницы kommersant.ru
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 26.12.2021
 */

public class HomePageSelenide {

    // Тайтл страницы
    private SelenideElement title = $(By.tagName("title"));

    public String getTitle() {
        return title.getText();
    }
}
