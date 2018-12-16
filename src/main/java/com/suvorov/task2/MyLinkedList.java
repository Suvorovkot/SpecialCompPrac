package com.suvorov.task2;

import java.util.*;


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
     * <p>
     * This list should implement:
     * Adding to the end of list
     * Deleting by index
     * Content check
     * Emptiness check
     * Getting by index
     * (In addition) Adding by index
     */

    public void addLast(T value) {
        Node<T> newLastNode = new Node<T>(value, tail, null);
        Node<T> tmp = tail;

        tail = newLastNode;
        size++;
        if (tmp == null) {
            head = newLastNode;
        } else {
            tmp.right = newLastNode;
        }
    }


    public void create(T[] values) {
        Node<T> newFirstNode = new Node<T>(values[0], null, head);
        Node<T> tmp = head;

        head = newFirstNode;
        size++;
        if (tmp == null) {
            tail = newFirstNode;
        } else {
            tmp.left = newFirstNode;
        }
        for (int i = 1; i < values.length; i++) {
            addLast(values[i]);
        }
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public T deleteByIndex(int index) {
        Node<T> cur = getNodeByIndex(index);
        if (cur != null) {
            if (index == 0) {
                if (size != 1) {
                    return deleteHead();
                } else {
                    T value = head.value;
                    clear();
                    return value;
                }
            }
            if (index == size - 1) {
                if (size != 1) {
                    return deleteTail();
                } else {
                    T value = head.value;
                    clear();
                    return value;
                }
            }
            return deleteMiddle(cur);
        } else {
            throw new NoSuchElementException("List is empty");
        }
    }

    private T deleteTail() {
        Node<T> tmp = tail;
        Node<T> newLast = tail.left;
        newLast.right = null;
        tail = newLast;
        size--;
        return tmp.value;
    }

    private T deleteHead() {
        Node<T> tmp = head;
        Node<T> newHead = head.right;
        newHead.left = null;
        head = newHead;
        size--;
        return tmp.value;
    }

    private T deleteMiddle(Node<T> cur) {
        Node<T> previous = cur.left;
        Node<T> next = cur.right;
        previous.right = next;
        next.left = previous;
        size--;
        return cur.value;
    }


    public boolean contains(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Null argument");
        } else {
            for (Node<T> cur = head; cur != null; cur = cur.right) {
                if (cur.value.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        if (contains(o)) {
            int ind = 0;
            for (Node<T> cur = head; cur != null; cur = cur.right) {
                ind++;
                if (cur.value.equals(o)) {
                    return ind;
                }
            }
        } else {
            throw new IllegalArgumentException("No such element");
        }
        return 0;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNodeByIndex(int index) {
        int i = 0;
        if (index <= size - 1) {
            if (index > size / 2) {
                Node<T> cur = tail;
                i = size - 1;
                for (; i != index; i--) {
                    cur = cur.left;
                }
                return cur;
            } else {
                Node<T> cur = head;
                for (; i != index; i++) {
                    cur = cur.right;
                }
                return cur;
            }
        } else
            throw new NoSuchElementException("Out of bounds");
    }

    public Object get(int index) {
        Node<T> maybecur = getNodeByIndex(index);
        if (maybecur != null) {
            return maybecur.value;
        } else {
            throw new NoSuchElementException("List is empty");
        }
    }


    public void addPos(T value, int index) {
        Node<T> cur = getNodeByIndex(index);
        if (index >= 0) {
            if (index == 0) {
                Node<T> newNode = new Node<T>(value, null, head);
                head.left = newNode;
                head = newNode;
                size++;
            } else if (index == size) {
                addLast(value);
            } else {
                Node<T> newNode = new Node<T>(value, cur.left, cur);
                Node<T> next = cur.left;
                next.right = newNode;
                cur.left = newNode;
                size++;
            }
        } else {
            throw new IllegalArgumentException("Negative index");
        }
    }


    @Override
    public boolean remove(Object o) {
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
    public boolean add(Object o) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Method is not implemented");
    }


    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException("Method is not implemented");

    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("Method is not implemented");
    }


    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
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
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Method is not implemented");
    }


}