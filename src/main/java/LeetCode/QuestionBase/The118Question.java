package LeetCode.QuestionBase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class The118Question {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> triangle  = new ArrayList<>();//存放的总集合
        //如果行数为0返回空集合
        if (numRows ==0){
            return triangle;
        }
        //第一行为1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        //从第二行开始
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            //每行存储位置
            ArrayList<Integer> row = new ArrayList<>();
            //获得上一行的数据
            List<Integer> prevRow = triangle.get(rowNum - 1);
            //添加改行的第一个数据
            row.add(1);
            //每行里添加数据,第一个数据已经添加所以从第二个开始到倒数第二个位置
            for (int j = 1; j <rowNum ; j++) {
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            //最后一行加1
            row.add(1);
            //添加每行到总的集合中
            triangle.add(row);


        }
        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(10);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }

}
