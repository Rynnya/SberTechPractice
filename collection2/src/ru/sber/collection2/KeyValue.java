package ru.sber.collection2;

import java.util.Objects;

class KeyValue {

    public Object key;

    public Object value;

    public KeyValue(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        KeyValue other = (KeyValue) obj;
        return Objects.equals(this.key, other.key) && Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.key);
    }

}