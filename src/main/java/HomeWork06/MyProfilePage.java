package HomeWork06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Базовый класс для страницы "Мой профиль"
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 14.12.2021
 */

public class MyProfilePage extends BaseClassForPages {

    // Конструктор класса
    public MyProfilePage(ChromeDriver webDriver) {
        super(webDriver);
    }

    // Поля класса (!!! Уточнить необходимость приватности полей)
    // Заголовок "Имя пользователя"
    @FindBy(xpath = "//h1[@class=\"simple_page__name\"]")
    public WebElement h1Username;

    // Поле "Компания:"
    @FindBy(xpath = "//p[contains(., 'Компания')]/span")
    public WebElement spanCompanyName;

    // Поле "Должность:"
    @FindBy(xpath = "//p[contains(., 'Должность')]/span")
    public WebElement spanPositionName;

    // Метод возвращающий имя пользователя
    public String getUsername() {
        return h1Username.getText();
    }

    // Метод возвращающий наименование компании
    public String getCompanyName() {
        return spanCompanyName.getText();
    }

    // Метод возвращающий наименование должности
    public String getPositionName() {
        return spanPositionName.getText();
    }
}
