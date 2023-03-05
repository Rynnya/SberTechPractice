package ru.sber.collection1;

import org.junit.jupiter.api.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListTests {

    private ArrayList arrayList;

    @BeforeEach
    public void prepareArrayList() {
        arrayList = new ArrayList();
    }

    @Test
    public void testAdd() {
        arrayList.add(1);
        Assertions.assertEquals(1, arrayList.size());
        arrayList.add(2);
        Assertions.assertEquals(2, arrayList.size());
        arrayList.add(3);
        Assertions.assertEquals(3, arrayList.size());
    }

    @Test
    public void testAddIndexed() {
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1, 2);

        Assertions.assertEquals(3, arrayList.size());
        Assertions.assertEquals(1, arrayList.get(0));
        Assertions.assertEquals(2, arrayList.get(1));
        Assertions.assertEquals(1, arrayList.get(2));
    }

    @Test
    public void testAddToRealloc() {
        for (int i = 0; i < 12; i++) {
            arrayList.add(i);
        }

        Assertions.assertEquals(12, arrayList.size());

        for (int i = 0; i < 12; i++) {
            Assertions.assertEquals(i, arrayList.get(i));
        }
    }

    @Test
    public void testSet() {
        arrayList.set(1, 0);
        Assertions.assertEquals(0, arrayList.size());

        arrayList.set(0, 1);
        Assertions.assertEquals(1, arrayList.size());
        Assertions.assertEquals(1, arrayList.get(0));

        arrayList.set(2, 0);
        Assertions.assertEquals(1, arrayList.size());

        arrayList.set(1, 2);
        Assertions.assertEquals(2, arrayList.size());
        Assertions.assertEquals(2, arrayList.get(1));
    }

    @Test
    public void testIndexOf() {
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);

        Assertions.assertEquals(1, arrayList.indexOf(1));
        Assertions.assertEquals(0, arrayList.indexOf(2));
    }

    @Test
    public void testLastIndexOf() {
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);

        Assertions.assertEquals(2, arrayList.lastIndexOf(1));
        Assertions.assertEquals(arrayList.size() - 1, arrayList.lastIndexOf(2));
    }

    @Test
    public void testContains() {
        Assertions.assertFalse(arrayList.contains(1));
        Assertions.assertFalse(arrayList.contains(null));

        arrayList.add(1);

        Assertions.assertTrue(arrayList.contains(1));
        Assertions.assertFalse(arrayList.contains(2));
        Assertions.assertFalse(arrayList.contains(null));
    }

    @Test
    public void testRemoveAt() {
        arrayList.add(1);
        arrayList.add(2);

        arrayList.removeAt(0);

        Assertions.assertEquals(1, arrayList.size());
        Assertions.assertEquals(2, arrayList.get(0));
    }

    @Test
    public void testRemove() {
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);

        arrayList.remove(1);

        Assertions.assertEquals(1, arrayList.size());
        Assertions.assertEquals(2, arrayList.get(0));
    }

    @Test
    public void testClear() {
        arrayList.add(1);
        arrayList.clear();

        Assertions.assertTrue(arrayList.isEmpty());
        Assertions.assertEquals(0, arrayList.size());
    }

    @Test
    public void testIterator() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Iterator<Object> it = arrayList.iterator();

        Assertions.assertEquals(1, it.next());
        Assertions.assertEquals(2, it.next());
        Assertions.assertEquals(3, it.next());
        Assertions.assertFalse(it.hasNext());

        Assertions.assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void testSubList() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        List firstSubList = arrayList.subList(1, 5);
        List secondSubList = arrayList.subList(2, 3);

        Assertions.assertEquals(4, firstSubList.size());
        Assertions.assertEquals(2, firstSubList.get(0));
        Assertions.assertEquals(3, firstSubList.get(1));
        Assertions.assertEquals(4, firstSubList.get(2));
        Assertions.assertEquals(5, firstSubList.get(3));

        Assertions.assertEquals(1, secondSubList.size());
        Assertions.assertEquals(3, secondSubList.get(0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.subList(1, 6));
    }

}
