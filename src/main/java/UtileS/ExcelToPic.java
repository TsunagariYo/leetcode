package UtileS;
import com.spire.xls.*;
/**
 * @ClassName ExcelToPic
 * @Description Excel表格转化为图片
 * @Author Administrator
 * @Date 2019/12/24 0024 11:34
 *
 * https://www.lagou.com/lgeduarticle/81907.html
 */
public class ExcelToPic {

    public static void main(String[] args) {
        //加载Excel工作表
        long start = System.currentTimeMillis();
        Workbook wb = new Workbook();
        wb.loadFromFile("D:\\Test.xls");

        //获取工作表
        int count = wb.getWorksheets().getCount();
        for (int i = 0; i < count; i++) {
            Worksheet sheet = wb.getWorksheets().get(i);
            sheet.saveToImage("D:\\"+"sheet"+i+".png");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
}
