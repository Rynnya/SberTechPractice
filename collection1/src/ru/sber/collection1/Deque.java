package ru.sber.collection1;

import java.util.NoSuchElementException;

public interface Deque extends Collection {

    /**
     * Добавляет новый элемент в начало коллекции
     * @param item Элемент который надо добавить
     */
    void addFirst(Object item);

    /**
     * Добавляет новый элемент в конец коллекции
     * @param item Элемент который надо добавить
     */
    void addLast(Object item);

    /**
     * Возвращает первый элемент коллекции, при этом элемент не удаляется
     * @return Первый элемент коллекции
     * @throws NoSuchElementException Если коллекция пустая
     */
    Object getFirst() throws NoSuchElementException;

    /**
     * Возвращает последний элемент коллекции, при этом элемент не удаляется
     * @return Последний элемент коллекции
     * @throws NoSuchElementException Если коллекция пустая
     */
    Object getLast() throws NoSuchElementException;

    /**
     * Возвращает первый элемент коллекции, при этом элемент не удаляется
     * @return Первый элемент коллекции или null, если коллекция пустая
     */
    Object pollFirst();

    /**
     * Возвращает последний элемент коллекции, при этом элемент не удаляется
     * @return Последний элемент коллекции или null, если коллекция пустая
     */
    Object pollLast();

    /**
     * Удаляет первый элемент коллекции
     * @return Удаленный элемент
     * @throws NoSuchElementException Если коллекция пустая
     */
    Object removeFirst() throws NoSuchElementException;

    /**
     * Удаляет последний элемент коллекции
     * @return Удаленный элемент
     * @throws NoSuchElementException Если коллекция пустая
     */
    Object removeLast() throws NoSuchElementException;

}
