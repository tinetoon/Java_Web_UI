package HomeWork04;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 05.12.2021
 */

public class FunctionCalcAreaTriangle {

    // Функция возвращающая площадь треугольника по трём сторонам
    public static Double areaTriangle(int a, int b, int c) {

        Double p = ((double)a + b + c) / 2;

        Double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return s;
    }
}
