package com.example.servicefeign.service;

import com.example.bo.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by limz on 2017/4/6.
 */
@FeignClient(value = "service-provider")
@Service
public interface ServiceRemoteClient {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/homeWithObj", method = RequestMethod.GET)
    //String homeWithObj(Person person);
    String homeWithObj(@RequestBody Person person);
}
