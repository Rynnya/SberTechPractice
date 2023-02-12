package ru.sber.base.syntax;

import java.util.Random;

// Task1 - Сортировка методом пузырька
public class Task1 {

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.format("%d ", i);
        }

        System.out.println();
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rng = new Random();
        int[] arrayToSort = new int[rng.nextInt(3,20)];

        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = rng.nextInt(100, 2000);
        }

        printArray(arrayToSort);
        bubbleSort(arrayToSort);
        printArray(arrayToSort);
    }

}
