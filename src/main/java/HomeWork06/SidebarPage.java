package HomeWork06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Базовый класс для бокового меню в ЛК
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 14.12.2021
 */

public class SidebarPage extends BaseClassForPages {

    // Конструктор класса
    public SidebarPage(ChromeDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class=\"account_menu hide_mobile\"]//span[@class=\"account_menu__name\"]")
    public List<WebElement> menuList;
}
