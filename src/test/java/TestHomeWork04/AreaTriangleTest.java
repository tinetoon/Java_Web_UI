package TestHomeWork04;

import HomeWork04.FunctionCalcAreaTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для функции вычисления площади треугольника
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 05.12.2021
 */

public class AreaTriangleTest {

    @Test
    @DisplayName("01 Позитивная проверка площади треугольника")
    void givenThreeSidesWhenAreaTriangleThenPositive() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, 4, 5);
        Assertions.assertEquals(result, 6);
    }

    @Test
    @DisplayName("02 Негативная проверка на невалидные значения сторон")
    void givenThreeSidesIsNotValidWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(30, 40, 5);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("03 Негативная проверка сторона А=0")
    void givenThreeSidesA_NullWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(0, 4, 5);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("04 Негативная проверка сторона В=0")
    void givenThreeSidesB_NullWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, 0, 5);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("05 Негативная проверка сторона С=0")
    void givenThreeSidesC_NullWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, 4, 0);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("06 Негативная проверка сторона А<0")
    void givenThreeSidesA_NegativeWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(-1, 4, 5);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("07 Негативная проверка сторона В<0")
    void givenThreeSidesB_NegativeWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, -1, 5);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("08 Негативная проверка сторона С<0")
    void givenThreeSidesC_NegativeWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, 4, -1);
        Assertions.assertEquals(result, null);
    }

    @Test
    @DisplayName("09 Негативная проверка сторона А<0 & B<0")
    void givenThreeSidesAB_NegativeWhenAreaTriangleThenNegative() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(-3, -4, 5);
        Assertions.assertEquals(result, null);
    }
}
