package com.lura.portal.service;

import com.lura.portal.model.http.HRequirements;
import com.lura.portal.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuran on 2017/2/25.
 */
public class ExcelService {

    private String[] titles = { "编号","需求标题","需求内容简介","所属系统","计划上线时间","需求人","开发时间","开发人员","测试时间","测试人员","备注","状态"};

    public void excelExport(List list){
        ExcelUtils.exportExcel( titles,list );
    }

    public static void main(String[] args){




        new ExcelService().excelExport(new RestTemplate().getForObject("http://localhost:8001/requirements",HRequirements.class).getRequirements());

    }

}
