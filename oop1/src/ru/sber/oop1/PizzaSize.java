package ru.sber.oop1;

public enum PizzaSize {
    SMALL("Маленькая"),
    MEDIUM("Средняя"),
    BIG("Большая"); // Не уверен, но, по-моему, тут LARGE больше бы подошла

    private final String sizeAsString;

    PizzaSize(String sizeAsString) {
        this.sizeAsString = sizeAsString;
    }

    public String toString() {
        return sizeAsString;
    }
}
