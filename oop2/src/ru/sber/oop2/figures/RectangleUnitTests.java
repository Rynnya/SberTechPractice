package ru.sber.oop2.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.oop2.Color;

public class RectangleUnitTests {

    @Test
    void testCalculations() {
        double testCaseWidth = Math.random();
        double testCaseHeight = Math.random();
        Rectangle testCase = new Rectangle(testCaseWidth, testCaseHeight);

        Assertions.assertEquals(testCaseWidth, testCase.getWidth());
        Assertions.assertEquals(testCaseHeight, testCase.getHeight());

        double newWidth = Math.random();
        double newHeight = Math.random();
        testCase.setWidth(newWidth);
        testCase.setHeight(newHeight);

        Assertions.assertEquals(newWidth, testCase.getWidth());
        Assertions.assertEquals(newHeight, testCase.getHeight());

        Assertions.assertEquals(newWidth * newHeight, testCase.area());
        Assertions.assertEquals(2 * (newWidth + newHeight), testCase.perimeter());
    }

    @Test
    void testOutput() {
        Rectangle testCase = new Rectangle(6.26171, 7.51273);

        Assertions.assertEquals(
                "Нарисован прямоугольник со сторонами (6.262, 7.513), с центром в точке (0.000, 0.000) и цветом Черный",
                testCase.draw());
        Assertions.assertEquals(
                "Нарисован прямоугольник со сторонами (6.262, 7.513), с центром в точке (0.000, 0.000) и цветом Белый",
                testCase.draw(Color.White));
    }

}
