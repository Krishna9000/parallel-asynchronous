package com.learnjava.parallelstreams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;

public class LinkedListIteratorExample {

    public List<Integer> multiplyEachValue(LinkedList<Integer> inputList, int multiplyValue, boolean isParallel){
        startTimer();
        Stream<Integer> integerStream;
        if (isParallel)
            integerStream = inputList.parallelStream(); // parallel
        else
            integerStream = inputList.stream(); // sequential

        List<Integer> resultList = integerStream.map(integer -> integer * multiplyValue)
                .collect(Collectors.toList());
        timeTaken();
        stopWatchReset();
        return resultList;
    }

}
