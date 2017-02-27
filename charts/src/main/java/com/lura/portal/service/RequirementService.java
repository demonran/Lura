package com.lura.portal.service;

import com.lura.portal.model.http.HRequirements;
import com.lura.portal.utils.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liuran on 2017/2/25.
 */
//@Service
public class RequirementService {

    private String[] titles = { "编号","需求标题","需求内容简介","所属系统","计划上线时间","需求人","开发时间","开发人员","测试时间","测试人员","备注","状态"};

    private RestTemplate restTemplate;

    public void exportExcel(List list){
        ExcelUtils.exportExcel( titles,list );
    }

    public void importExcel(InputStream is){
        List<HRequirements.Requirement> reqs = ExcelUtils.importExcel( is, HRequirements.Requirement.class);

        HRequirements requirements = new HRequirements();
        requirements.addRequirement(reqs);

        restTemplate = new RestTemplate();

        String res = restTemplate.postForObject("http://localhost:8001/requirements",requirements,String.class);
        System.out.println(res);
    }

    public static void main(String[] args) throws FileNotFoundException {


        new RequirementService().importExcel(new FileInputStream("E:\\share\\官网积分系统需求\\官网积分需求统计文档.xlsx"));

//        new ExcelService().exportExcel(new RestTemplate().getForObject("http://localhost:8001/requirements",HRequirements.class).getRequirements());

    }

}
