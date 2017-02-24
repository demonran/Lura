//package com.sf.user.config;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.AvailabilityFilteringRule;
//import com.netflix.loadbalancer.IPing;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.PingUrl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//
///**
// * Created by 01182799 on 2017/1/22.
// */
//public class ResourceConfiguration {
//    @Autowired
//    IClientConfig ribbonClientConfig;
//
//    @Bean
//    public IPing ribbonPing(IClientConfig config) {
//        return new PingUrl();
//    }
//
//    @Bean
//    public IRule ribbonRule(IClientConfig config) {
//        return new AvailabilityFilteringRule();
//    }
//}
