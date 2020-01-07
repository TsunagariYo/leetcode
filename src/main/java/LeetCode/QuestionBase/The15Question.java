package LeetCode.QuestionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName The15Question
 * @Description 一个数组中三数之和为零输出
 * @Author Administrator
 * @Date 2019/12/26 0026 10:09
 */
public class The15Question {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 3) return ans;
        Arrays.sort(nums);  //排序

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;  //因为是排序,所以当第一个数字大于0后,则和肯定大于0;
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //已经确认的数字,再次确认,就会出现相同的可能;  去重
            int L = i + 1;      //i后左边的数字
            int R = length - 1; //i后右边的数字
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; //若L重复则进行下次判断,去重
                    while (L < R && nums[R] == nums[R - 1]) R--; //若R重复则进行下次判断,去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;    //由于和小于0  则需要增大左边的数字
                } else if (sum > 0) {
                    R--;   //由于和过小,所以需要减小,则右移R
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        int [] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(arr);
        for (List<Integer> integers : threeSum) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

}
