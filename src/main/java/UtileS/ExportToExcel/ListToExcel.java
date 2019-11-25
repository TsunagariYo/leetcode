package UtileS.ExportToExcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ListToExcel {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", "1132132", 13, new Date()));
        list.add(new Student("张三", "1132132", 13, new Date()));
        list.add(new Student("张三", "1132132", 13, new Date()));
        list.add(new Student("张三", "1132132", 13, new Date()));
        list.add(new Student("张三", "1132132", 13, new Date()));

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("table");
        String[] title = {"姓名", "密码", "年龄", "出生日期"};
        HSSFRow row;
        HSSFCell cell = null;
        for (int i = 0; i <= list.size(); i++) {
            row = sheet.createRow(i);//创建表格行
            for (int j = 0; j < title.length; j++) {
                cell = row.createCell(j);//根据表格行创建单元格
                if (i == 0) {
                    cell.setCellValue(title[j]);
                } else {

                    if (j == 0){
                        cell.setCellValue(String.valueOf(list.get(i-1).getUsername()));
                    } if (j == 1){
                        cell.setCellValue(String.valueOf(list.get(i-1).getPassword()));
                    } if (j == 2){
                        cell.setCellValue(String.valueOf(list.get(i-1).getAge()));
                    } if (j == 3){
                        cell.setCellValue(String.valueOf(list.get(i-1).getDate()));
                    }

                }
            }
        }
        wb.write(new FileOutputStream("D:\\Excle\\table.xls"));
        wb.close();
    }
}
