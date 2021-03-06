package com.lura.portal.controller;

import com.lura.portal.hessian.Hello;
import com.lura.portal.hessian.impl.HelloImpl;
import com.lura.portal.model.RequirementConverter;
import com.lura.portal.model.http.HRequirements;
import com.lura.portal.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.caucho.HessianExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liuran on 2017/2/25.
 */

@RestController
public class DBController {

    @Autowired
    private HessianServiceExporter exporter;

    @Autowired
    private RequirementRepository requirementRepository;


    @RequestMapping(value = "/requirements" ,method = RequestMethod.POST)
    public String saveRequirement( @RequestBody HRequirements hRequirements){


        requirementRepository.save(RequirementConverter.HConvertToD(hRequirements));
        return "ok";
    }

    @RequestMapping(value = "/requirements" ,method = RequestMethod.GET)
    public HRequirements getRequirements(){

        HRequirements  requirements =  RequirementConverter.DConvertToH(requirementRepository.findAll());
        requirements.setStatus(200);
        return requirements;
    }

    @RequestMapping(value = "/requirement/{id}" ,method = RequestMethod.DELETE)
    public String deleteRequirement(@PathVariable Long id){

        requirementRepository.delete(id);


        return "ok";
    }
}
