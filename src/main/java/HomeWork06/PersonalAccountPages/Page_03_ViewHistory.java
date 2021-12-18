package HomeWork06.PersonalAccountPages;

import HomeWork06.BaseClassForPages;
import HomeWork06.PageElements.SidebarMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Базовый класс для страницы "История чтения"
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 17.12.2021
 */

public class Page_03_ViewHistory extends BaseClassForPages {

    // Объект меню
    private SidebarMenu sidebarMenu;

    // Наименование страницы "Редактирование профиля"
    @FindBy(xpath = "//h1[@class=\"simple_page__name\"]")
    private WebElement h1PageName;

    // Конструктор класса
    public Page_03_ViewHistory(ChromeDriver webDriver) {
        super(webDriver);
        sidebarMenu = new SidebarMenu(webDriver);
    }

    // Геттер наименования страницы
    public String getPageName() {
        return h1PageName.getText();
    }

    public SidebarMenu getSidebarMenu() {
        return sidebarMenu;
    }
}
