package com.suvorov.task3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<K extends Comparable<K>, V> implements java.util.Map {

    private int size;
    private BinarySearchTree<K, V> tree = new BinarySearchTree<>();

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        tree.add(key, value);
        ++size;
    }

    public void delete(K key, V value) {
        tree.delete(key);
        --size;
    }
    public V getByKey(K key) {
        return tree.get(key);
    }
    @Override
    public Object put(Object key, Object value) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Object get(Object key) {
        throw new UnsupportedOperationException("Method is not implemented");
    }


    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException("Method is not implemented");
    }
}
