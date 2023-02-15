package ru.sber.oop1;

/**
 * Класс PizzaOrder представляет собой объект, содержащий название заказанной пиццы,
 * адреса доставки, размер пиццы, требуется ли соус и её статус
 */
public class PizzaOrder {

    private String name;

    private String address;

    private PizzaSize size;

    private boolean withSauce;

    private boolean inProgress = false;

    private boolean wasCanceled = false;

    private String formatOrder() {
        return String.format("%s пицца %s%s на адрес %s", size, name, withSauce ? " с соусом" : "", address);
    }

    /**
     * Конструктор, создающий заказ, но не отправляющий его на исполнение.
     * Для исполнения нужно воспользоваться методом order().
     * @param name Название пиццы
     * @param address Адрес доставки
     * @param size Размер пиццы, может быть маленькой, средней или большой
     * @param withSauce Требуется ли соус
     */
    public PizzaOrder(String name, String address, PizzaSize size, boolean withSauce) {
        this.name = name;
        this.address = address;
        this.size = size;
        this.withSauce = withSauce;
    }

    /**
     * Переводит заказ в стадию "Исполнение".
     * Если заказ уже в этой стадии, выдает в консоль ошибку.
     */
    public void order() {
        if (inProgress) {
            System.out.println("Заказ уже принят");
            return;
        }

        System.out.format("Заказ принят: %s\n", formatOrder());
        inProgress = true;
        wasCanceled = false;
    }

    /**
     * Отменяет заказ, делая его неактивным и помечая как "Отмененный".
     * Если заказ ещё не принят или был отменен до этого, выдает в консоль ошибку.
     */
    public void cancel() {
        if (inProgress) {
            System.out.format("Заказ отменен: %s\n", formatOrder());
            inProgress = false;
            wasCanceled = true;
            return;
        }

        System.out.println("Заказ не был принят");
    }

    /**
     * @return Возвращает название заказанной пиццы
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает новое название пиццы, которую клиент хочет заказать
     * @param name Новое название пиццы
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Возвращает адрес доставки
     */
    public String getAddress() {
        return address;
    }

    /**
     * Устанавливает новый адрес, куда необходимо доставить пиццу
     * @param address Новый адрес доставки
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Возвращает размер заказанной пиццы (маленькая, средняя или большая)
     */
    public PizzaSize getSize() {
        return size;
    }

    /**
     * Устанавливает новый размер пиццы
     * @param size Новый размер пиццы
     */
    public void setSize(PizzaSize size) {
        this.size = size;
    }

    /**
     * @return Требует ли соус
     */
    public boolean withSauce() {
        return withSauce;
    }

    /**
     * Устанавливает, требуется ли добавить соус к пицце
     * @param withSauce Требуется ли добавить соус к пицце
     */
    public void setSauce(boolean withSauce) {
        this.withSauce = withSauce;
    }

    public String toString() {
        String progress = wasCanceled ? "Отменен" : "Не принят";

        if (inProgress) {
            progress = "Принят к исполнению";
        }

        return String.format("%s пицца %s%s на адрес %s. Статус заказа: %s",
                size, name, withSauce ? " с соусом" : "", address, progress);
    }

}
