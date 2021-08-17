package com.learnjava.parallelstreams;

import com.learnjava.util.CommonUtil;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamResultOrder {

    public static List<Integer> listOrder(List<Integer> inputList){
        return inputList.parallelStream()
                .map(integer -> integer * 2)
                .collect(Collectors.toList());
    }

    public static Set<Integer> setOrder(Set<Integer> inputSet){
        return inputSet.parallelStream()
                .map(integer -> integer * 3)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        CommonUtil.startTimer();
        List<Integer> inputList = List.of(1,2,3,4,5,6,7,8);
        log("inputList:"+inputList);
        List<Integer> result = listOrder(inputList);
        log("result:"+result);
        CommonUtil.timeTaken();
        CommonUtil.stopWatchReset();

        CommonUtil.startTimer();
        Set<Integer> inputSet = Set.of(1,2,3,4,5,6,7,8);
        log("inputList:"+inputSet);
        Set<Integer> result2 = setOrder(inputSet);
        log("result:"+result2);
        CommonUtil.timeTaken();
        CommonUtil.stopWatchReset();
    }

}
