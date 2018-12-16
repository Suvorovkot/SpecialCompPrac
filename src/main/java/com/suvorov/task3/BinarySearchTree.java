package com.suvorov.task3;

import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private class Node<K, V> {
        private K key;
        private Node<K, V> left;
        private Node<K, V> right;
        private V value;
        private int height;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            height = 1;
        }
    }

    private Node<K, V> root;

    private int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.height;
        }
    }

    private void updateHeight(Node<K, V> n) {
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        n.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private Node<K, V> rightRotate(Node<K, V> y) {
        Node<K, V> x = y.left;
        y.left = x.right;
        x.right = y;
        updateHeight(x);
        updateHeight(y);
        return x;
    }

    private Node<K, V> leftRotate(Node<K, V> y) {
        Node<K, V> x = y.right;
        x.right = y.left;
        x.left = y;
        updateHeight(x);
        updateHeight(y);
        return x;
    }

    private int getBalance(Node<K, V> n) {
        if (n == null) {
            return 0;
        }
        return height(n.right) - height(n.left);
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }


    private Node<K, V> balance(Node<K, V> n) {
        updateHeight(n);
        if (getBalance(n) == 2) {
            if (getBalance(n.right) < 0) {
                n.right = rightRotate(n.right);
            }
            return leftRotate(n);
        }
        if (getBalance(n) == -2) {
            if (getBalance(n.left) > 0) {
                n.left = leftRotate(n.left);
            }
            return rightRotate(n);
        }
        return n;
    }

    private V getByKey(K key, Node<K, V> current) {
        V val = null;
        if (current == null) {
            throw new NoSuchElementException("No such element in tree");
        } else {
            if (current.key.compareTo(key) < 0) {
                val = getByKey(key, current.right);
            } else {
                if (current.key.compareTo(key) > 0) {
                    val = getByKey(key, current.left);
                } else {
                    if (current.key.compareTo(key) == 0) {
                        val = current.value;
                    }
                }
            }
        }
        return val;
    }

    private Node<K, V> insert(K key, V value, Node<K, V> current) {
        if (current == null) {
            current = new Node<>(key, value, null, null);
        } else {
            if (current.key.compareTo(key) < 0) {
                current.right = insert(key, value, current.right);
            } else {
                if (current.key.compareTo(key) > 0) {
                    current.left = insert(key, value, current.left);
                } else {
                    if (current.key.compareTo(key) == 0) {
                        current.value = value;
                    }
                }
            }
        }
        return balance(current);
    }

    private Node<K, V> minNode(Node<K, V> current) {
        if (current.left != null) {
            minNode(current.left);
        }
        return current;
    }

    private Node<K, V> deleteByKey(K key, Node<K, V> current) {
        if (current == null) {
            throw new NoSuchElementException("No such element in tree");
        } else {
            if (current.key.compareTo(key) < 0) {
                current.right = deleteByKey(key, current.right);
            } else {
                if (current.key.compareTo(key) > 0) {
                    current.left = deleteByKey(key, current.left);
                } else {
                    if (current.left == null) {
                        return current.right;
                    } else {
                        if (current.right == null) {
                            return current.left;
                        } else {
                            Node<K, V> subNode = minNode(current.right);
                            current.key = subNode.key;
                            current.value = subNode.value;
                            current.right = deleteByKey(subNode.key, current.right);
                        }
                    }
                }
            }
        }

        return balance(current);
    }

    public boolean contains(K key) {
        try {
            getByKey(key, root);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void add(K key, V value) {
        root = insert(key, value, root);
    }
    public void delete(K key) {
        deleteByKey(key, root);
    }
    public V get(K key) {
        return getByKey(key, root);
    }
}
