package ru.sber.collection2;

import ru.sber.collection1.Collection;
import ru.sber.collection1.ArrayList;
import ru.sber.collection1.LinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class HashMap implements Map {

    private final LinkedList[] buckets;

    private int size;

    private LinkedList getBucket(int index) {
        if (this.buckets[index] == null) {
            return (this.buckets[index] = new LinkedList());
        }

        return this.buckets[index];
    }

    private KeyValue getByKey(Object key) {
        LinkedList bucket = getBucket(Objects.hashCode(key) % buckets.length);

        for (Object rawKvp : bucket) {
            KeyValue kvp = (KeyValue) rawKvp;

            if (Objects.equals(kvp.key, key)) {
                return kvp;
            }
        }

        return null;
    }

    private KeyValue getByValue(Object value) {
        for (LinkedList bucket : this.buckets) {
            if (bucket == null) {
                continue;
            }

            for (Object rawKvp : bucket) {
                KeyValue kvp = (KeyValue) rawKvp;

                if (Objects.equals(kvp.value, value)) {
                    return kvp;
                }
            }
        }

        return null;
    }

    public HashMap() {
        this.buckets = new LinkedList[16];
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
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }

        return getByKey(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return getByValue(value) != null;
    }

    @Override
    public Object get(Object key) {
        KeyValue kvp = getByKey(key);

        if (kvp == null) {
            return null;
        }

        return kvp.value;
    }

    @Override
    public Object put(Object key, Object value) {
        LinkedList bucket = getBucket(Objects.hashCode(key) % buckets.length);

        for (int i = 0; i < bucket.size(); i++) {
            KeyValue kvp = (KeyValue) bucket.get(i);

            if (Objects.equals(kvp.key, key)) {
                Object objectToReturn = kvp.value;
                bucket.set(i, new KeyValue(key, value));
                return objectToReturn;
            }
        }

        bucket.addLast(new KeyValue(key, value));
        this.size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        LinkedList bucket = getBucket(Objects.hashCode(key) % buckets.length);
        Iterator<Object> it = bucket.iterator();
        int index = 0;

        while (it.hasNext()) {
            KeyValue kvp = (KeyValue) it.next();

            if (Objects.equals(kvp.key, key)) {
                KeyValue previousKvp = (KeyValue) bucket.removeAt(index);
                this.size--;
                return previousKvp.value;
            }

            index++;
        }

        return null;
    }

    @Override
    public void clear() {
        Arrays.fill(this.buckets, null);
        this.size = 0;
    }

    @Override
    public Collection values() {
        ArrayList newCollection = new ArrayList();

        for (LinkedList bucket : this.buckets) {
            if (bucket == null) {
                continue;
            }

            for (Object rawKvp : bucket) {
                newCollection.add(((KeyValue) rawKvp).value);
            }
        }

        return newCollection;
    }

    @Override
    public Collection keySet() {
        ArrayList newCollection = new ArrayList();

        for (LinkedList bucket : this.buckets) {
            if (bucket == null) {
                continue;
            }

            for (Object rawKvp : bucket) {
                newCollection.add(((KeyValue) rawKvp).key);
            }
        }

        return newCollection;
    }

    @Override
    public Collection entrySet() {
        ArrayList newCollection = new ArrayList();

        for (LinkedList bucket : this.buckets) {
            if (bucket == null) {
                continue;
            }

            for (Object rawKvp : bucket) {
                newCollection.add(rawKvp);
            }
        }

        return newCollection;
    }

}
