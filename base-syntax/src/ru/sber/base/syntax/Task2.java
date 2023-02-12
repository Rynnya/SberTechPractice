package ru.sber.base.syntax;

import java.util.Random;

// Task2 - Быстрая сортировка
public class Task2 {

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.format("%d ", i);
        }

        System.out.println();
    }

    private static void quickSort(int[] array, int lowerBound, int highestBound) {
        if (array.length == 0) {
            return;
        }

        if (lowerBound >= highestBound) {
            return;
        }

        int middle = lowerBound + (highestBound - lowerBound) / 2;
        int mainstay = array[middle];

        int i = lowerBound;
        int j = highestBound;

        while (i <= j) {
            while (array[i] < mainstay) {
                i++;
            }

            while (array[j] > mainstay) {
                j--;
            }

            if (i <= j) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;

                i++;
                j--;
            }
        }

        if (lowerBound < j) {
            quickSort(array, lowerBound, j);
        }

        if (highestBound > i) {
            quickSort(array, i, highestBound);
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        Random rng = new Random();
        int[] arrayToSort = new int[rng.nextInt(3,20)];

        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = rng.nextInt(100, 2000);
        }

        printArray(arrayToSort);
        quickSort(arrayToSort);
        printArray(arrayToSort);
    }

}
