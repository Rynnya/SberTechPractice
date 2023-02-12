package ru.sber.base.syntax;

import java.util.Scanner;

// Task8 - Загадка
public class Task8 {

    public static void main(String[] args) {
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        System.out.println("У вас есть 3 попытки чтобы отгадать.");
        System.out.println("Любое слово, введенное в консоль, считается как ответ, кроме слова \"Сдаюсь\".");
        System.out.println("При вводе слова \"Сдаюсь\" вам будет выдан ответ сразу.");
        System.out.println("Введите вашу догадку:");

        int amountOfTries = 3;
        Scanner scanner = new Scanner(System.in);

        while (amountOfTries > 0) {
            String answer = scanner.nextLine();
            switch (answer.toLowerCase()) {
                case "троллейбус" -> {
                    System.out.println("Правильно!");
                    return;
                }
                case "сдаюсь" -> {
                    System.out.println("Правильный ответ: Троллейбус");
                    return;
                }
                default -> {
                    System.out.println("Подумай ещё");
                    amountOfTries--;
                }
            }
        }

        System.out.println();
    }

}
