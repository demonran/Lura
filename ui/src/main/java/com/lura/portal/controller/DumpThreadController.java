package com.lura.portal.controller;

import com.codahale.metrics.jvm.ThreadDump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by 01182799 on 2017/3/16.
 */
@RestController
@RequestMapping("/management")
public class DumpThreadController {


    private ThreadMXBean threadMXBean;

    @PostConstruct
    public void init(){
        this.threadMXBean =   ManagementFactory.getThreadMXBean();
    }

    @RequestMapping(value = "dump" , method = RequestMethod.GET)
    public ThreadInfo[] threadInfos(){
        return threadMXBean.dumpAllThreads(true,true);
    }




}
