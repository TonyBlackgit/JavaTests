package com.IDEA.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Test {
//    private static class Worker{
//        public void run(){
//            this.call();
//        }
//
//        protected void call(){
//            System.out.println("In Worker");
//        }
//    }
//
//    private static class KeepWorker extends Worker{
//
//        protected void call(){
//            System.out.println("In KeepWorker");
//        }
//    }
//
//    private static int bingo() throws InterruptedException {
//        try{
//            System.out.println("In try");
//            return 0;
//        }catch (Exception e)
//        {
//            System.out.println("catch exception");
//        }
//        finally {
//            System.out.println(System.currentTimeMillis() + " finally");
//        }
//        return 9;
//    }
//    private static int cat() throws InterruptedException {
//        System.out.println(System.currentTimeMillis() + " return");
//        Thread.sleep(10);
//        return 9;
//    }
//
//    public static void main(String[] args) throws InterruptedException {
////        String s = "123";
////        int a = Integer.parseInt(s);
////        System.out.println(a);
//
////        KeepWorker w = new KeepWorker();
////        w.call();
////        checkName(null);
//        int tmp = bingo();
//        System.out.println(tmp);
//        System.out.println("--------------------------------------------");
//        CreateTest ct = new CreateTest(10);
//        System.out.println(ct.score);
//    }
//    public static void checkName(String name){
//        KeepWorker w = new KeepWorker();
//        int i=9;
//        assert name!=null:w;
//    }
//
//    static class CreateTest{
//        public int score;
//        public CreateTest(int score){
//            this.score = score;
//            score++;
//            System.out.println(score);
//        }
//    }
    static Person p = new Person(11, "liming");
    public static void main(String[] args) {
        String a = new String("123");
        String b = new String("123");
//        Person a = new Person(18, "lhd");
//        Person b = new Person(18, "lhd");
        System.out.println(a==b);
        System.out.println(a.hashCode()==b.hashCode());
        HashMap<String, String> map = new HashMap<>();
        map.put(a, "card");
        map.put(b, "cat");
        System.out.println(map.get(a));
        System.out.println(map.get(b));


        p = new Person(12, "daming");
        System.out.println(p.getAge());
//        try{
//            System.out.println("throw IOExecption");
//            throw new IOException();
//        }catch (IOException ioe){
//            System.out.println("catch IOExecption");
//        }
//        System.out.println("after catch");
    }
}
class Person{
    int age;
    String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    @Override
    public boolean equals(Object o){
        Person p = (Person)o;
        return p.age==this.age;
    }
    public int getAge(){
        return age;
    }
}
