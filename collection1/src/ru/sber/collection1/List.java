package ru.sber.collection1;

public interface List extends Collection {

    /**
     * Вставляет элемент в список
     * @param index Индекс, перед которым надо поставить элемент
     * @param item Элемент который необходимо вставить
     */
    void add(int index, Object item);

    /**
     * Заменяет элемент в списке
     * @param index Индекс, элемент которого необходимо заменить
     * @param item Элемент который необходимо заменить
     * @implNote Если индекс равен размеру внутреннего хранилища, то будет добавлен новый элемент в конец хранилища
     */
    void set(int index, Object item);

    /**
     * Возвращает элемент из списка
     * @param index Индекс элемента, который надо вернуть
     * @return Элемент, расположенный на указанном индексе
     * @throws IndexOutOfBoundsException Элемент отсутствует на указанном индексе
     */
    Object get(int index) throws IndexOutOfBoundsException;

    /**
     * Возвращает индекс в этом списке для указанного элемента
     * @param item Элемент, индекс которого надо найти
     * @return Индекс элемента или -1 если элемент не найден
     */
    int indexOf(Object item);

    /**
     * Возвращает последний индекс в этом списке для указанного элемента
     * @param item Элемент, последний индекс которого надо найти
     * @return Индекс элемента или -1 если элемент не найден
     */
    int lastIndexOf(Object item);

    /**
     * Удаляет элемент списка
     * @param index Индекс элемента который необходимо удалить
     * @return Удаленный элемент
     * @throws IndexOutOfBoundsException Элемент отсутствует на указанном индексе
     * @apiNote Переименовано с remove на removeAt для обратной совместимости с интерфейсом Collection
     */
    Object removeAt(int index) throws IndexOutOfBoundsException;

    /**
     * Возвращает новый под-список, начиная с позиции from включительно до позиции to не включительно
     * @param from Начальный индекс нового списка (включительно)
     * @param to Конечный индекс нового списка (не включительно)
     * @return Новый под-список
     * @throws IndexOutOfBoundsException Индексы выходят за границы списка
     */
    List subList(int from, int to) throws IndexOutOfBoundsException;
}
