package io;

import java.util.concurrent.atomic.AtomicInteger;

public class ParamTest {
    public static void main(String[] args) {
        Integer a = new Integer(10);
        System.out.println("before"+a);
        add(a);
        System.out.println("after"+a);
    }
    public static void add(Integer a){
        a=a+1;
    }
}
