package com.example.springannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main02(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        DemoService myBean = ctx.getBean(DemoService.class);
        myBean.doSomething();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.example.springannotation");
        DemoService ds = context.getBean(DemoService.class);
        ds.doSomethingWithArgu(null);
    }
}
