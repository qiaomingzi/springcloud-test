package com.example.web;

import com.example.service.InvokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloControler {

    @Autowired
    InvokerService invokerService;

    @RequestMapping(value = "/index")
    public String index(@RequestParam(defaultValue = "limz") String name) {
        return invokerService.invoker(name);
    }
}
