package ru.sber.oop2.figures;

import ru.sber.oop2.Color;

import java.util.Locale;

public class Square extends Rectangle {

    /**
     * @param side Сторона квадрата
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * @return Сторону квадрата
     */
    @Override
    public double getWidth() {
        return super.getWidth();
    }

    /**
     * @param side Сторона квадрата
     */
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    /**
     * @return Сторону квадрата
     */
    @Override
    public double getHeight() {
        return super.getHeight();
    }

    /**
     * @param side Сторона квадрата
     */
    @Override
    public void setHeight(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public String draw() {
        return this.draw(Color.Black);
    }

    @Override
    public String draw(Color color) {
        return String.format(Locale.US,
                "Нарисован квадрат со сторонами %.3f, с центром в точке %s и цветом %s",
                super.getWidth(), super.getMiddlePoint(), color);
    }

}
