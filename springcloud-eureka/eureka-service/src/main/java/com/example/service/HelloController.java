package com.example.service;

import com.example.bo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/home")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/homeWithObj")
    public String homeWithObj(@RequestBody Person person) {
        return person.getName() + " say  :" + person.getContent();
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printService() {
        client.getServices().forEach(id -> {
            client.getInstances(id).forEach(instance -> {
                System.out.println("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });
        return "print success";
    }
}
