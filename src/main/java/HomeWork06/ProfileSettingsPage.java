package HomeWork06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Базовый класс для страницы "Настройки профиля"
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 14.12.2021
 */

public class ProfileSettingsPage extends BaseClassForPages {

    // Объект меню
    SidebarMenu sidebarMenu;

    // Наименование страницы "Редактирование профиля"
    @FindBy(xpath = "//h1[@class=\"simple_page__name\"]")
    private WebElement h1PageName;

    // Поле "Компания"
    @FindBy(name = "Company")
    public WebElement fieldCompany;

    // Поле "Должность"
    @FindBy(name = "Position")
    public WebElement fieldPosition;

    // Конструктор класса
    public ProfileSettingsPage(ChromeDriver webDriver) {
        super(webDriver);
        sidebarMenu = new SidebarMenu(webDriver);
    }

    // Метод заполнения поля "Компания"
    public void fillCompany(String companyName) {
        fieldCompany.clear();
        fieldCompany.sendKeys(companyName);
        fieldCompany.submit();
    }

    // Метод заполнения поля "Должность"
    public void fillPosition(String positionName) {
        fieldPosition.clear();
        fieldPosition.sendKeys(positionName);
        fieldPosition.submit();
    }

    // Геттер наименования страницы
    public String getPageName() {
        return h1PageName.getText();
    }
}
