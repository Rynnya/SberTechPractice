package ru.sber.collection2;

import ru.sber.collection1.Collection;

public interface Map {

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
     * Проверяет, содержится ли ключ в коллекции
     * @param key Ключ который надо найти
     * @return True если ключ содержится в данной коллекции, иначе False
     */
    boolean containsKey(Object key);

    /**
     * Проверяет, содержится ли элемент в коллекции
     * @param value Элемент который надо найти
     * @return True если элемент содержится в данной коллекции, иначе False
     */
    boolean containsValue(Object value);

    /**
     * Возвращает пару из ключа и элемента
     * @param key Ключ который надо найти
     * @return Элемент, соответствующий данной паре, или null, если ничего не найдено
     * @apiNote Так как сам элемент может быть null, то следует сперва проверить, что элемент присутствует при помощи containsKey
     */
    Object get(Object key);

    /**
     * Вставляет новую пару или заменяет существующую пару из ключа и элемента новой парой, если та уже существует
     * @param key Ключ по которому нужно найти пару
     * @param value Новое значение пары
     * @return Старое значение пары или null, если пара вставлена
     * @apiNote Так как сам элемент может быть null, то следует сперва проверить, что элемент присутствует при помощи containsKey
     */
    Object put(Object key, Object value);

    /**
     * Удаляет пару из коллекции
     * @param key Ключ пары, которую нужно удалить
     * @return Объект пары, или null, если пара не найдена
     * @apiNote Так как сам элемент может быть null, то следует сперва проверить, что элемент присутствует при помощи containsKey
     */
    Object remove(Object key);

    /**
     * Очищает коллекцию
     */
    void clear();

    /**
     * @return Новая коллекция, содержащая все значения данной коллекции пар
     */
    Collection values();

    /**
     * @return Новая коллекция, содержащая все ключи данной коллекции пар
     */
    Collection keySet();

    /**
     * @return Новая коллекция, содержащая все пары данной коллекции
     */
    Collection entrySet();
}
