package ru.sber.oop1;

/**
 * Класс Phone представляет собой объект, содержащий номер, модель и вес телефона
 */
public class Phone {

    private String number = "";

    private String model = "";

    private int weight = 0;

    /**
     * Стандартный конструктор <br>
     * Значение номер и модели пустые, а вес телефона равен 0
     */
    public Phone() {}

    /**
     * Конструктор, принимающий номер телефона и его модель <br>
     * Вес телефона выставлен на 0
     * @param number Номер телефона
     * @param model Модель
     */
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    /**
     * Конструктор, принимающий номер телефона, его модель, и вес (указан в граммах)
     * @param number Номер телефона
     * @param model Модель
     * @param weight Вес телефона
     */
    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    /**
     * Выводит в консоль имя звонящего
     * @param name Имя звонящего
     */
    public void receiveCall(String name) {
        System.out.format("Звонит %s\n", name);
    }

    /**
     * Выводит в консоль имя звонящего и его номер
     * @param name Имя звонящего
     * @param number Номер звонящего
     */
    public void receiveCall(String name, String number) {
        System.out.format("Звонит %s (%s)\n", name, number);
    }

    /**
     * Выводит в консоль все номера, указанные в массиве
     * @param numbers Номера, которые будут выведены
     */
    public void sendMessage(String[] numbers) {
        for (String number : numbers) {
            System.out.format("%s\n", number);
        }
    }

    /**
     * @return Возвращает номер телефона
     */
    public String getNumber() {
        return number;
    }

    public String toString() {
        return String.format("{ Номер: %s; Модель: %s; Вес: %d }", number, model, weight);
    }

}
