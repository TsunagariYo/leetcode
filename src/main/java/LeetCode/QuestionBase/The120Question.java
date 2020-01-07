package LeetCode.QuestionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName The120Question
 * @Description 三角形的最小路径和
 * @Author Administrator
 * @Date 2020/1/2 0002 15:14
 */
public class The120Question {

    //递归解决
    int row;

    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        return helper(0, 0, triangle);
    }

    private int helper(int level, int c, List<List<Integer>> triangle) {
        System.out.println("helper: level="+ level+ " c=" + c);
        if (level == row - 1) {
            return triangle.get(level).get(c);
        }
        int left = helper(level + 1, c, triangle);
        int right = helper(level + 1, c + 1, triangle);
        return Math.min(left, right) + triangle.get(level).get(c);
    }

    public static void main(String[] args) {
        The120Question question = new The120Question();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        int i = question.minimumTotal(list);
        System.out.println(i);
    }

}
