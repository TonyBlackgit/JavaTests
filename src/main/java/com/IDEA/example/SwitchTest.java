package com.IDEA.example;

public class SwitchTest {
    public static void main(String[] args) {
        int a =1;
        switch(a){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            case 9:
                System.out.println("9");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
