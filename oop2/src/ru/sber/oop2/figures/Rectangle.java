package ru.sber.oop2.figures;

import ru.sber.oop2.Color;
import ru.sber.oop2.Figure;

import java.util.Locale;

public class Rectangle extends Figure {

    private double width;

    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return Ширину прямоугольника
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width Ширина прямоугольника
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return Высоту прямоугольника
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height Высота прямоугольника
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return Площадь прямоугольника
     */
    @Override
    public double area() {
        return this.width * this.height;
    }

    /**
     * @return Периметр прямоугольника
     */
    @Override
    public double perimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public String draw() {
        return this.draw(Color.Black);
    }

    @Override
    public String draw(Color color) {
        return String.format(Locale.US,
                "Нарисован прямоугольник со сторонами (%.3f, %.3f), с центром в точке %s и цветом %s",
                this.width, this.height, super.getMiddlePoint(), color);
    }

}
