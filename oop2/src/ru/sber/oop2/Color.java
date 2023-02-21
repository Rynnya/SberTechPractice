package ru.sber.oop2;

public enum Color {
    White("Белый"),
    Black("Черный"),
    Red("Красный"),
    Green("Зеленый"),
    Blue("Синий");

    private final String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        return colorName;
    }

}
