package com.learnjava.thread;

import com.learnjava.util.LoggerUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

import static com.learnjava.util.CommonUtil.delay;

public class HelloWorldThreadExample {
    private static String result="";

    private static Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static void hello(){
        delay(700);
        result = result.concat("Hello");
        log.info("Concatenated Hello");
    }
    private static void world(){
        delay(600);
        result = result.concat("World");
        log.info("Concatenated World");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread helloThread = new Thread(()-> hello());
        Thread worldThread = new Thread(()-> world());

        //Starting the thread
        helloThread.start();
        worldThread.start();

        //Joining the thread (Waiting for the threads to finish)
        helloThread.join();
        worldThread.join();

        System.out.println("Result is : " + result);
    }
}
