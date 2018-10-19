package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InvokerService {

    @Autowired
    RestTemplate restTemplate;

    public String invoker(String name) {
        return restTemplate.getForObject("http://service-provider/home?name=" + name, String.class);
    }

}
