package com.example.springannotation;

import org.springframework.lang.NonNull;

public class DemoService {
    public void doSomething(){
        System.out.println("========everything is all fine===========");
    }
    public void doSomethingWithArgu(@NonNull String name){
        System.out.println("========"+name+"===========");
    }
}
