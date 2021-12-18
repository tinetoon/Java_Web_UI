package HomeWork06;

import HomeWork06.PersonalAccountPages.Page_04_Profile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Базовый класс для страницы авторизации
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 14.12.2021
 */

public class LoginPage extends BaseClassForPages {

    // Создаём конструктор
    public LoginPage(ChromeDriver webDriver) {
        super(webDriver);
    }

    // Создаём поля класса
    // Заголовок "Вход в личный кабинет"
    @FindBy(xpath = "//h1[@class=\"lk_popup__name\"]")
    public WebElement h1Heading;

    // Поле ввода "E-mail"
    @FindBy(id = "email")
    public WebElement inputEmail;

    // Поле ввода "Пароль"
    @FindBy(id = "password")
    public WebElement inputPassword;

    // Кнопка "Войти"
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement buttonEntry;

    // Уведомление "Заполните e-mail"
    @FindBy(id = "email-error")
    private WebElement labelEmailError;

    // Уведомление "Заполните пароль"
    @FindBy(id = "password-error")
    private WebElement labelPasswordError;

    // Метод заполнения поля "E-mail"
    public void fillEmail(String email) {
        inputEmail.sendKeys(email);
    }

    // Метод заполнения поля "Пароль"
    public void fillPassword(String password) {
        inputPassword.sendKeys(password);
    }

    // Метод входа в ЛК
    public Page_04_Profile loginToYourAccount(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        buttonEntry.click();
        return new Page_04_Profile(getWebDriver()); // Возвращает страницу "Мой профиль"
    }

    // Геттеры на уведомления
    public WebElement getLabelEmailError() {
        return labelEmailError;
    }
    public WebElement getLabelPasswordError() {
        return labelPasswordError;
    }
}
