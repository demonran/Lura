//package com.sf.user.controller;
//
//import com.sf.user.config.ResourceConfiguration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
///**
// * Created by 01182799 on 2017/1/22.
// */
//
//@RestController
//@RibbonClient(name = "resource", configuration = ResourceConfiguration.class)
//public class UserController {
//
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    @RequestMapping("/hi")
//    public String hi(@RequestParam(value = "name" ,defaultValue = "Liu") String name){
//        String resource = restTemplate.getForObject("http://resource1/resource",String.class);
//        return String.format("%s, %s!", resource, name);
//    }
//
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate()
//    {
//        return new RestTemplate();
//    }
//
//}
