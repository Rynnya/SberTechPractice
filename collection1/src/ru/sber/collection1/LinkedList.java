package ru.sber.collection1;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList implements List, Deque {

    private static class Iterator implements java.util.Iterator<Object> {

        private final LinkedList list;

        private int currentIndex = 0;

        public Iterator(LinkedList list) {
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

    private static class Node {

        public Object data;

        public Node previous;

        public Node next;

        public Node(Object data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

    }

    private Node head;

    private Node tail;

    private int size;

    private void checkBounds() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
    }

    private void checkPositionIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Индекс вышел за границы списка");
        }
    }

    private void checkElementIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Индекс вышел за границы списка");
        }
    }

    private Node getNode(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        Node currentNode = this.head;

        while (index-- > 0) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    private Node removeNode(Node nodeToRemove) {
        Node nextNode = nodeToRemove.next;
        Node previousNode = nodeToRemove.previous;

        if (previousNode == null) {
            this.head = nextNode;
        } else {
            previousNode.next = nextNode;
        }

        if (nextNode == null) {
            this.tail = previousNode;
        } else {
            nextNode.previous = previousNode;
        }

        this.size--;
        return nextNode;
    }

    private LinkedList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        boolean atLeastOneDeletion = false;

        Node currentNode = this.head;
        while (currentNode != null) {
            if (Objects.equals(currentNode.data, item)) {
                currentNode = removeNode(currentNode);
                atLeastOneDeletion = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return atLeastOneDeletion;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(Object item) {
        Node headNode = this.head;
        Node newNode = new Node(item, null, headNode);
        this.head = newNode;

        if (headNode == null) {
            this.tail = newNode;
        } else {
            headNode.previous = newNode;
        }

        this.size++;
    }

    @Override
    public void addLast(Object item) {
        Node tailNode = this.tail;
        Node newNode = new Node(item, tailNode, null);
        this.tail = newNode;

        if (tailNode == null) {
            this.head = newNode;
        } else {
            tailNode.next = newNode;
        }

        this.size++;
    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        checkBounds();

        return this.head.data;
    }

    @Override
    public Object getLast() throws NoSuchElementException {
        checkBounds();

        return this.tail.data;
    }

    @Override
    public Object pollFirst() {
        if (this.head == null) {
            return null;
        }

        return this.head.data;
    }

    @Override
    public Object pollLast() {
        if (this.tail == null) {
            return null;
        }

        return this.tail.data;
    }

    @Override
    public Object removeFirst() throws NoSuchElementException {
        checkBounds();

        Object objectToReturn = this.head.data;
        Node nextNode = this.head.next;
        this.head = nextNode;

        if (nextNode == null) {
            this.tail = null;
        } else {
            nextNode.previous = null;
        }

        this.size--;
        return objectToReturn;
    }

    @Override
    public Object removeLast() throws NoSuchElementException {
        checkBounds();

        Object objectToReturn = this.tail.data;
        Node previousNode = this.tail.previous;
        this.tail = previousNode;

        if (previousNode == null) {
            this.head = null;
        } else {
            previousNode.previous = null;
        }

        this.size--;
        return objectToReturn;
    }

    @Override
    public void add(int index, Object item) {
        checkPositionIndex(index);

        if (this.size == index) {
            addLast(item);
        } else {
            Node linkToNode = getNode(index);
            Node previousNode = linkToNode.previous;
            Node newNode = new Node(item, previousNode, linkToNode);
            linkToNode.previous = newNode;

            if (previousNode == null) {
                this.head = newNode;
            } else {
                previousNode.next = newNode;
            }

            this.size++;
        }
    }

    @Override
    public void set(int index, Object item) {
        if (this.size == index) {
            addLast(item);
        } else if (this.size > index) {
            getNode(index).data = item;
        }
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return getNode(index).data;
    }

    @Override
    public int indexOf(Object item) {
        int index = 0;

        for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next) {
            if (Objects.equals(currentNode.data, item)) {
                return index;
            }

            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        int index = this.size;

        for (Node currentNode = this.tail; currentNode != null; currentNode = currentNode.previous) {
            index--;

            if (Objects.equals(currentNode.data, item)) {
                return index;
            }
        }

        return -1;
    }

    @Override
    public Object removeAt(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        Node currentNode = this.head;

        while (index-- > 0) {
            currentNode = currentNode.next;
        }

        Object objectToReturn = currentNode.data;
        removeNode(currentNode);
        return objectToReturn;
    }

    @Override
    public List subList(int from, int to) throws IndexOutOfBoundsException {
        checkElementIndex(from);
        checkPositionIndex(to);

        return new LinkedList(getNode(from), getNode(to - 1), to - from);
    }

    @Override
    public Iterator iterator() {
        return new Iterator(this);
    }

}
