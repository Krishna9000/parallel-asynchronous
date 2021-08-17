package com.learnjava.parallelstreams;

import com.learnjava.util.CommonUtil;
import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;

import static com.learnjava.util.CommonUtil.*;

public class ParallelStreamsExample {

    List<String> stringTransform(List<String> namesList){
        return namesList.stream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    List<String> stringParallelTransform(List<String> namesList){
        return namesList.parallelStream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        startTimer();
        List<String> namesList = DataSet.namesList();
        ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();
        List<String> resultList = parallelStreamsExample.stringTransform(namesList);
        timeTaken();
        stopWatchReset();
        startTimer();
        resultList = parallelStreamsExample.stringParallelTransform(namesList);
        timeTaken();
    }

    private String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }
}
