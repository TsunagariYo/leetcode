package LeetCode.QuestionBase;

import java.math.BigDecimal;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class The50Question {

    //方法1  暴力法  时间复杂度：O(n)          空间复杂度：O(1)O(1)
    public static Double countPower1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }

    //快速幂的方法  时间复杂度：O(logn).  空间复杂度：O(logn)
    public static Double countPower2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return halfPower(x, N);

    }

    public static double halfPower(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        //递归的方式使得它的时间复杂度为logn
        double half = halfPower(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    //方法3   快速幂算法（循环）  时间复杂度：O(logn)   空间复杂的：O(1).
    public static double countPower3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            //奇数次幂
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }

        return ans;
    }

    public static void main(String[] args) {
        Double aDouble = countPower3(2, -1);
        System.out.println(aDouble);
    }

}
