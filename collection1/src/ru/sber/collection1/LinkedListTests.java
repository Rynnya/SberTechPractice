package ru.sber.collection1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTests {

    private LinkedList linkedList;

    @BeforeEach
    public void prepareLinkedList() {
        linkedList = new LinkedList();
    }

    @Test
    public void testAdd() {
        linkedList.add(1);
        Assertions.assertEquals(1, linkedList.size());
        linkedList.add(2);
        Assertions.assertEquals(2, linkedList.size());
        linkedList.add(3);
        Assertions.assertEquals(3, linkedList.size());
    }

    @Test
    public void testAddIndexed() {
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1, 2);

        Assertions.assertEquals(3, linkedList.size());
        Assertions.assertEquals(1, linkedList.get(0));
        Assertions.assertEquals(2, linkedList.get(1));
        Assertions.assertEquals(1, linkedList.get(2));
    }

    @Test
    public void testAddToRealloc() {
        for (int i = 0; i < 12; i++) {
            linkedList.add(i);
        }

        Assertions.assertEquals(12, linkedList.size());

        for (int i = 0; i < 12; i++) {
            Assertions.assertEquals(i, linkedList.get(i));
        }
    }

    @Test
    public void testSet() {
        linkedList.set(1, 0);
        Assertions.assertEquals(0, linkedList.size());

        linkedList.set(0, 1);
        Assertions.assertEquals(1, linkedList.size());
        Assertions.assertEquals(1, linkedList.get(0));

        linkedList.set(2, 0);
        Assertions.assertEquals(1, linkedList.size());

        linkedList.set(1, 2);
        Assertions.assertEquals(2, linkedList.size());
        Assertions.assertEquals(2, linkedList.get(1));
    }

    @Test
    public void testIndexOf() {
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);

        Assertions.assertEquals(1, linkedList.indexOf(1));
        Assertions.assertEquals(0, linkedList.indexOf(2));
    }

    @Test
    public void testLastIndexOf() {
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);

        Assertions.assertEquals(2, linkedList.lastIndexOf(1));
        Assertions.assertEquals(linkedList.size() - 1, linkedList.lastIndexOf(2));
    }

    @Test
    public void testContains() {
        Assertions.assertFalse(linkedList.contains(1));
        Assertions.assertFalse(linkedList.contains(null));

        linkedList.add(1);

        Assertions.assertTrue(linkedList.contains(1));
        Assertions.assertFalse(linkedList.contains(2));
        Assertions.assertFalse(linkedList.contains(null));
    }

    @Test
    public void testRemoveAt() {
        linkedList.add(1);
        linkedList.add(2);

        linkedList.removeAt(0);

        Assertions.assertEquals(1, linkedList.size());
        Assertions.assertEquals(2, linkedList.get(0));
    }

    @Test
    public void testRemove() {
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);

        linkedList.remove(1);

        Assertions.assertEquals(1, linkedList.size());
        Assertions.assertEquals(2, linkedList.get(0));
    }

    @Test
    public void testClear() {
        linkedList.add(1);
        linkedList.clear();

        Assertions.assertTrue(linkedList.isEmpty());
        Assertions.assertEquals(0, linkedList.size());
    }

    @Test
    public void testIterator() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Iterator<Object> it = linkedList.iterator();

        Assertions.assertEquals(1, it.next());
        Assertions.assertEquals(2, it.next());
        Assertions.assertEquals(3, it.next());
        Assertions.assertFalse(it.hasNext());

        Assertions.assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void testSubList() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        List firstSubList = linkedList.subList(1, 5);
        List secondSubList = linkedList.subList(2, 3);

        Assertions.assertEquals(4, firstSubList.size());
        Assertions.assertEquals(2, firstSubList.get(0));
        Assertions.assertEquals(3, firstSubList.get(1));
        Assertions.assertEquals(4, firstSubList.get(2));
        Assertions.assertEquals(5, firstSubList.get(3));

        Assertions.assertEquals(1, secondSubList.size());
        Assertions.assertEquals(3, secondSubList.get(0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.subList(1, 6));
    }

    @Test
    public void testAddFirst() {
        linkedList.add(1);
        linkedList.addFirst(2);

        Assertions.assertEquals(2, linkedList.get(0));
    }

    @Test
    public void testGetFirst() {
        Assertions.assertThrows(NoSuchElementException.class, linkedList::getFirst);

        linkedList.add(1);
        linkedList.add(2);

        Assertions.assertEquals(linkedList.get(0), linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        Assertions.assertThrows(NoSuchElementException.class, linkedList::getLast);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.addFirst(3);

        Assertions.assertEquals(linkedList.get(linkedList.size() - 1), linkedList.getLast());
    }

    @Test
    public void testPollFirst() {
        Assertions.assertNull(linkedList.pollFirst());

        linkedList.add(2);
        Assertions.assertEquals(2, linkedList.pollFirst());

        linkedList.addFirst(4);
        Assertions.assertEquals(4, linkedList.pollFirst());
    }

    @Test
    public void testPollLast() {
        Assertions.assertNull(linkedList.pollFirst());

        linkedList.add(2);
        Assertions.assertEquals(2, linkedList.pollLast());

        linkedList.addFirst(4);
        Assertions.assertEquals(2, linkedList.pollLast());
    }

    @Test
    public void testRemoveFirst() {
        Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst);

        linkedList.add(2);
        Assertions.assertEquals(2, linkedList.removeFirst());
        Assertions.assertTrue(linkedList.isEmpty());

        linkedList.add(9);
        linkedList.addFirst(4);
        Assertions.assertEquals(4, linkedList.removeFirst());
        Assertions.assertEquals(9, linkedList.removeFirst());
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst);

        linkedList.add(2);
        Assertions.assertEquals(2, linkedList.removeLast());
        Assertions.assertTrue(linkedList.isEmpty());

        linkedList.add(9);
        linkedList.addFirst(4);
        Assertions.assertEquals(9, linkedList.removeLast());
        Assertions.assertEquals(4, linkedList.removeLast());
        Assertions.assertTrue(linkedList.isEmpty());
    }

}
