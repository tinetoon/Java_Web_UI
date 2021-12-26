package TestHomeWork08;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Тестовый класс для запуска тестов с помощью библиотеки Cucumber
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 26.12.2021
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                    "junit:target/cucumber-reports/Cucumber.xml",
                    "html:target/cucumber-reports/Cucumber.html"},
        publish = true)

public class RunCucumberTest {
}
