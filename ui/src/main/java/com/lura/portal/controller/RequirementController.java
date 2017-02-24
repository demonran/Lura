package com.lura.portal.controller;

import com.lura.portal.model.http.HRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        return requirements;
    }
}
