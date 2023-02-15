package ru.sber.oop1;

/**
 * Класс Author представляет собой объект, содержащий имя (и, возможно, фамилию) автора, его пол и почту
 */
public class Author {

    private String name;

    private Gender gender;

    private String email = null;

    /**
     * Конструктор без указания почты (существуют авторы без почты, или же авторы, которые существовали когда, когда почты ещё не было)
     * @param name Имя (и фамилия) автора
     * @param gender Пол автора
     */
    public Author(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    /**
     * Стандартный конструктор, принимающий все значения
     * @param name Имя (и, возможно, фамилия) автора
     * @param gender Пол автора
     * @param email Почта автора
     */
    public Author(String name, Gender gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    /**
     * @return Возвращает имя (и, возможно, фамилию) автора
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает новое имя (и, возможно, фамилию) автора
     * @param name Новое имя (и, возможно, фамилия) автора
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Возвращает пол автора
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Устанавливает новый пол автора
     * @param gender Новый пол автора
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return Возвращает почту автора
     * @apiNote Может вернуть null
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает новую почту автора
     * @param email Новая почта автора
     * @apiNote Может принимать значение null
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        if (email == null || "".equals(email)) {
            return String.format("%s, %s", name, gender);
        }

        return String.format("%s, %s (%s)", name, gender, email);
    }

}
