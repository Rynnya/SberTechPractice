package ru.sber.collection1;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayList implements List {

    private static class Iterator implements java.util.Iterator<Object> {

        private final ArrayList list;

        private int currentIndex = 0;

        public Iterator(ArrayList list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public Object next() throws NoSuchElementException {
            if (hasNext()) {
                return list.get(currentIndex++);
            }

            throw new NoSuchElementException();
        }
    }

    private static final int INITIAL_SIZE = 10;

    private Object[] data;

    private int size = 0;

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Индекс вышел за границы списка");
        }
    }

    private ArrayList(Object[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public ArrayList() {
        this.data = new Object[INITIAL_SIZE];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0;
    }

    @Override
    public boolean add(Object item) {
        if (this.size + 1 >= this.data.length) {
            Object[] newData = new Object[((this.size + 1) * 3) / 2 + 1];
            System.arraycopy(this.data, 0, newData, 0, this.data.length);
            this.data = newData;
        }

        this.data[this.size++] = item;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        int previousSize = this.size;
        int index = indexOf(item);

        while (index != -1) {
            removeAt(index);
            index = indexOf(item);
        }

        return this.size == previousSize;
    }

    @Override
    public void clear() {
        this.data = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public void add(int index, Object item) {
        if (index == this.size) {
            add(item);
            return;
        }

        if (index > this.size) {
            return;
        }

        Object[] oldArray = this.data;

        if (this.size + 1 >= this.data.length) {
            Object[] newData = new Object[((this.size + 1) * 3) / 2 + 1];
            System.arraycopy(this.data, 0, newData, 0, index);
            this.data = newData;
        }

        System.arraycopy(oldArray, index, this.data, index + 1, this.size - index);
        this.data[index] = item;
        this.size++;
    }

    @Override
    public void set(int index, Object item) {
        if (index == this.size) {
            add(item);
        } else if (index < this.size) {
            this.data[index] = item;
        }
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        return this.data[index];
    }

    @Override
    public int indexOf(Object item) {
        if (item == null) {
            return -1;
        }

        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(this.data[i], item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        if (item == null) {
            return -1;
        }

        for (int i = this.size - 1; i >= 0; i--) {
            if (this.data[i] == item) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Object removeAt(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        Object objectToReturn = this.data[index];
        this.data[index] = null;
        System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
        this.size--;

        return objectToReturn;
    }

    @Override
    public List subList(int from, int to) throws IndexOutOfBoundsException {
        checkIndex(from);
        checkIndex(to);

        int sizeToCopy = to - from;
        Object[] newSublist = new Object[Math.min(sizeToCopy, 10)];
        System.arraycopy(this.data, from, newSublist, 0, sizeToCopy);

        return new ArrayList(newSublist, to - from);
    }

    @Override
    public Iterator iterator() {
        return new Iterator(this);
    }

}
