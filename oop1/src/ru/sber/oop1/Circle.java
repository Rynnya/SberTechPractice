package ru.sber.oop1;

/**
 * Класс Circle представляет собой объект, содержащий радиус круга и его цвет
 */
public class Circle {

    private final double radius;

    private final Color color;

    /**
     * Конструктор класса Круг
     * @param radius Радиус круга
     * @param color Объект класса Color, канал Alpha игнорируется
     */
    public Circle(double radius, Color color) {
        this.radius = radius;
        this.color = color;

        this.color.setAlpha(Color.MAX_VALUE);
    }

    /**
     * Возвращает площадь круга, основываясь на радиусе круга
     * @return Площадь круга
     */
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Возвращает периметр круга (она же длина окружности)
     * @return Периметр круга
     */
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return String.format("{ Радиус: %.3f; Цвет: %s; Площадь: %.3f; Периметр: %.3f }",
                radius, color, area(), perimeter());
    }
}
