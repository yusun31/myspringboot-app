package com.example.myspringboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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

        // 3. Lambda Expression
        // Runnable이 가진 run() 메소드를 재정의하는 구문을 람다식으로 표현할 수 있음
        Thread t3 = new Thread(() -> System.out.println("람다식으로 구현함"));
        t3.start();
    }
}

@Getter @Setter
@AllArgsConstructor // 생성자 쓰지 않아도 자동으로 만들어줌
class User {
    private String name;
    private int age;

//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
}

class MyRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println("Runnable 구현 클래스 따로 만듦");
    }
}
