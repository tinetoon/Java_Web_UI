package HomeWork08.PageElements;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Базовый класс для бокового меню в ЛК с помощью библиотеки Selenide
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.12.2021
 */

public class SidebarMenuSelenide {

    // Лист элементов бокового меню
    private ElementsCollection menuList = $$(By
            .xpath("//div[@class=\"account_menu hide_mobile\"]//span[@class=\"account_menu__name\"]"));

    // Метод перехода в пункт меню
    public void goToSidebarMenuItem(int pageNumber) {
        menuList.get(pageNumber - 1).click();
    }

    // Метод выхода из учётной записи
    public void logout() {
        menuList.get(menuList.size() - 1).click();
    }

    // Геттер на лист меню
    public ElementsCollection getMenuList() {
        return menuList;
    }
}
