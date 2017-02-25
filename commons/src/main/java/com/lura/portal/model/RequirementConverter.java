package com.lura.portal.model;

import com.lura.portal.model.db.DRequirement;
import com.lura.portal.model.http.HRequirements;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuran on 2017/2/25.
 */
public class RequirementConverter {

    public static List<DRequirement> HConvertToD(HRequirements requirements){
        return requirements.getRequirements().stream().map(requirement -> {
            DRequirement dReq = new DRequirement();
            dReq.setName(requirement.getName());
            dReq.setDetail(requirement.getDetail());
            dReq.setDeveloper(requirement.getDeveloper());
            dReq.setDevelopTime(requirement.getDevelopTime());
            dReq.setExpectedUpdateTime(requirement.getExpectedUpdateTime());
            dReq.setRemarks(requirement.getRemarks());
            dReq.setSubmitter(requirement.getSubmitter());
            dReq.setSysCode(requirement.getSysCode());
            dReq.setTester(requirement.getTester());
            dReq.setTestTime(requirement.getTestTime());
            dReq.setStatus(requirement.getStatus());
            return dReq;
        }).collect(Collectors.toList());
    }

    public static HRequirements.Requirement DConvertToH(DRequirement requirement){

            HRequirements.Requirement req = new HRequirements.Requirement();
            req.setId(requirement.getId());
            req.setName(requirement.getName());
            req.setDetail(requirement.getDetail());
            req.setDeveloper(requirement.getDeveloper());
            req.setDevelopTime(requirement.getDevelopTime());
            req.setExpectedUpdateTime(requirement.getExpectedUpdateTime());
            req.setRemarks(requirement.getRemarks());
            req.setSubmitter(requirement.getSubmitter());
            req.setSysCode(requirement.getSysCode());
            req.setTester(requirement.getTester());
            req.setTestTime(requirement.getTestTime());
            req.setStatus(requirement.getStatus());
            return req;

    }

    public static HRequirements DConvertToH(Iterable<DRequirement> dRequirements){
        HRequirements requirements = new HRequirements();

        dRequirements.forEach(( dReq) ->{
            requirements.addRequirement(DConvertToH(dReq));
        });

        return requirements;
    }

}
