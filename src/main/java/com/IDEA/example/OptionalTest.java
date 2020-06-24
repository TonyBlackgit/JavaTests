package com.IDEA.example;

import java.util.Optional;

public class OptionalTest {


    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.givenEmptyValue_whenCompare_thenOk();
    }

    //of, ofNullable, empty
    //get, orElse, orElseGet
    public void givenEmptyValue_whenCompare_thenOk() {
        User user = new User("lisi", "lisi@163.com");
        System.out.println("Using orElse");
        Optional<User> op = Optional.ofNullable(user);
        User result = op.orElse(createNewUser());
        System.out.println("Using orElseGet");
        User result2 = op.orElseGet(() -> createNewUser());
    }

    //orElseThrow
    public void whenThrowExecption() throws IllegalAccessException {
        User user = null;
        User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalAccessException());
    }

    //filter
    public void whenFilter_thenok(){
        User user = new User("wangwu", "wangwu@163.com");
        User result = Optional.ofNullable(user).filter(u->u.getEmail().contains("@")).orElseGet(()->createNewUser());
        System.out.println(result);
    }
    //map
    public void whenMap_thenOK(){
        User user = new User("wangwu", "wangwu@163.com");
        String name = Optional.ofNullable(user).map(u-> u.getName()).orElseGet(()-> createNewUser().getName());
        System.out.println(name);
    }


    private User createNewUser() {
        System.out.println("Creating New User");
        return new User("zhangsan", "extra@gmail.com");
    }
}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
    public String toString(){
        return this.getName()+this.getEmail();
    }
}