package ru.sber.oop2.figures;

import ru.sber.oop2.Color;
import ru.sber.oop2.Figure;

import java.util.Locale;

public class Circle extends Figure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * @return Радиус круга
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * @param radius Радиус круга
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @return Площадь круга
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * @return Периметр круга
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String draw() {
        return this.draw(Color.Black);
    }

    @Override
    public String draw(Color color) {
        return String.format(Locale.US,
                "Нарисован круг с радиусом %.3f, с центром в точке %s и цветом %s",
                this.radius, super.getMiddlePoint(), color);
    }

}
