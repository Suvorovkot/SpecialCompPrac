package com.suvorov.task3;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private class Node<K, V> {
        int height;
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        private K getKey(V value) {
            return this.key;
        }

        Node(K key, V value) {
            this.key = key;
            this.height = 1;
            this.value = value;
        }
    }

    public Node<K, V> root;

    public int height(Node<K, V> N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    private int getBalance(Node<K, V> N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node<K, V> rightRotate(Node<K, V> y) {
        Node<K, V> x = y.left;
        Node<K, V> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node<K, V> leftRotate(Node<K, V> x) {
        Node<K, V> y = x.right;
        Node<K, V> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public boolean contains(Node<K, V> node, K key) {
        if (node == null) {
            return false;
        }

        if (node.key.compareTo(key) > 0) {
            return contains(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            return contains(node.right, key);
        } else if (node.key.compareTo(key) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public V getByKey(Node<K, V> node, K key){
        if (node.key.compareTo(key) > 0) {
            return getByKey(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            return getByKey(node.right, key);
        } else if (node.key.compareTo(key) == 0) {
            return node.value;
        } else {
            throw new IllegalArgumentException("No such element");
        }
    }


    public Node<K, V> insert(Node<K, V> node, K key, V value) {
        if (node == null) {
            return (new Node(key, value));
        }

        if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key, value);
        } else {
            throw new IllegalArgumentException("Duplicates are not allowed");
        }
        node.height = 1 + max(height(node.left),
                height(node.right));

        return insBalanceTree(node, key);
    }

    private Node<K, V> insBalanceTree(Node<K, V> node, K key) {
        int balance = getBalance(node);

        if (balance > 1 && node.left.key.compareTo(key) > 0) {
            return rightRotate(node);
        }

        if (balance < -1 && node.right.key.compareTo(key) < 0) {
            return leftRotate(node);
        }

        // Left Right
        if (balance > 1 && node.left.key.compareTo(key) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left
        if (balance < -1 && node.right.key.compareTo(key) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    private Node<K, V> minValueNode(Node<K, V> node) {
        Node<K, V> current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node deletion(Node<K, V> root, K key) {
        if (root == null) {
            return root;
        }
        if (contains(root, key) == false) {
            throw new IllegalArgumentException("No such element");
        }
        if (root.key.compareTo(key) > 0) {
            root.left = deletion(root.left, key);
        } else if (root.key.compareTo(key) < 0) {
            root.right = deletion(root.right, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node<K, V> temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node<K, V> temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deletion(root.right, temp.key);
            }
        }
        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

        return delBalanceTree(root);
    }

    private Node<K, V> delBalanceTree(Node<K, V> root) {
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }


}
