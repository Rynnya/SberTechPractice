package ru.sber.base.syntax;

// Task4 - Случайный массив с случайными числами и его максимум и минимум
public class Task4 {

    public static void main(String[] args) {
        double[] array = new double[(int)(Math.random() * 20)];
        double max = 0.0;
        double average = 0.0;

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();

            if (array[i] > max) {
                max = array[i];
            }

            average += array[i];
            System.out.format("%f ", array[i]);
        }

        average /= array.length;

        System.out.println();
        System.out.format("Максимальное: %f\n", max);
        System.out.format("Среднее: %f\n", average);
    }

}
