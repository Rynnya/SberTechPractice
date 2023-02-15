package ru.sber.oop1;

/**
 * Класс Color представляет собой объект, содержащий в себе 3 цвета как 3 числа с диапазоном от 0 до 255 <br>
 * Также поддерживает Alpha канал (прозрачность, в том же диапазоне от 0 до 255)
 */
public class Color {

    /**
     * Максимальное значение числа которое может принять триколор.
     * При использовании на Alpha канал убирает прозрачность.
     */
    public static final int MAX_VALUE = 255;

    /**
     * Минимальное значение числа которое может принять триколор.
     * При использовании на Alpha канал делает объект невидимым.
     */
    public static final int MIN_VALUE = 0;

    private int red = MIN_VALUE, green = MIN_VALUE, blue = MIN_VALUE, alpha = MAX_VALUE;

    private static int clampColor(int value) {
        return Math.max(Math.min(value, MAX_VALUE), MIN_VALUE);
    }

    /**
     * Стандартный конструктор <br>
     * Все значения выставлены на 0, Alpha канал на 1 (никакой прозрачности)
     */
    public Color() {}

    /**
     * Конструктор, принимающий один цвет.
     * Alpha параметр выставлен на 1 (никакой прозрачности).
     * @param oneColor Цвет, который будет выставлен всем 3 каналам.
     *                 Если значение меньше 0, оно становится равным 0.
     *                 Если значение больше 255, оно становится равным 255.
     */
    public Color(int oneColor) {
        int clampedColor = clampColor(oneColor);

        this.red = clampedColor;
        this.green = clampedColor;
        this.blue = clampedColor;
    }

    /**
     * Конструктор, принимающий все три цвета (триколор) <br>
     * Alpha параметр выставлен на 1 (никакой прозрачности) <br>
     * Если значение меньше 0, оно становится равным 0.
     * Если значение больше 255, оно становится равным 255.
     * @param red Значение для красного канала.
     * @param green Значение для зеленого канала.
     * @param blue Значение для синего канала.
     */
    public Color(int red, int green, int blue) {
        this.red = clampColor(red);
        this.green = clampColor(green);
        this.blue = clampColor(blue);
    }

    /**
     * Конструктор, принимающий все три цвета и Alpha канал. <br>
     * Если значение меньше 0, оно становится равным 0.
     * Если значение больше 255, оно становится равным 255.
     * @param red Значение для красного канала.
     * @param green Значение для зеленого канала.
     * @param blue Значение для синего канала.
     * @param alpha Значение для Alpha канала.
     */
    public Color(int red, int green, int blue, int alpha) {
        this.red = clampColor(red);
        this.green = clampColor(green);
        this.blue = clampColor(blue);
        this.alpha = clampColor(alpha);
    }

    public int getRed() {
        return red;
    }

    /**
     * Устанавливает значение для красного канала.
     * @param red Значение для красного канала.
     *            Если значение меньше 0, оно становится равным 0.
     *            Если значение больше 255, оно становится равным 255.
     */
    public void setRed(int red) {
        this.red = clampColor(red);
    }

    public int getGreen() {
        return green;
    }

    /**
     * Устанавливает значение для зеленого канала.
     * @param green Значение для зеленого канала.
     *            Если значение меньше 0, оно становится равным 0.
     *            Если значение больше 255, оно становится равным 255.
     */
    public void setGreen(int green) {
        this.green = clampColor(green);
    }

    public int getBlue() {
        return blue;
    }

    /**
     * Устанавливает значение для синего канала.
     * @param blue Значение для синего канала.
     *            Если значение меньше 0, оно становится равным 0.
     *            Если значение больше 255, оно становится равным 255.
     */
    public void setBlue(int blue) {
        this.blue = clampColor(blue);
    }

    public int getAlpha() {
        return alpha;
    }

    /**
     * Устанавливает значение для Alpha канала.
     * @param alpha Значение для Alpha канала.
     *            Если значение меньше 0, оно становится равным 0.
     *            Если значение больше 255, оно становится равным 255.
     */
    public void setAlpha(int alpha) {
        this.alpha = clampColor(alpha);
    }

    public String toString() {
        if (alpha == 255) {
            return String.format("{%d:%d:%d}", red, green, blue);
        }

        return String.format("{%d:%d:%d:%d}", red, green, blue, alpha);
    }

}
