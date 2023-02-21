package ru.sber.oop2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PointUnitTests {

    @Test
    void testValues() {
        Point defaultInitialized = new Point();
        Assertions.assertEquals(0.0, defaultInitialized.getX());
        Assertions.assertEquals(0.0, defaultInitialized.getY());

        Random rng = new Random();
        double x = rng.nextDouble();
        double y = rng.nextDouble();

        Point withValueInitialized = new Point(x, y);
        Assertions.assertEquals(x, withValueInitialized.getX());
        Assertions.assertEquals(y, withValueInitialized.getY());

        withValueInitialized.setX(rng.nextDouble());
        withValueInitialized.setY(rng.nextDouble());
        Assertions.assertNotEquals(x, withValueInitialized.getX());
        Assertions.assertNotEquals(y, withValueInitialized.getY());
    }

    @Test
    void testOutput() {
        Point defaultInitialized = new Point();
        Assertions.assertEquals("(0.000, 0.000)", defaultInitialized.toString());

        Point smallValuesInitialized = new Point(1.762, 8.612);
        Assertions.assertEquals("(1.762, 8.612)", smallValuesInitialized.toString());

        Point bigValuesInitialized = new Point(2.6182632, 7.612831);
        Assertions.assertEquals("(2.618, 7.613)", bigValuesInitialized.toString());
    }

}
