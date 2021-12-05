package HomeWork03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 25.11.2021
 */

public class CrmProjectCreation {

    public static void main(String[] args) throws InterruptedException {

        // Инициализируем драйвер менеджер
        WebDriverManager.chromedriver().setup();

        // Создаём экземпляр класса webdriver
        WebDriver webDriver = new ChromeDriver();

        // Откроем сайт CRM
        webDriver.get("https://crm.geekbrains.space/user/login");

        // Выполняем авторизацию на сайте CRM
        login(webDriver);

        // Устанавливаем паузу 5 секунд
        Thread.sleep(5000);

        // Переходим на страницу "Мои проекты" (!!! исправить XPath)
        List<WebElement> mainMenuItems = getMenuItems(webDriver, "");
        WebElement expensesMenuItems = mainMenuItems
                .stream()
                .filter(e -> e.getText()
                        .equals("Проекты"))
                .findFirst().get();

        // Переходим на страницу "Мои проекты" (!!! исправить XPath)
        goTo(webDriver, expensesMenuItems, "");

        // Кликнем на кнопку "Создать проект"
        webDriver.findElement(By.xpath("//a[@title=\"Создать проект\"]")).click();

        // Заполняем поле "Имя проекта"
        webDriver.findElement(By.id("crm_project_name")).sendKeys("Project_DyuzhAA");

        // Раскрываем список организаций
        webDriver.findElement(By.xpath("//span[.='Укажите организацию']/ancestor::a")).click();

        // Ищем элемент списка My organization и выбираем найденный элемент
        webDriver.findElement(By.cssSelector(".select2-focused")).sendKeys("My organization");
        webDriver.findElement(By.xpath("//span[.='My organization']/..")).click();
        Thread.sleep(5000);

        //
        webDriver.findElement(By.cssSelector("#s2id_crm_project_contactMain-uid-61992970ee14b > .select2-choice")).click();

        // Находим нужный пункт меню (для примера)
        WebElement element = webDriver.findElement(By.xpath("//div[@id='select2-drop']"));
        goTo(webDriver, element, "");

        //
        webDriver.findElement(By.xpath("//div[contains(@id, 'select2-drop')]//*[text()='Иванов Иван']")).click();

        //
        Select businessUnit = new Select(webDriver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");

        //
        Select curator = new Select(webDriver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Марченко Николай");

        //
        Select rp = new Select(webDriver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText("Андреев Сергей");

        //
        Select administrator = new Select(webDriver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Королёва Елена");

        //
        Select manager = new Select(webDriver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Новиков Андрей");

        // Нажать на кнопку «Сохранить и закрыть»
        webDriver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);

        // Закрываем браузер
        webDriver.quit();

    }

    // Метод авторизации
    static void login(WebDriver driver) {

        // Создаём экземпляр класса (для примера)
        WebElement element = driver.findElement(By.id("prependedInput"));

        // Заполняем поле логин
        element.sendKeys("Applanatest1");

        // Заполняем поле пароль
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");

        // Кликнем на кнопке Войти
        driver.findElement(By.id("_submit")).click();
    }

    // Метод поиска элементов меню
    static List<WebElement> getMenuItems(WebDriver driver, String xpath) {
        List<WebElement> menuItems = driver.findElements(By.xpath(xpath));
        return menuItems;
    }

    // Метод перехода на страницу
    static void goTo(WebDriver driver, WebElement elementHover, String xpathClick) {

        // Создаём экземпляр класса (для примера)
        Actions action = new Actions(driver);

        // Наведём курсор мыши на нужный пункт меню
        action.moveToElement(elementHover).build().perform();

        // Выберем нужный пункт меню
        driver.findElement(By.xpath(xpathClick)).click();

    }
}
