package ru.sber.oop2;

public abstract class Figure implements Drawable {

    private Point middlePoint = new Point();

    public Point getMiddlePoint() {
        return this.middlePoint;
    }

    public void setMiddlePoint(Point middlePoint) {
        this.middlePoint = middlePoint;
    }

    /**
     * @return Возвращает площадь фигуры
     */
    public abstract double area();

    /**
     * @return Возвращает периметр фигуры
     */
    public abstract double perimeter();

}
