package UtileS.DatetoFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateForTimeBug
 * @Description 日期类型转化的Bug;
 * @Author Administrator
 * @Date 2020/1/2 0002 15:55
 * @reason YYYY表示这一年的最后一个周所在的年份
 */
public class DateForTimeBug {


    public static void main(String[] args) throws ParseException {
        printBugDate();
    }

    public static void printBugDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = sdf.parse("2020-1-1 13:12:12");
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);
    }
}
