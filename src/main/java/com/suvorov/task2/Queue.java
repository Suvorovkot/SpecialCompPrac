package com.suvorov.task2;

import java.util.Collection;
import java.util.Iterator;

class Queue<T> implements java.util.Queue {


    private MyLinkedList<T> q;

    public Queue() {
        q = new MyLinkedList<T>();
    }

    /**
     * This queue should implement:
     * Adding to the queue
     * Getting first element
     * Emptiness check
     */

    public void push(T value) {
        q.addLast(value);
    }

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    public Object poll() {
        return q.get(0);
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }


    public int size() {
        return q.size();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Method is not implemented");
    }


    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean offer(Object o) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Object remove() {
        throw new UnsupportedOperationException("Method is not implemented");
    }


    @Override
    public Object element() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Method is not implemented");
    }
}
