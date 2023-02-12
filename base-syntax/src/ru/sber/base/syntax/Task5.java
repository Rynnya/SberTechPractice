package ru.sber.base.syntax;

// Task5 - Простые числа
public class Task5 {

    private static boolean isPrime(int number) {
        // В идеале бы тут добавить проверку на number <= 1, но мы начинаем с 2
        // Поэтому опущу этот момент

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                System.out.format("%d ", i);
            }
        }

        System.out.println();
    }

}
