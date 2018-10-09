package main.java.com.suvorov.task2;

import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void addTest() {
        MyLinkedList<Integer> firstList = new MyLinkedList<>();
        firstList.create(5);
        MyLinkedList<Integer> secondList = new MyLinkedList<>();
        secondList.addLast(5);

        assertEquals(firstList.get(0), secondList.get(0));
    }

    @Test
    void removeTest() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        for (int i = 1; i < 6; ++i)
            testList.addLast(i);

        Integer[] expected = {3, 1, 5, 2, 4};
        Integer[] testingArray = new Integer[5];
        Integer[] indexes = {2, 0, 2, 0, 0};
        int j = 0;
        for(int i : indexes) {
            testingArray[j] = testList.deleteByIndex(i);
            j++;
        }
        assertArrayEquals(expected, testingArray);
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
            for(int i : indexes) {
                testingArray[j] = testList.deleteByIndex(i);
                ++j;
            }});

        assertEquals("Index larger then List size", exception.getMessage());
    }
}
