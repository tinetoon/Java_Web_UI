Feature: Авторизация на сайте

  Background:
    Given Главная страница kommersant.ru доступна

  Scenario:
    Given Я нахожусь на странице авторизации
    When Я заполняю поле "E-mail" "tinetoon@mail.ru"
    And Заполняю поле "Пароль" "te$st"
    And Кликаю по кнопке "Войти"
    Then Я вижу имя пользователя "qr"