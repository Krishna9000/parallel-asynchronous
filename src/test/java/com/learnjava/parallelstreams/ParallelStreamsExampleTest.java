package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamsExampleTest {

    ParallelStreamsExample parallelStreamsExample;

    @BeforeEach
    void setUp() {
        parallelStreamsExample = new ParallelStreamsExample();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stringTransform() {
        List<String> inputList = DataSet.namesList();

        List<String> resultList = parallelStreamsExample.stringTransform(inputList);

        assertEquals(4,resultList.size());
        resultList.forEach(name -> assertTrue(name.contains("-")));
    }



    @Test
    void stringParallelTransform() {
        List<String> inputList = DataSet.namesList();

        List<String> resultList = parallelStreamsExample.stringParallelTransform(inputList);

        assertEquals(4,resultList.size());
        resultList.forEach(name -> assertTrue(name.contains("-")));
    }

    @Test
    void main() {
        ParallelStreamsExample.main(DataSet.namesList().toArray(new String[0]));
    }
}