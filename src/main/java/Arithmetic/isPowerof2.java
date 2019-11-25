package Arithmetic;

/**
 * 判断一个数是否是2的平方
 */
public class isPowerof2 {
    //方法1
    public static boolean method1(Integer num) {
        int temp = 1;
        while (temp < num) {
            if (temp == num) return true;
            temp = temp * 2;
        }
        return false;
    }

    //方法2
    public static boolean method2(Integer num) {
        return (num & num - 1) == 0;
    }


    public static void main(String[] args) {
        boolean powerof = method1(64);
        System.out.println(powerof);
    }
}
