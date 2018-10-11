package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
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
