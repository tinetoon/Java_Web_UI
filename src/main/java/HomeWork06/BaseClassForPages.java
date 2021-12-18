package HomeWork06;

import HomeWork06.PageElements.SidebarMenu;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Базовый класс для наследования остальными классами страниц
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 14.12.2021
 */

public abstract class BaseClassForPages {

    // Создаём экземпляр драйвера для возможности доступа к нему по всему классу (!!! приватность нужна или нет)
    private ChromeDriver webDriver;

    // Создаём конструктор
    public BaseClassForPages(ChromeDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public ChromeDriver getWebDriver() {
        return webDriver;
    }
}
