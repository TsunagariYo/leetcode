package LeetCode.QuestionBase;

import org.apache.poi.ss.formula.functions.Count;

import java.util.HashMap;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class The136Question {

    //异或法,异或具有交换律和结合律
    public static int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

    //hash表的方法
    public static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            Integer value = map.get(key);
            //将数组里的只作为key,重复次数作为value
            value = value == null ? 1 : ++value;
            map.put(key, value);
        }
        //获得value为1的key
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value == 1) {
                return key;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(singleNumber1(arr));
    }
}

