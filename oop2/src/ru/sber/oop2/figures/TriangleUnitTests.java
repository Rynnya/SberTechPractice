package ru.sber.oop2.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.oop2.Color;

import java.util.Random;

public class TriangleUnitTests {

    @Test
    void testCalculations() {
        Random rng = new Random();

        double testCaseValueOne = rng.nextDouble(2.0, 10.0);
        double testCaseValueTwo = rng.nextDouble(2.0, 10.0);
        double testCaseValueThree = rng.nextDouble(2.0, 10.0);
        Triangle testCase = new Triangle(testCaseValueOne, testCaseValueTwo, testCaseValueThree);

        Assertions.assertEquals(testCaseValueOne, testCase.getSideOne());
        Assertions.assertEquals(testCaseValueTwo, testCase.getSideTwo());
        Assertions.assertEquals(testCaseValueThree, testCase.getSideThree());

        double newValueOne = rng.nextDouble(2.0, 10.0);
        double newValueTwo = rng.nextDouble(2.0, 10.0);
        double newValueThree = rng.nextDouble(2.0, 10.0);
        testCase.setSideOne(newValueOne);
        testCase.setSideTwo(newValueTwo);
        testCase.setSideThree(newValueThree);

        Assertions.assertEquals(newValueOne, testCase.getSideOne());
        Assertions.assertEquals(newValueTwo, testCase.getSideTwo());
        Assertions.assertEquals(newValueThree, testCase.getSideThree());

        double halfPerimeter = (newValueOne + newValueTwo + newValueThree) / 2;
        double expectedArea = halfPerimeter;
        expectedArea *= (halfPerimeter - newValueOne);
        expectedArea *= (halfPerimeter - newValueTwo);
        expectedArea *= (halfPerimeter - newValueThree);

        Assertions.assertEquals(Math.sqrt(expectedArea), testCase.area());
        Assertions.assertEquals(newValueOne + newValueTwo + newValueThree, testCase.perimeter());
    }

    @Test
    void testOutput() {
        Triangle testCase = new Triangle(7.561, 8.516, 6.7182);

        Assertions.assertEquals(
                "Нарисован треугольник со сторонами (7.561, 8.516, 6.718), с центром в точке (0.000, 0.000) и цветом Черный",
                testCase.draw());
        Assertions.assertEquals(
                "Нарисован треугольник со сторонами (7.561, 8.516, 6.718), с центром в точке (0.000, 0.000) и цветом Белый",
                testCase.draw(Color.White));
    }

}
