package ru.gb;

import HomeWork04.FunctionCalcAreaTriangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для тестирования с помощью assertj
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 08.12.2021
 */

public class FunctionTest {

    // Создаём экземпляр логера на основе библиотеке Logback
    private static Logger logger = LoggerFactory.getLogger(FunctionTest.class); // Взамен FunctionTest.class можно передавать String название

    @Test
    @DisplayName("01 Позитивная проверка вычисления площади при валидных значениях")
    void test01() {
        logger.debug("\n[DEBUG] Проверяем правильность вычисления площади треугольника" +
                "\n[DEBUG] Принимаем стороны треугольника a=3, b=4, c=5" +
                "\n[DEBUG] В результате расчёта площадь треугольника должна быть равной S=6");
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, 4, 5);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("02 Позитивная проверка существования треугольника")
    void test02() {
        logger.debug("\n[DEBUG] Проверяем существование треугольника" +
                "\n[DEBUG] Принимаем стороны треугольника a=3, b=4, c=5" +
                "\n[DEBUG] В результате расчёта должно удовлетворяться основное правило треугольника:" +
                "\n[DEBUG] - длина каждой из сторон должна быть меньше суммы двух других.");
        Boolean result = FunctionCalcAreaTriangle.ExistenceOfTriangle(3, 4, 5);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("03 Позитивная проверка значений длин сторон")
    void test03() {
        logger.debug("\n[DEBUG] Проверяем условие, что стороны треугольнику больше нуля" +
                "\n[DEBUG] Метод возвращает true при выполнении условия");
        Boolean result = FunctionCalcAreaTriangle.validLengths(3, 4, 5);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("04 Негативная проверка существования треугольника")
    void test04() {
        logger.debug("\n[DEBUG] Проверяем существование треугольника" +
                "\n[DEBUG] Принимаем стороны треугольника a=3, b=4, c=50" +
                "\n[DEBUG] Метод возвращает false при не выполнении условия");
        Boolean result = FunctionCalcAreaTriangle.ExistenceOfTriangle(3, 4, 50);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("05 Негативная проверка значений длин сторон")
    void test05() {
        logger.debug("\n[DEBUG] Проверяем условие, что стороны треугольнику больше нуля" +
                "\n[DEBUG] Принимаем стороны треугольника a=3, b=4, c=0" +
                "\n[DEBUG] Метод возвращает true при не выполнении условия");
        Boolean result = FunctionCalcAreaTriangle.validLengths(3, 4, 0);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("06 Негативная проверка значений длин сторон")
    void test06() {
        logger.debug("\n[DEBUG] Проверяем условие, что стороны треугольнику больше нуля" +
                "\n[DEBUG] Принимаем стороны треугольника a=-3, b=-4, c=5" +
                "\n[DEBUG] Метод возвращает true при не выполнении условия");
        Boolean result = FunctionCalcAreaTriangle.validLengths(-3, -4, 5);
        assertThat(result).isFalse();
    }
}
