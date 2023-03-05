package ru.sber.collection2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sber.collection1.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeMapTests {

    private TreeMap treeMap;

    @BeforeEach
    public void prepareTreeMap() {
        treeMap = new TreeMap();
    }

    @Test
    public void testAdd() {
        treeMap.put(1, 0);
        Assertions.assertEquals(1, treeMap.size());
        treeMap.put(2, 0);
        Assertions.assertEquals(2, treeMap.size());
        treeMap.put(3, 0);
        Assertions.assertEquals(3, treeMap.size());
    }

    @Test
    public void testAddSame() {
        treeMap.put(1, 0);
        treeMap.put(1, 0);

        Assertions.assertEquals(1, treeMap.size());
    }

    @Test
    public void testRemove() {
        treeMap.put(1, 0);
        treeMap.remove(1);

        Assertions.assertEquals(0, treeMap.size());

        treeMap.put(1, 0);
        treeMap.put(2, 0);
        treeMap.put(3, 0);
        treeMap.remove(2);

        Assertions.assertEquals(2, treeMap.size());
    }

    @Test
    public void testGet() {
        treeMap.put(1, 9);
        treeMap.put(2, 8);
        treeMap.put(5, 72);

        Assertions.assertEquals(9, treeMap.get(1));
        Assertions.assertEquals(8, treeMap.get(2));
        Assertions.assertNull(treeMap.get(3));
    }

    @Test
    public void testContainsKey() {
        Assertions.assertFalse(treeMap.containsKey(1));
        Assertions.assertFalse(treeMap.containsKey(null));

        treeMap.put(1, 2);

        Assertions.assertTrue(treeMap.containsKey(1));
        Assertions.assertFalse(treeMap.containsKey(2));
        Assertions.assertFalse(treeMap.containsKey(null));
    }

    @Test
    public void testContainsValue() {
        Assertions.assertFalse(treeMap.containsValue(1));
        Assertions.assertFalse(treeMap.containsValue(null));

        treeMap.put(1, 2);

        Assertions.assertFalse(treeMap.containsValue(1));
        Assertions.assertTrue(treeMap.containsValue(2));
        Assertions.assertFalse(treeMap.containsValue(null));
    }

    @Test
    public void testClear() {
        treeMap.put(1, 0);
        treeMap.clear();

        Assertions.assertTrue(treeMap.isEmpty());
        Assertions.assertEquals(0, treeMap.size());
    }

    @Test
    public void testValues() {
        treeMap.put(1, 6);
        treeMap.put(2, 3);
        treeMap.put(6, 4);
        treeMap.put(8, 8);
        treeMap.put(3, 1);

        Collection collection = treeMap.values();
        Iterator<Object> it = collection.iterator();

        List<Integer> actualList = new ArrayList<>();
        List<Integer> expected = List.of(1, 3, 4, 6, 8);

        while (it.hasNext()) {
            actualList.add((Integer) it.next());
        }

        Assertions.assertTrue(expected.containsAll(actualList));
    }

    @Test
    public void testValuesHugeLoad() {
        treeMap.put(1, 6);
        treeMap.put(17, 3);
        treeMap.put(33, 4);
        treeMap.put(2, 8);
        treeMap.put(18, 1);

        Collection collection = treeMap.values();
        Iterator<Object> it = collection.iterator();

        List<Integer> actualList = new ArrayList<>();
        List<Integer> expected = List.of(1, 3, 4, 6, 8);

        while (it.hasNext()) {
            actualList.add((Integer) it.next());
        }

        Assertions.assertTrue(expected.containsAll(actualList));
    }

    @Test
    public void testKeySet() {
        treeMap.put(1, 6);
        treeMap.put(2, 3);
        treeMap.put(6, 4);
        treeMap.put(8, 8);
        treeMap.put(3, 1);

        Collection collection = treeMap.keySet();
        Iterator<Object> it = collection.iterator();

        List<Integer> actualList = new ArrayList<>();
        List<Integer> expected = List.of(1, 2, 3, 6, 8);

        while (it.hasNext()) {
            actualList.add((Integer) it.next());
        }

        Assertions.assertTrue(expected.containsAll(actualList));
    }

    @Test
    public void testEntrySet() {
        treeMap.put(1, 6);
        treeMap.put(2, 3);
        treeMap.put(6, 4);
        treeMap.put(8, 8);
        treeMap.put(3, 1);

        Collection collection = treeMap.entrySet();
        Iterator<Object> it = collection.iterator();

        List<KeyValue> actualList = new ArrayList<>();
        List<KeyValue> expected = List.of(
                new KeyValue(1, 6),
                new KeyValue(2, 3),
                new KeyValue(3, 1),
                new KeyValue(6, 4),
                new KeyValue(8, 8)
        );

        while (it.hasNext()) {
            actualList.add((KeyValue) it.next());
        }

        Assertions.assertTrue(expected.containsAll(actualList));
    }

}
