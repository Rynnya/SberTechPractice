package ru.sber.oop2;

public class FigureUtil {

    public static double area(Figure figure) {
        return figure.area();
    }

    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }

    public static String draw(Figure figure) {
        return figure.draw();
    }

    public static String draw(Figure figure, Color color) {
        return figure.draw(color);
    }

}
