package LeetCode.QuestionBase;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * <p>
 * 返回到达终点需要的最小移动次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3
 */
public class The754Question {
    public int reachNumber(int target) {
        //k值的累加
        int sum= 0;
        int i =0;
        int a = Math.abs(target);
        while(sum<a||(sum-a)%2!=0){
            sum+=i;
            i++;
        }
        return i-1;//因为在判断结果前都要让i+1，所以这里返回的是i-1
    }
}
