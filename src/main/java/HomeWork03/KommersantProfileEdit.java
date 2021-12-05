package HomeWork03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 04.12.2021
 */

public class KommersantProfileEdit {

    public static void main(String[] args) {

        // Инициализируем драйвер менеджер
        WebDriverManager.chromedriver().setup();

        // Создаём экземпляр класса ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        // Передаём в объект chromeOptions настройки для браузера
        // --no-sandbox - для работы в докер-контейнере для Chrome
        // --disable-notification - отключение всплывающих окон
        // user-agent=Googlebot/2.1 (+http://www.google.com/bot.html) - запуск в режиме поискового бота
        // --incognito - запуск окна в режиме инкогнито
        chromeOptions
                .addArguments("--no-sandbox")
                .addArguments("--disable-notification")
                .addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)")
                .addArguments("--incognito");

        // Создаём экземпляр класса webdriver
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        // Открываем страницу авторизации на сайте kommersant.ru
        webDriver.get("https://www.kommersant.ru/lk/login");

        // Заполняем поля "Ваш e-mail" и "Введите пароль"
        webDriver.findElement(By.id("email")).sendKeys("tinetoon@mail.ru");
        webDriver.findElement(By.id("password")).sendKeys("te$st");

        // Кликнем на кнопку "Войти"
        webDriver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//a[.='Мои настройки']")));

        // Переходим к настройкам профиля
        webDriver.findElement(By.xpath("//a[.='Мои настройки']")).click();

        // Ищем поля "Компания", "Должность"
        WebElement fieldCompany = webDriver.findElement(By.name("Company"));
        WebElement fieldPosition = webDriver.findElement(By.name("Position"));
        WebElement fieldPhone = webDriver.findElement(By.name("Phone"));

        // Очищаем поля, заполняем новыми значениями и сохраняем
        fieldCompany.clear();
        fieldCompany.sendKeys("АО \"МЭС\"");

        fieldPosition.clear();
        fieldPosition.sendKeys("Начальник ПТО");
        fieldPosition.submit();

        // Перейдём на страницу "Личный кабинет" и убедимся, что поля "Компания" и "Должность" изменились
        webDriver.findElement(By.xpath("//a[.='Личный кабинет']")).click();

        // Устанавливаем паузу 10 секунд
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрываем браузер
        webDriver.quit();
    }
}
