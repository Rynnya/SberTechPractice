package ru.sber.oop1;

/**
 * Класс Matrix представляет собой объект, состоящий из двумерного массива.
 * Размеры матрицы задаются при помощи соответствующих конструкторов.
 */
public class Matrix {

    private final double[][] matrix;

    /**
     * Количество строк в матрице
     */
    public final int rowCount;

    /**
     * Количество столбцов в матрице
     */
    public final int columnCount;

    /**
     * Конструктор, принимающий размеры матрицы
     * @param rowCount Количество строк в матрице
     * @param columnCount Количество столбцов в матрице
     * @throws IllegalArgumentException Возвращается когда количество строк или столбцов меньше, или равно 0
     */
    public Matrix(int rowCount, int columnCount) throws IllegalArgumentException {
        if (rowCount < 0) {
            throw new IllegalArgumentException(String.format("Невалидное количество строк: %d", rowCount));
        }

        if (columnCount < 0) {
            throw new IllegalArgumentException(String.format("Невалидное количество столбцов: %d", columnCount));
        }

        this.matrix = new double[rowCount][columnCount];
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    /**
     * Устанавливает новое значение на заданную строку и столбец. <br>
     * Если индекс строки меньше 0 или больше количества строк матрицы, никаких действий не производится. <br>
     * Если индекс столбца меньше 0 или больше количества столбцов матрицы, никаких действий не производится.
     * @param row Строка, в которую нужно вставить новое значение
     * @param column Столбец, куда надо вставить новое значение
     * @param value Значение для вставки
     * @return Ссылку на эту матрицу, с измененным значением в соответствующей строке и столбце, если они были в границах матрицы
     */
    public Matrix setValue(int row, int column, double value) {
        if (row >= rowCount || row < 0) {
            return this;
        }

        if (column >= columnCount || column < 0) {
            return this;
        }

        matrix[row][column] = value;
        return this;
    }

    /**
     * Добавляет к матрице другую матрицу. <br>
     * Если количество строк или столбцов у матриц разное, то добавляются только те числа, которые соответствуют наименьшей матрице
     * @return Ссылку на эту матрицу, после выполненного сложения с другой матрицей
     * @param otherMatrix Другая матрица, с которой будет произведено сложение
     */
    public Matrix add(Matrix otherMatrix) {
        int row = Math.min(rowCount, otherMatrix.rowCount);
        int column = Math.min(columnCount, otherMatrix.columnCount);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] += otherMatrix.matrix[i][j];
            }
        }

        return this;
    }

    /**
     * Умножает матрицу на предоставленный множитель
     * @return Ссылку на эту матрицу, после выполненного умножения на множитель
     * @param modifier Множитель
     */
    public Matrix multiply(double modifier) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= modifier;
            }
        }

        return this;
    }

    /**
     * Умножает матрицу на другую матрицу. <br>
     * Если количество строк или столбцов у матриц разное, то умножаются только те числа, которые соответствуют наименьшей матрице
     * @return Ссылку на эту матрицу, после выполненного умножения на другую матрицу
     * @param otherMatrix Другая матрица, с которой будет произведено умножение
     */
    public Matrix multiply(Matrix otherMatrix) {
        int row = Math.min(rowCount, otherMatrix.rowCount);
        int column = Math.min(columnCount, otherMatrix.columnCount);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] *= otherMatrix.matrix[i][j];
            }
        }

        return this;
    }

    /**
     * Выводит в консоль матрицу в красивом виде
     * @return Ссылку на эту матрицу, которая не была никак изменена
     */
    public Matrix print() {
        System.out.format("%s\n", this);

        return this;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(2 * rowCount * columnCount + rowCount);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                builder.append(matrix[i][j]).append(' ');
            }

            builder.append('\n');
        }

        return builder.toString();
    }
}
