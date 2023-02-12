package ru.sber.base.syntax;

// Task6 - Звездочки
public class Task6 {

    public static void main(String[] args) {
        int numberOfRows = 3;
        int numberOfColumns = 5;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }

}
