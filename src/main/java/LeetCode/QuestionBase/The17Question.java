package LeetCode.QuestionBase;

import java.util.*;

/**
 * @ClassName The17Question
 * @Description 电话号码的字母组合
 * @Author Administrator
 * @Date 2019/12/18 0018 18:09
 * <p>
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class The17Question {
    //字典
    private Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    //回溯
    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            //获得第一个数字
            String digit = next_digits.substring(0, 1);
            //获得数字对应的字母
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                //获得每个字母
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        The17Question question = new The17Question();
        List<String> list = question.letterCombinations("22");
        System.out.println(list);

    }
}
