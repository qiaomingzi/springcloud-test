package com.example.servicefeign.web;

import com.example.bo.Person;
import com.example.servicefeign.service.ServiceRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by limz on 2017/4/6.
 */
@RestController
public class IndexController {
    @Autowired
    ServiceRemoteClient serviceRemoteClient;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return serviceRemoteClient.home(name);
    }

    @RequestMapping(value = "/hiObj",method = RequestMethod.GET)
    public String sayHiObj(Person person){
        return serviceRemoteClient.homeWithObj(person);
    }
}
