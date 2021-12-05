package HomeWork04;

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
    @DisplayName("Позитивная проверка площади треугольника")
    void givenThreeSidesWhenAreaTriangleThenPositive() {
        Double result = FunctionCalcAreaTriangle.areaTriangle(3, 4, 5);
        Assertions.assertEquals(result, 6);
    }
}
