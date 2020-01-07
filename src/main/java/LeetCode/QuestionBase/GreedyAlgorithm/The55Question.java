package LeetCode.QuestionBase.GreedyAlgorithm;

/**
 * @ClassName The55Question
 * @Description
 * @Author Administrator
 * @Date 2019/12/26 0026 14:05
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class The55Question {
    //贪心算法,解题
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        boolean jump = canJump(arr);
        System.out.println(jump);
    }
}