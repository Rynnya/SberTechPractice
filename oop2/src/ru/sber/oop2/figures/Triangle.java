package ru.sber.oop2.figures;

import ru.sber.oop2.Color;
import ru.sber.oop2.Figure;

import java.util.Locale;

public class Triangle extends Figure {

    private double sideOne;

    private double sideTwo;

    private double sideThree;

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    /**
     * @return Первую сторону треугольника
     */
    public double getSideOne() {
        return sideOne;
    }

    /**
     * @param sideOne Первая сторона треугольника
     */
    public void setSideOne(double sideOne) {
        this.sideOne = sideOne;
    }

    /**
     * @return Вторую сторону треугольника
     */
    public double getSideTwo() {
        return sideTwo;
    }

    /**
     * @param sideTwo Вторая сторона треугольника
     */
    public void setSideTwo(double sideTwo) {
        this.sideTwo = sideTwo;
    }

    /**
     * @return Третью сторону треугольника
     */
    public double getSideThree() {
        return sideThree;
    }

    /**
     * @param sideThree Третья сторона треугольника
     */
    public void setSideThree(double sideThree) {
        this.sideThree = sideThree;
    }

    /**
     * @return Площадь треугольника
     */
    @Override
    public double area() {
        // Формула Герона
        double halfPerimeter = perimeter() / 2;

        double result = halfPerimeter;
        result *= (halfPerimeter - this.sideOne);
        result *= (halfPerimeter - this.sideTwo);
        result *= (halfPerimeter - this.sideThree);

        return Math.sqrt(result);
    }

    /**
     * @return Периметр треугольника
     */
    @Override
    public double perimeter() {
        return this.sideOne + this.sideTwo + this.sideThree;
    }

    @Override
    public String draw() {
        return this.draw(Color.Black);
    }

    @Override
    public String draw(Color color) {
        return String.format(Locale.US,
                "Нарисован треугольник со сторонами (%.3f, %.3f, %.3f), с центром в точке %s и цветом %s",
                this.sideOne, this.sideTwo, this.sideThree, super.getMiddlePoint(), color);
    }

}
