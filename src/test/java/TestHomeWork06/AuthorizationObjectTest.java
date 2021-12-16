package TestHomeWork06;

import HomeWork06.LoginPage;
import HomeWork06.MyProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Класс для тестирования авторизации на сайте kommersant.ru с использованием паттерна Page Object
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.12.2021
 *
 * Предусловия: авторизация проверка доступности главной страницы сайта
 * Постусловия: выход из учётной записи, либо очистка cookie
 */

public class AuthorizationObjectTest {

    // Создаём экземпляр драйвера для возможности доступа к нему по всему классу
    private static ChromeDriver webDriver;

    // Создаём экземпляр ожиданий
    private static WebDriverWait webDriverWait;

    // Создаём экземпляр логера
    private static Logger logger = LoggerFactory.getLogger(AuthorizationObjectTest.class);

    @BeforeAll
    static void registerDriver() {

        // Инициализируем драйвер менеджер
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {

        // Создаём экземпляр класса ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        /* Передаём в объект chromeOptions настройки для браузера
        --no-sandbox - для работы в докер-контейнере для Chrome
        start-maximized - запуск окна "на весь экран"
        --disable-notification - отключение всплывающих окон
        user-agent=Googlebot/2.1 (+http://www.google.com/bot.html) - запуск в режиме поискового бота
        --incognito - запуск окна в режиме инкогнито
        .setPageLoadTimeout(Duration.ofSeconds(10)) - максимальное время ожидания загрузки страницы
         */
        chromeOptions
                .addArguments("--no-sandbox")
                .addArguments("start-maximized")
                .addArguments("--disable-notification")
                .addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)")
                .addArguments("--incognito")
                .setPageLoadTimeout(Duration.ofSeconds(10));

        // Создаём экземпляр класса webdriver
        webDriver = new ChromeDriver(chromeOptions);

        // Implicit Wait (Неявное ожидание) - выставляем 5 секунд (!!! обязательно определяем в коде)
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("01 Проверка доступности главной страницы")
    void homePageLoaded() {

        logger.info("\n[INFO] Проверка доступности главной страницы");

        Assertions
                .assertDoesNotThrow(()-> webDriver
                        .navigate()
                        .to("https://www.kommersant.ru/"), "Страница недоступна");
    }

    @Test
    @DisplayName("02 Проверка авторизации на сайте")
    void authorization() {

        logger.info("\n[INFO] Проверка авторизации в личном кабинете");
        logger.debug("\n[DEBUG] Проверяем видимость ссылки \"Личный кабинет\"");

        logger.debug("\n[DEBUG] Проверяем доступность страницы авторизации");
        Assertions
                .assertDoesNotThrow(()-> webDriver
                                .navigate()
                                .to("https://www.kommersant.ru/lk/login"),
                        "Страница авторизации недоступна");

        logger.debug("\n[DEBUG] Создаём экземпляр страницы авторизации");
        LoginPage loginPage = new LoginPage(webDriver);

        logger.info("\n[INFO] Переходим в личный кабинет");
        logger.debug("\n[DEBUG] Заполняем поля \"Ваш e-mail\" и \"Введите пароль\"" +
                "\n[DEBUG] Тестовые учётные данные: логин tinetoon@mail.ru, пароль te$st");
        MyProfilePage myProfilePage = loginPage.loginToYourAccount("tinetoon@mail.ru", "te$st");

        logger.debug("\n[DEBUG] Проверяем доступность страницы авторизации");
        Assertions.assertEquals(myProfilePage.getUsername(), "qr");
    }

    // Метод запускающийся после каждого теста
    @AfterEach
    void exitTheBrowser() {

        // Закрываем браузер
        webDriver.quit();
    }
}
