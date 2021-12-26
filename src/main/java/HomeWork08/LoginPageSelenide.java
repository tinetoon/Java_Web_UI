package HomeWork08;

import HomeWork08.PersonalAccountPages.Page_04_Profile_Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Базовый класс для страницы авторизации с помощью библиотеки Selenide
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.12.2021
 */

public class LoginPageSelenide {

    // Заголовок "Вход в личный кабинет"
    private SelenideElement h1Heading = $(By.xpath("//h1[@class=\"lk_popup__name\"]"));

    // Поле ввода "E-mail"
    private SelenideElement inputEmail = $(By.id("email"));

    // Поле ввода "Пароль"
    private SelenideElement inputPassword = $(By.id("password"));

    // Кнопка "Войти"
    private SelenideElement buttonEntry = $(By.xpath("//button[@type=\"submit\"]"));

    // Уведомление "Заполните e-mail"
    private SelenideElement labelEmailError = $(By.id("email-error"));

    // Уведомление "Заполните пароль"
    private SelenideElement labelPasswordError = $(By.id("password-error"));

    // Метод заполнения поля "E-mail"
    @Step("Выполняем заполнение поля \"E-mail\"") // Добавляем в отчёт информацию с помощью Assertj
    public LoginPageSelenide fillEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    // Метод заполнения поля "Пароль"
    @Step("Выполняем заполнение поля \"Пароль\"") // Добавляем в отчёт информацию с помощью Assertj
    public LoginPageSelenide fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    // Метод клика на кнопку "Войти"
    @Step("Кликаем по кнопке \"Войти\"")
    public void clickToButtonEnter() {
        buttonEntry.click();
    }

    // Метод входа в ЛК
    public Page_04_Profile_Selenide loginToYourAccount(String email, String password) {
        fillEmail(email).fillPassword(password).clickToButtonEnter();
        return page(Page_04_Profile_Selenide.class); // Возвращает страницу "Мой профиль"
    }

    // Геттеры на уведомления
    public WebElement getLabelEmailError() {
        return labelEmailError;
    }
    public WebElement getLabelPasswordError() {
        return labelPasswordError;
    }
}
