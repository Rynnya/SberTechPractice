package ru.sber.oop1;

public class Main {

    private static void PhoneDemonstration() {
        Phone phone = new Phone();

        phone.receiveCall("Вася Пупкин");
        phone.sendMessage(new String[] { "900", "88005553535", "03", "911", "0" });

        Phone sberPhone = new Phone("900", "Samsung X600");
        Phone actualPhone = new Phone("88005553535", "Nokia 3310", 133);

        sberPhone.receiveCall("Реклама", "88005553535");
        System.out.println(actualPhone.getNumber());
    }

    private static void CircleDemonstration() {
        Circle circle = new Circle(Math.random() * 69, new Color(123, 97, 61));

        System.out.format("Площадь круга: %f\n", circle.area());
        System.out.format("Периметр круга: %f\n", circle.perimeter());

        // Метод toString применяет округление до 3 чисел после запятой для площади и периметра
        System.out.println(circle);
    }

    private static void MatrixDemonstration() {
        final int BASE_ROW_COUNT = 5;
        final int BASE_COLUMN_COUNT = 5;
        final int ADDITION_ROW_COUNT = 3;
        final int ADDITION_COLUMN_COUNT = 2;
        int counter = 0;

        Matrix baseMatrix = new Matrix(BASE_ROW_COUNT, BASE_COLUMN_COUNT);
        for (int i = 0; i < BASE_ROW_COUNT; i++) {
            for (int j = 0; j < BASE_COLUMN_COUNT; j++) {
                baseMatrix.setValue(i, j, counter++);
            }
        }

        // Эти вызовы идентичны
        baseMatrix.print();
        System.out.println(baseMatrix);

        Matrix additionMatrix = new Matrix(ADDITION_ROW_COUNT, ADDITION_COLUMN_COUNT);
        for (int i = 0; i < ADDITION_ROW_COUNT; i++) {
            for (int j = 0; j < ADDITION_COLUMN_COUNT; j++) {
                additionMatrix.setValue(i, j, counter--);
            }
        }

        // Вызовы можно соединять в цепи вызовов
        baseMatrix
                .add(additionMatrix)
                .print();

        // Можно использовать размеры напрямую из матрицы.
        // Изменить их нельзя, так как они финальные для данного класса
        Matrix multiplyMatrix = new Matrix(9, 6);
        for (int i = 0; i < multiplyMatrix.rowCount; i++) {
            for (int j = 0; j < multiplyMatrix.columnCount; j++) {
                multiplyMatrix.setValue(i, j, --counter);
            }
        }

        multiplyMatrix.print();
        baseMatrix.multiply(multiplyMatrix).print();
    }

    private static void BookDemonstration() {
        Author lewis = new Author("Льюис Кэрролл", Gender.MALE);
        Book alice = new Book("Алиса в стране чудес", lewis, 1765);

        System.out.println(lewis);
        System.out.println(alice);

        Author robertMartin = new Author("Роберт Мартин", Gender.MALE, null);
        robertMartin.setEmail("robert.martin@gmail.com");

        Book cleanCode = new Book("Чистый код", robertMartin, 2016);
        cleanCode.setYear(2019);

        System.out.println(robertMartin);
        System.out.println(cleanCode);
    }

    private static void PizzaOrderDemonstration() {
        PizzaOrder pizzaOrder = new PizzaOrder("Домашняя", "Ягодная 07", PizzaSize.MEDIUM, false);
        System.out.println(pizzaOrder);

        pizzaOrder.setSauce(true);
        pizzaOrder.setSize(PizzaSize.BIG);

        pizzaOrder.order();
        System.out.println(pizzaOrder);

        pizzaOrder.cancel();
        pizzaOrder.cancel();
        System.out.println(pizzaOrder);

        pizzaOrder.setAddress("Хлебобулочная 3А");
        pizzaOrder.order();
        pizzaOrder.order();
        System.out.println(pizzaOrder);
    }

    public static void main(String[] args) {
        PhoneDemonstration();
        System.out.println();

        CircleDemonstration();
        System.out.println();

        MatrixDemonstration();
        System.out.println();

        BookDemonstration();
        System.out.println();

        PizzaOrderDemonstration();
        System.out.println();
    }

}
