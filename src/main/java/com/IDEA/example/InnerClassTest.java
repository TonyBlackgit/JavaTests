package com.IDEA.example;

public class InnerClassTest {
    public Card normalCard;
    public static Card staticCard;

    public InnerClassTest(int num){
        normalCard = new Card(num);
        staticCard = new Card(num);
    }
    static class staticOne{
        private static int i;
        private static void play(){
            System.out.println("go");
        }
    }

    class normalOne{
        //普通内部类不能声明静态成员变量和方法
//        private static int i;
//        private static void play(){
//            System.out.println("go");
//        }

    }
}

class Card{
    private int num;
    public Card(int num) {
        this.num = num;
    }
}