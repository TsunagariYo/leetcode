package Arithmetic.Advanced;

import java.util.HashMap;

/**
 * 动态规划  : 核心要素:最优子结构,边界,状态转移方程式
 * <p>
 * 问题1:有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 *
 * 问题2:
 *
 */
public class DynamicPlanning {
    //问题1:f(n) = f(n-1)+f(n-2) 递归方法解决   时间复杂度O(z^n)
    public static int drawInvStairsS1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return drawInvStairsS1(n - 1) + drawInvStairsS1(n - 2);
    }

    //问题1:备忘录算法  将计算的数据放入map中;      时间复杂度 和  空间复杂度都为O(n)
    public static int drawInvStairsS2(int n, HashMap<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }else {
            int value = drawInvStairsS2(n - 1, map) + drawInvStairsS2(n - 2, map);
            map.put(n,value);
            return value;
        }

    }

    //问题1:动态规划的解法           类似于数学归纳法   时间复杂度O(n) 空间复杂度O(1)
    public static int drawInvStairsS3(int n, HashMap<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a+b;
            a = b;
            b = temp;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println(drawInvStairsS3(10,new HashMap<Integer, Integer>()));
    }
}