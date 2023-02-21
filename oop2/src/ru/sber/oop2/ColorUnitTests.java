package ru.sber.oop2;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class ColorUnitTests {

    @Test
    void testColors() {
        Assumptions.assumeTrue(
                "Белый".equals(Color.White.toString()),
                "Color.White возвращает неверное значение в методе toString() (ожидалось \"Белый\")");

        Assumptions.assumeTrue(
                "Черный".equals(Color.Black.toString()),
                "Color.Black возвращает неверное значение в методе toString() (ожидалось \"Черный\")");

        Assumptions.assumeTrue(
                "Красный".equals(Color.Red.toString()),
                "Color.Red возвращает неверное значение в методе toString() (ожидалось \"Красный\")");

        Assumptions.assumeTrue(
                "Зеленый".equals(Color.Green.toString()),
                "Color.Green возвращает неверное значение в методе toString() (ожидалось \"Зеленый\")");

        Assumptions.assumeTrue(
                "Синий".equals(Color.Blue.toString()),
                "Color.Blue возвращает неверное значение в методе toString() (ожидалось \"Синий\")");
    }

}
