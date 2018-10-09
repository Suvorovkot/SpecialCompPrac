package main.java.com.suvorov.task2;

import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void addingAndCreatingTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        Integer[] begining = {1, 2};
        testList.create(begining);
        MyLinkedList<Integer> expectedList = new MyLinkedList<>();
        expectedList.addLast(1);
        expectedList.addLast(2);
        assertEquals(testList.get(1), expectedList.get(1));
    }

    @Test
    void addingInPositionTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        Integer[] begining = {1, 2, 4, 5};
        testList.create(begining);
        int pos = 2;
        testList.addPos(3,pos);
        assertEquals(testList.get(pos), 3);
    }

    @Test
    void deletingTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        Integer[] numbers = {9, 3, 2, 6, 5, 5};
        for (int i = 0; i < 6; i++) {
            testList.addLast(numbers[i]);
        }
        Integer[] expected = {9, 5};
        Integer[] testingArray = new Integer[2];
        testingArray[0] = testList.deleteByIndex(0);
        testingArray[1] = testList.deleteByIndex(3);
        assertArrayEquals(expected, testingArray);
    }

    @Test
    void contentTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        Integer[] numbers = {9, 3, 2, 6, 5, 5};
        for (int i = 0; i < 6; i++) {
            testList.addLast(numbers[i]);
        }
        assertTrue(testList.contains(6));
    }

    @Test
    void gettingTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        Integer[] numbers = {9, 3, 2, 6, 5, 5};
        for (int i = 0; i < 6; i++) {
            testList.addLast(numbers[i]);
        }

        Throwable exception = assertThrows(NoSuchElementException.class, () -> {testList.get(10);});
        assertEquals("Out of bounds", exception.getMessage());
    }
}
