package ru.sber.oop2.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.oop2.Color;

public class SquareUnitTests {

    @Test
    void testCalculations() {
        double testCaseValue = Math.random();
        Square testCase = new Square(testCaseValue);

        Assertions.assertEquals(testCaseValue, testCase.getWidth());
        Assertions.assertEquals(testCaseValue, testCase.getHeight());
        Assertions.assertEquals(testCase.getWidth(), testCase.getHeight());
        Assertions.assertEquals(Math.pow(testCaseValue, 2), testCase.area());
        Assertions.assertEquals(4 * testCaseValue, testCase.perimeter());

        double newWidth = Math.random();
        testCase.setWidth(newWidth);

        Assertions.assertEquals(newWidth, testCase.getWidth());
        Assertions.assertEquals(newWidth, testCase.getHeight());
        Assertions.assertEquals(Math.pow(newWidth, 2), testCase.area());
        Assertions.assertEquals(4 * newWidth, testCase.perimeter());

        double newHeight = Math.random();
        testCase.setHeight(newHeight);

        Assertions.assertEquals(newHeight, testCase.getWidth());
        Assertions.assertEquals(newHeight, testCase.getHeight());
        Assertions.assertEquals(Math.pow(newHeight, 2), testCase.area());
        Assertions.assertEquals(4 * newHeight, testCase.perimeter());
    }

    @Test
    void testOutput() {
        Square testCase = new Square(2.7162);

        Assertions.assertEquals(
                "Нарисован квадрат со сторонами 2.716, с центром в точке (0.000, 0.000) и цветом Черный",
                testCase.draw());
        Assertions.assertEquals(
                "Нарисован квадрат со сторонами 2.716, с центром в точке (0.000, 0.000) и цветом Белый",
                testCase.draw(Color.White));
    }

}
