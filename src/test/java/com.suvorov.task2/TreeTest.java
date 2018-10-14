package com.suvorov.task2;


import com.suvorov.task3.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    @Test
    void contentTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        Integer[] numbers = {9, 3, 2, 6, 5};
        for (int i = 0; i < 5; i++) {
            tree.root = tree.insert(tree.root, numbers[i], numbers[i]);
        }
        assertTrue(tree.contains(tree.root, 5));
    }

    @Test
    void getTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        Integer[] numbers = {9, 3, 2, 6, 5};
        for (int i = 0; i < 5; i++) {
            tree.root = tree.insert(tree.root, numbers[i], numbers[i]);
        }
        assertTrue(tree.getByKey(tree.root, 5) == 5);
    }

    @Test
    void deletionTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        Integer[] numbers = {9, 3, 2, 6, 5};
        for (int i = 0; i < 5; i++) {
            tree.root = tree.insert(tree.root, numbers[i], numbers[i]);
        }
        tree.root = tree.deletion(tree.root, 2);
        assertFalse(tree.contains(tree.root, 2));
    }
    @Test
    void duplicationsTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        Integer[] numbers = {9, 3, 2, 6, 5, 5};
        for (int i = 0; i < 5; i++) {
            tree.root = tree.insert(tree.root, numbers[i], numbers[i]);
        }
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {tree.root = tree.insert(tree.root, numbers[5], numbers[5]);});
        assertEquals("Duplicates are not allowed", exception.getMessage());
    }


}
