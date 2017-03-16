package com.lura.portal.hessian.impl;

import com.lura.portal.hessian.Hello;
import org.springframework.stereotype.Service;

/**
 * Created by 01182799 on 2017/3/3.
 */
@Service("hello")

public class HelloImpl implements Hello{


    @Override
    public String sayHello() {
        return "hello";
    }
}
