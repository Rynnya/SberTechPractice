package ru.sber.collection1;

public interface Collection extends Iterable<Object> {

    /**
     * @return Количество элементов в коллекции
     */
    int size();

    /**
     * Проверяет, пустая ли коллекция
     * @return True если коллекция пустая, иначе False
     */
    boolean isEmpty();

    /**
     * Проверяет, содержится ли элемент в коллекции
     * @param item Элемент который надо найти
     * @return True если элемент содержится в данной коллекции, иначе False
     */
    boolean contains(Object item);

    /**
     * Добавляет новый элемент в коллекцию
     * @param item Элемент который необходимо добавить
     * @return True если коллекция была изменена (элемент был добавлен), иначе False
     */
    boolean add(Object item);

    /**
     * Удаляет ВСЕ элементы, равные переданному аргументу
     * @param item Элементы, которые нужно удалить
     * @return True если коллекция была изменена (удален хотя бы один элемент), иначе False
     */
    boolean remove(Object item);

    /**
     * Удаляет ВСЕ элементы коллекции
     */
    void clear();
}
