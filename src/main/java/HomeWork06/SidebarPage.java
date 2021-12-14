package HomeWork06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

    // Лист элементов бокового меню
    @FindBy(xpath = "//div[@class=\"account_menu hide_mobile\"]//span[@class=\"account_menu__name\"]")
    public List<WebElement> menuList;

    // Метод наведения курсора на пункт меню
    public void hoverMouseOnSidebarMenuItem(String itemName) {
        Actions actions = new Actions(getWebDriver());

        WebElement item = menuList
                .stream() // Поток элементов коллекции (листа)
                .filter(element -> element.getText().equals(itemName)) // Фильтр по названию элемента
                .findFirst() // Первый найденный элемент коллекции
                .get(); // возвращает найденный элемент

        actions
                .moveToElement(item) // (наведение мыши на найденный элемент (WebElement item)
                .build()
                .perform();
    }

    // Метод перехода в пункт меню
    public void goToSidebarMenuItem(String itemName) {

        WebElement item = menuList
                .stream() // Поток элементов коллекции (листа)
                .filter(element -> element.getText().equals(itemName)) // Фильтр по названию элемента
                .findFirst() // Первый найденный элемент коллекции
                .get(); // возвращает найденный элемент

        item.click();
    }
}
