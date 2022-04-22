package com.example.myspringboot;

import org.junit.jupiter.api.Test;

public class LambdaTest {
    @Test
    public void runnable() throws Exception{
        // 1. MyRunnable Class
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        // 2. Annoymous Inner Class
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable을 Annoymous Innerclass로 만듦");
            }
        });
        t2.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println("Runnable 구현 클래스 따로 만듦");
    }
}
