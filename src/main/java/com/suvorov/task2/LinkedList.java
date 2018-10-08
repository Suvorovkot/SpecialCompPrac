package main.java.com.suvorov.task2;

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


    private T pop() {
        T value = head.value;
        head = null;
        tail = null;
        size = 0;
        return value;
    }


    private T removeLeft() {
        Node<T> tmp = head;
        size--;
        Node<T> newHead = head.right;
        newHead.left = null;
        head = newHead;
        return tmp.value;
    }

    private T removeMiddle(Node<T> current) {
        Node<T> previous = current.left;
        Node<T> next = current.right;
        size--;
        previous.right = next;
        next.left = previous;
        return current.value;
    }

    private T removeRight() {
        Node<T> tmp = tail;
        size--;
        Node<T> newLast = tail.left;
        newLast.right = null;
        tail = newLast;
        return tmp.value;
    }

    public T removeByIndex(int index) {
        Node<T> maybeNode = getNodeByIndex(index);
        if (maybeNode != null) {
            if (index == 0) {
                if (size != 1)
                    return removeLeft();
                else
                    return pop();
            }
            if (index == size - 1) {
                if (size != 1)
                    return removeRight();
                else
                    return pop();
            }
            return removeMiddle(maybeNode);
        } else
            throw new NoSuchElementException("List is empty");
    }


    public boolean contains(Object o) {
        if (o == null)
            throw new IllegalArgumentException("Null argument");
        else {
            for (Node<T> cur = head; cur != null; cur = cur.right) {
                if (cur.value.equals(o))
                    return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNodeByIndex(int index) {
        int iterationIndex = 0;

        if (index <= size - 1) {
            if (index > size / 2) {
                Node<T> current = tail;
                iterationIndex = size - 1;
                for (; iterationIndex != index; --iterationIndex) {
                    current = current.left;
                }
                return current;
            } else {
                Node<T> current = head;
                for (; iterationIndex != index; ++iterationIndex) {
                    current = current.right;
                }
                return current;
            }
        } else
            throw new NoSuchElementException("Index larger then List size");
    }
    public Object get(int index) {
        Node<T> maybeCurrent = getNodeByIndex(index);
        if (maybeCurrent != null)
            return maybeCurrent.value;
        else
            throw new NoSuchElementException("List is empty");
    }

    @Override
    public boolean remove(Object o) {
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