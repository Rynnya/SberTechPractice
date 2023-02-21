package ru.sber.oop2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sber.oop2.figures.Circle;
import ru.sber.oop2.figures.Rectangle;
import ru.sber.oop2.figures.Square;
import ru.sber.oop2.figures.Triangle;

public class FigureUnitTests {

    @Test
    void testFigure() {
        Figure testCase = new Rectangle(2, 2);
        testCase.setMiddlePoint(new Point(4, 6));

        Point middlePoint = testCase.getMiddlePoint();
        Assertions.assertEquals(4, middlePoint.getX());
        Assertions.assertEquals(6, middlePoint.getY());
        Assertions.assertEquals("(4.000, 6.000)", middlePoint.toString());
    }

    @Test
    void testUtils() {
        Figure circleTestCase = new Circle(4);
        Assertions.assertEquals(FigureUtil.area(circleTestCase), circleTestCase.area());
        Assertions.assertEquals(FigureUtil.perimeter(circleTestCase), circleTestCase.perimeter());
        Assertions.assertEquals(FigureUtil.draw(circleTestCase), circleTestCase.draw());
        Assertions.assertEquals(FigureUtil.draw(circleTestCase, Color.White), circleTestCase.draw(Color.White));

        Figure rectangleTestCase = new Rectangle(9, 2);
        Assertions.assertEquals(FigureUtil.area(rectangleTestCase), rectangleTestCase.area());
        Assertions.assertEquals(FigureUtil.perimeter(rectangleTestCase), rectangleTestCase.perimeter());
        Assertions.assertEquals(FigureUtil.draw(rectangleTestCase), rectangleTestCase.draw());
        Assertions.assertEquals(FigureUtil.draw(rectangleTestCase, Color.White), rectangleTestCase.draw(Color.White));

        Figure squareTestCase = new Square(8);
        Assertions.assertEquals(FigureUtil.area(squareTestCase), squareTestCase.area());
        Assertions.assertEquals(FigureUtil.perimeter(squareTestCase), squareTestCase.perimeter());
        Assertions.assertEquals(FigureUtil.draw(squareTestCase), squareTestCase.draw());
        Assertions.assertEquals(FigureUtil.draw(squareTestCase, Color.White), squareTestCase.draw(Color.White));

        Figure triangleTestCase = new Triangle(3, 4, 5);
        Assertions.assertEquals(FigureUtil.area(triangleTestCase), triangleTestCase.area());
        Assertions.assertEquals(FigureUtil.perimeter(triangleTestCase), triangleTestCase.perimeter());
        Assertions.assertEquals(FigureUtil.draw(triangleTestCase), triangleTestCase.draw());
        Assertions.assertEquals(FigureUtil.draw(triangleTestCase, Color.White), triangleTestCase.draw(Color.White));
    }

}
