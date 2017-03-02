package com.lura.portal.utils;

import io.swagger.models.auth.In;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuran on 2017/2/25.
 */
public class ExcelUtils {

    private static int index = 0;


    public  static <T> List<T> importExcel(InputStream is , Class<T> clazz){

        //内容
        List<T> objs = new ArrayList<>();

        try {
            //用WorkbookFactory 创建WB，兼容2007和2010版本。
            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheetAt(0);

            //获取表头
            Row row = sheet.getRow(0);

            //标题
            List<String> titles = new ArrayList<>();


            for (int i =0;i<row.getLastCellNum();i++)
            {
                Cell cell = row.getCell(i);
                titles.add(cell.getStringCellValue());
            }

            titles.forEach(title->System.out.print(title+","));

            for(int i=1;i<=sheet.getLastRowNum();i++){

                T obj = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                row = sheet.getRow(i);

                boolean noEmpty = false;
                for (int j=0;j<fields.length;j++)
                {
                    Cell cell = row.getCell(j);
                    fields[j].setAccessible(true);

                    Object fieldValue = getCellValue(fields[j].getType().getName(),cell);
                    fields[j].set(obj,fieldValue);
//

                    if(fieldValue != null && !fieldValue.equals("") && !fieldValue.toString().equals("0")){

                        noEmpty = true;
                    }

                }
                //所有字段都为null则不保存
                if(noEmpty){
                    objs.add(obj);
                }


            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(objs.size());
        return objs;

    }

    public static void exportExcel(String[] titles , List<Object> entitys){
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建sheet
        HSSFSheet sheet = wb.createSheet("需求表");
        //设置表头
        HSSFRow row = sheet.createRow(0);

        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);



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



    /**
     * 描述：对表格中数值进行格式化
     * @param cell
     * @return
     */
    private static Object getCellValue(String fieldType , Cell cell){

        Object value = null;
        if(cell == null){
            return value;
        }

        if(fieldType.endsWith("Integer") )
        {
            value = (int) cell.getNumericCellValue();

        }else if(fieldType.endsWith("Long"))
        {
            value = (long) cell.getNumericCellValue();
        }
        else if(fieldType.endsWith("Date"))
        {
            value =  cell.getDateCellValue();
        }
        else if(fieldType.endsWith("boolean"))
        {
            value =  cell.getBooleanCellValue();
        }
        else
        {
            value =  cell.getStringCellValue();
        }


        return value;
    }
}
