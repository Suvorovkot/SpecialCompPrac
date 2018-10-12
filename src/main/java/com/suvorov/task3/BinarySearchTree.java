package com.suvorov.task3;

public class BinarySearchTree<T> {

    private class Node<V> {
        V value;
        int height, key;
        Node<V> left;
        Node<V> right;

        Node(int key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private int height(Node<T> N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }
    private int getBalance(Node<T> N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }
    private Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

}
