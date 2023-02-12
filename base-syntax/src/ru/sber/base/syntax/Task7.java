package ru.sber.base.syntax;

// Task7 - Числа Фибоначчи
public class Task7 {

    public static void main(String[] args) {
        int previousOne = 0;
        int previousTwo = 1;

        for (int i = 0; i < 11; i++) {
            int newNumber = previousOne + previousTwo;
            previousOne = previousTwo;
            previousTwo = newNumber;

            System.out.format("%d ", newNumber);
        }

        System.out.println();
    }

}
