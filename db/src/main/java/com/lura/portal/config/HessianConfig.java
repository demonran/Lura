package com.lura.portal.config;

import com.lura.portal.hessian.Hello;
import com.lura.portal.hessian.impl.HelloImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * Created by 01182799 on 2017/3/3.
 */
@Configuration
public class HessianConfig {

    @Bean
    public HessianServiceExporter hessianServiceExporter(){
        System.out.println("----init----------");
        HessianServiceExporter exporter = new HessianServiceExporter();

        exporter.setService(new HelloImpl());
        exporter.setServiceInterface(Hello.class);


        return exporter;

    }
}
