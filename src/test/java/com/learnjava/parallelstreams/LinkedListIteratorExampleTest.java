package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListIteratorExampleTest {

    LinkedListIteratorExample linkedListIteratorExample;

    @BeforeEach
    void setUp() {
        linkedListIteratorExample = new LinkedListIteratorExample();
    }

    @AfterEach
    void tearDown() {
    }

    @RepeatedTest(5)
    void multiplyEachValueSequential() {
        int size = 100000;
        LinkedList<Integer> inputList = DataSet.generateIntegerLinkedList(size);
        List<Integer> resultList = linkedListIteratorExample.multiplyEachValue(inputList,2,false);
        assertEquals(size,resultList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueParallel() {
        int size = 100000;
        LinkedList<Integer> inputList = DataSet.generateIntegerLinkedList(size);
        List<Integer> resultList = linkedListIteratorExample.multiplyEachValue(inputList,2,true);
        assertEquals(size,resultList.size());
    }
}