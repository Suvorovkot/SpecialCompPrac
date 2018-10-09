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
     * (In addition) Adding by index
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


    public void create(T[] values) {
        Node<T> newFirstNode = new Node<T>(values[0], null, head);
        Node<T> tmp = head;

        head = newFirstNode;
        size++;
        if (tmp == null)
            tail = newFirstNode;
        else
            tmp.left = newFirstNode;
        for(int i = 1; i < values.length; i++){
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
                if (size != 1)
                {
                    Node<T> tmp = head;
                    Node<T> newHead = head.right;
                    newHead.left = null;
                    head = newHead;
                    size--;
                    return tmp.value;
                }
                else {
                    T value = head.value;
                    clear();
                    return value;
                }
            }
            if (index == size - 1) {
                if (size != 1)
                {
                    Node<T> tmp = tail;
                    Node<T> newLast = tail.left;
                    newLast.right = null;
                    tail = newLast;
                    size--;
                    return tmp.value;
                }
                else {
                    T value = head.value;
                    clear();
                    return value;
                }
            }
            Node<T> previous = cur.left;
            Node<T> next = cur.right;
            previous.right = next;
            next.left = previous;
            size--;
            return cur.value;
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
    public int indexOf(Object o) {
        if (contains(o)){
            int ind = 0;
            for (Node<T> cur = head; cur != null; cur = cur.right) {
                ind++;
                if (cur.value.equals(o))
                    return ind; 
            } 
        }else{
            throw new IllegalArgumentException("No such element");
        }
        return 0;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNodeByIndex(int index) {
        int iterationIndex = 0;

        if (index <= size - 1) {
            if (index > size / 2) {
                Node<T> cur = tail;
                iterationIndex = size - 1;
                for (; iterationIndex != index; iterationIndex--) {
                    cur = cur.left;
                }
                return cur;
            } else {
                Node<T> cur = head;
                for (; iterationIndex != index; iterationIndex++) {
                    cur = cur.right;
                }
                return cur;
            }
        } else
            throw new NoSuchElementException("Out of bounds");
    }

    public Object get(int index) {
        Node<T> maybecur = getNodeByIndex(index);
        if (maybecur != null)
            return maybecur.value;
        else
            throw new NoSuchElementException("List is empty");
    }


    public void addPos(T value, int index) {
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