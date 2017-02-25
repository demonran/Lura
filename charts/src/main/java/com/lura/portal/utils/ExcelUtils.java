package com.lura.portal.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuran on 2017/2/25.
 */
public class ExcelUtils {

    private static int index = 0;

    public static void exportExcel(String[] titles , List<Object> entitys){
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建sheet
        HSSFSheet sheet = wb.createSheet("需求表");
        //设置表头
        HSSFRow row = sheet.createRow(0);

        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);



        Arrays.asList(titles).forEach(title -> {
            HSSFCell cell = row.createCell(index++);
            cell.setCellValue(title);
            cell.setCellStyle(style);
        });

        insertEntity(sheet,entitys);



        // 第六步，将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream("D:/students.xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static  void  insertEntity(HSSFSheet sheet , List<Object> entitys ){

        for(int i =0;i<entitys.size();i++){

            HSSFRow row = sheet.createRow(i+1);

            final Object entity = entitys.get(i);

            Class clazz = entity.getClass();

//            System.out.println(clazz.getName());
//            System.out.println(clazz.getDeclaredFields());

            index = 0;
            Arrays.asList( clazz.getDeclaredFields()).forEach( field ->{
//                System.out.println(field.getName());
                field.setAccessible(true);
                HSSFCell cell  =  row.createCell(index ++ );
                try {
                    Object val = field.get(entity);
                  //  String type = field.getType().toString();

                    if(val == null){
                        cell.setCellValue("");
                    }else{
                        cell.setCellValue(val.toString());
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}