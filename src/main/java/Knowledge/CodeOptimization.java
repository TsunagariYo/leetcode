package Knowledge;

import UtileS.ExportToExcel.Student;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CodeOptimization
 * @Description 代码优化
 * @Author Administrator
 * @Date 2020/1/2 0002 16:08
 */
public class CodeOptimization {
    /**
     * 性能优化
     */
    public void performance() {
        //1.map集合的遍历时候,当只需要主键的时候 使用keyset;当需要键和值时使用entryset
        //2.使用collection.isEmpty()替代collection.size() == 0;
        //3.集合初始化尽量指定大小
        //4.字符串拼接使用StringBuilder
        //5.频繁调用 Collection.contains 方法请使用 Set集合
    }


    public static void main(String[] args) {
        //bug1
        BigDecimal decimal = new BigDecimal(0.1D);//0.1000000000000000055511151231257827021181583404541015625
        BigDecimal value = BigDecimal.valueOf(0.1D);//0.1

        String[] split = "a.ab.abc".split("\\.");
        for (String s : split) {
            System.out.print(s + " "); //空
        }
        System.out.println();
        String[] strings = "a|ab|abc".split("\\|");
        for (String string : strings) {
            System.out.print(string + " ");
        }
        int a = 2;
        int b = 2;
        int c =a--+b;
        System.out.println(c);

        float x = 1f;
        float y = 2f;
        float z = 3f;
        System.out.println(z--/2f);
        System.out.println(y+=z--/++x);

        String s = "helloworld";
        
        System.out.println();
    }

}
