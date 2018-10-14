package com.suvorov.task3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<K extends Comparable<K>, V> implements java.util.Map {

    private BinarySearchTree<K, V> tree;
    private int size;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void put(K key, V value) {
        size++;
        tree.root = tree.insert(tree.root, key, value);
    }

    public V getVal(K key) {
        return tree.getByKey(tree.root, key);
    }

    public void removeByKey(K key) {
        size--;
        tree.root = tree.deletion(tree.root, key);
    }


    public boolean contKey(K key) {
        return tree.contains(tree.root, key);
    }


    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }


    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
