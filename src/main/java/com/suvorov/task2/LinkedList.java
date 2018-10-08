package main.java.com.suvorov.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


class MyLinkedList<T> implements List {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    private class Node<V> {
        V value;
        Node<V> left;
        Node<V> right;

        Node(V value, Node<V> left, Node<V> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return this.size;
    }


    /**
     * All hail Javadoc!
     *
     * This list should implement:
     * Adding to the end of list
     * Deleting by index
     * Content
     * Emptiness
     * Getting by index
     * Adding by index
     */
    public void addLast(T value) {
        Node<T> newLastNode = new Node<T>(value, tail, null);
        Node<T> tmp = tail;

        tail = newLastNode;
        ++size;
        if (tmp == null)
            head = newLastNode;
        else
            tmp.right = newLastNode;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            throw new IllegalArgumentException("Null argument");
        else {
            for (Node<T> current = head; current != null; current = current.right) {
                if (current.value.equals(o))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }



}