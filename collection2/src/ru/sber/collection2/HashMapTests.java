package ru.sber.collection2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sber.collection1.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashMapTests {

    private HashMap hashMap;

    @BeforeEach
    public void prepareHashMap() {
        hashMap = new HashMap();
    }

    @Test
    public void testAdd() {
        Assertions.assertNull(hashMap.put(1, 0));
        Assertions.assertEquals(1, hashMap.size());
        Assertions.assertNull(hashMap.put(2, 0));
        Assertions.assertEquals(2, hashMap.size());
        Assertions.assertNull(hashMap.put(3, 0));
        Assertions.assertEquals(3, hashMap.size());
        Assertions.assertEquals(0, hashMap.put(1, 1));
    }

    @Test
    public void testAddSame() {
        hashMap.put(1, 0);
        hashMap.put(1, 0);

        Assertions.assertEquals(1, hashMap.size());
    }

    @Test
    public void testRemove() {
        hashMap.put(1, 0);
        hashMap.remove(1);

        Assertions.assertEquals(0, hashMap.size());

        hashMap.put(1, 0);
        hashMap.put(2, 0);
        hashMap.put(3, 0);
        hashMap.remove(2);

        Assertions.assertEquals(2, hashMap.size());
    }

    @Test
    public void testGet() {
        hashMap.put(1, 9);
        hashMap.put(2, 8);
        hashMap.put(5, 72);

        Assertions.assertEquals(9, hashMap.get(1));
        Assertions.assertEquals(8, hashMap.get(2));
        Assertions.assertNull(hashMap.get(3));
    }

    @Test
    public void testContainsKey() {
        Assertions.assertFalse(hashMap.containsKey(1));
        Assertions.assertFalse(hashMap.containsKey(null));

        hashMap.put(1, 2);

        Assertions.assertTrue(hashMap.containsKey(1));
        Assertions.assertFalse(hashMap.containsKey(2));
        Assertions.assertFalse(hashMap.containsKey(null));
    }

    @Test
    public void testContainsValue() {
        Assertions.assertFalse(hashMap.containsValue(1));
        Assertions.assertFalse(hashMap.containsValue(null));

        hashMap.put(1, 2);

        Assertions.assertFalse(hashMap.containsValue(1));
        Assertions.assertTrue(hashMap.containsValue(2));
        Assertions.assertFalse(hashMap.containsValue(null));
    }

    @Test
    public void testClear() {
        hashMap.put(1, 0);
        hashMap.clear();

        Assertions.assertTrue(hashMap.isEmpty());
        Assertions.assertEquals(0, hashMap.size());
    }

    @Test
    public void testValues() {
        hashMap.put(1, 6);
        hashMap.put(2, 3);
        hashMap.put(6, 4);
        hashMap.put(8, 8);
        hashMap.put(3, 1);

        Collection collection = hashMap.values();
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
        hashMap.put(1, 6);
        hashMap.put(17, 3);
        hashMap.put(33, 4);
        hashMap.put(2, 8);
        hashMap.put(18, 1);

        Collection collection = hashMap.values();
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
        hashMap.put(1, 6);
        hashMap.put(2, 3);
        hashMap.put(6, 4);
        hashMap.put(8, 8);
        hashMap.put(3, 1);

        Collection collection = hashMap.keySet();
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
        hashMap.put(1, 6);
        hashMap.put(2, 3);
        hashMap.put(6, 4);
        hashMap.put(8, 8);
        hashMap.put(3, 1);

        Collection collection = hashMap.entrySet();
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
