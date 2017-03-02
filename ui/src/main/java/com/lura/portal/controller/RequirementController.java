package com.lura.portal.controller;

import com.lura.portal.model.http.HRequirements;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by 01182799 on 2017/2/24.
 */
@RestController
public class RequirementController {

    @Autowired
    private RestTemplate template;

    @RequestMapping(value = "/requirements",method= RequestMethod.GET)
    public HRequirements getRequirements(){
        HRequirements  requirements = template.getForObject("http://localhost:8090/requirements", HRequirements.class);
        //System.out.println(requirements.getRequirements());
        return requirements;
    }

    @RequestMapping(value = "/requirement/{id}",method= RequestMethod.DELETE)
    public String deleteRequirement(@PathVariable long id){
         template.delete("http://localhost:8090/requirement/{id}",id);


        return "{\"status\":\"ok\"}";
    }
}
