package HomeWork08.PersonalAccountPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Базовый класс для страницы "Мой профиль" с помощью библиотеки Selenide
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.12.2021
 */

public class Page_04_Profile_Selenide {

    // Заголовок "Имя пользователя"
    private SelenideElement h1Username = $(By.xpath("//h1[@class=\"simple_page__name\"]"));

    // Поле "Компания:"
    private SelenideElement spanCompanyName = $(By.xpath("//p[contains(., 'Компания')]/span"));

    // Поле "Должность:"
    private SelenideElement spanPositionName = $(By.xpath("//p[contains(., 'Должность')]/span"));

    // Геттеры на поля Класса
    public String getUsername() {
        return h1Username.getText();
    }
    public String getCompanyName() {
        return spanCompanyName.getText();
    }
    public String getPositionName() {
        return spanPositionName.getText();
    }
}
