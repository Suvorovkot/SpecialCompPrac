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
    void removeExceptionTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        for (int i = 1; i < 6; ++i)
            testList.addLast(i);

        Integer[] testingArray = new Integer[5];
        Integer[] indexes = {2, 0, 2, 0, 1};


        Throwable exception = assertThrows(NoSuchElementException.class, () -> {
            int j = 0;
            for (int i : indexes) {
                testingArray[j] = testList.deleteByIndex(i);
                ++j;
            }
        });
        assertEquals("Out of bounds", exception.getMessage());
    }
}
