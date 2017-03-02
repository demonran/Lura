package com.lura.portal.controller;




import com.lura.portal.model.http.HRequirements;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 01182799 on 2017/1/22.
 */
@RestController
public class ResourceController {

    private static Logger log = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "访问资源" ,notes="获取用户所需资源")
    @RequestMapping(value="/resource" ,method= RequestMethod.GET)
    public String resource(){
        log.info("Access /resource");
        return "Resource";

    }

    @ApiOperation(value = "打招呼", notes = "和xx打招呼")

            @ApiImplicitParam(name = "name" ,value = "名字")

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestParam(defaultValue = "Lura") String name) {
        log.info("Access /hello");
        return "Hi " + name;

    }


    @RequestMapping(value = "/",method= RequestMethod.GET)
    public String home(HttpSession session) {
        System.out.println(session.getCreationTime());
        System.out.println(session.getLastAccessedTime());
        System.out.println(session.getMaxInactiveInterval());

        log.info("Access /");
        return "Hi!";
    }

    @RequestMapping(value = "/requirements",method= RequestMethod.GET)
    public HRequirements getRequirements(){
        return  restTemplate.getForObject("http://localhost:8001/requirements" , HRequirements.class);

    }

    @RequestMapping(value = "/requirement/{id}",method= RequestMethod.DELETE)
    public String getRequirement(@PathVariable Long id){
         restTemplate.delete("http://localhost:8001/requirement/{id}" ,id);
        return "ok";
    }
}



