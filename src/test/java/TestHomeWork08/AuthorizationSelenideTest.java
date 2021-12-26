package TestHomeWork08;

import HomeWork08.HomePageSelenide;
import HomeWork08.LoginPageSelenide;
import HomeWork08.PersonalAccountPages.Page_04_Profile_Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестовый класс для страницы авторизации с помощью библиотеки Cucumber
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.12.2021
 */

public class AuthorizationSelenideTest {

    private HomePageSelenide homePage;
    private LoginPageSelenide loginPage;
    private Page_04_Profile_Selenide page_04_profile;
    private String userNameDefault = "qr"; // Имя пользователя по умолчанию

    @Given("Главная страница kommersant.ru доступна")
    public void homePageAvailable() {
//        open("https://www.kommersant.ru");
//        homePage = new HomePageSelenide();
//        assertEquals("Коммерсантъ: последние новости России и мира", homePage.getTitle());
        Assertions
                .assertDoesNotThrow(()->
                        open("https://www.kommersant.ru"),
                        "Главная страница недоступна");
    }

    @Given("Я нахожусь на странице авторизации")
    public void goToLogin() {
        open("https://www.kommersant.ru/lk/login");
        loginPage = new LoginPageSelenide();
    }

    @When("Я заполняю поле \"E-mail\" \"(.*)\"$")
    public void fillEmail(String login) {
        loginPage.fillEmail(login);
    }

    @And("Заполняю поле \"Пароль\" \"(.*)\"$")
    public void fillPassword(String password) {
        loginPage.fillPassword(password);
    }

    @And("Кликаю по кнопке \"Войти\"")
    public void clickToButton() {
        loginPage.clickToButtonEnter();
        page_04_profile = new Page_04_Profile_Selenide();
    }

    @Then("Я вижу имя пользователя \"(.*)\"$") // \“(.*)\”$
    public void iSeeUsername(String userName) {
//        assertEquals(userNameDefault, page_04_profile.getUsername()); // assertEquals(short expected(ожидаемый результат), short actual (актуальный возвращаемый))
        assertEquals(userName, page_04_profile.getUsername());
    }
}
