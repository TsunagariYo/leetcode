import java.util.Arrays;

/**
 * @ClassName recursion
 * @Description 递归算法
 * @Author Administrator
 * @Date 2019/12/20 0020 16:50
 */
public class recursion {
    //递归算法
    //实现阶乘
    static int factorial(int num) {
        int m;
        if (num == 1) {
            m = 1;
        } else {
            m = num * factorial(num - 1);
        }
        return m;
    }

    //递归求斐波那契数列
    static int fibnCArr(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibnCArr(n - 1) + fibnCArr(n - 2);
        }
    }

    public static void main(String[] args) {
        int i = fibnCArr(5);
        System.out.println(i);
    }
}
