package HomeWork04;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 05.12.2021
 */

public class FunctionCalcAreaTriangle {

    // Функция возвращающая площадь треугольника по трём сторонам
    public static Double areaTriangle(int a, int b, int c) {

        Double s = null;

        if (ExistenceOfTriangle(a, b, c) && validLengths(a, b, c)) {

            Double p = ((double)a + b + c) / 2;
            s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        return s;
    }

    // Проверка треугольника на существование
    public static boolean ExistenceOfTriangle(int a, int b, int c) {
        return ((a + b > c) && (b + c > a) && (c + a > b));
    }

    // Проверка валидности значений длин сторон
    public static boolean validLengths(int a, int b, int c) {
        return ((a * b * c) > 0);
    }
}
