package ru.sber.oop1;

/**
 * Класс Book представляет собой объект, содержащий название книги, его автора и год издания
 */
public class Book {

    private String name;

    private Author author;

    private int year;

    /**
     * Стандартный конструктор, принимающий все значения
     * @param name Название книги
     * @param author Автор книги
     * @param year Год издания
     */
    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    /**
     * @return Возвращает название книги
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает новое название книги
     * @param name Новое название книги
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Возвращает автора книги
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Устанавливает нового автора книги
     * @param author Новый автор книги
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return Возвращает год издания книги
     */
    public int getYear() {
        return year;
    }

    /**
     * Устанавливает новый год издания книги
     * @param year Новый год издания книги
     */
    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return String.format("Книга под названием \"%s\", выпущенная %s в %d году.\n", name, author, year);
    }

}
