package ru.sber.oop2.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.oop2.Color;

public class CircleUnitTests {

    @Test
    void testCalculations() {
        double testCaseValue = Math.random();
        Circle testCase = new Circle(testCaseValue);

        Assertions.assertEquals(testCaseValue, testCase.getRadius());

        double newValue = Math.random();
        testCase.setRadius(newValue);

        Assertions.assertEquals(newValue, testCase.getRadius());
        Assertions.assertEquals(Math.PI * Math.pow(newValue, 2), testCase.area());
        Assertions.assertEquals(2 * Math.PI * newValue, testCase.perimeter());
    }

    @Test
    void testOutput() {
        Circle testCase = new Circle(0.76231);

        Assertions.assertEquals(
                "Нарисован круг с радиусом 0.762, с центром в точке (0.000, 0.000) и цветом Черный",
                testCase.draw());
        Assertions.assertEquals(
                "Нарисован круг с радиусом 0.762, с центром в точке (0.000, 0.000) и цветом Белый",
                testCase.draw(Color.White));
    }

}
