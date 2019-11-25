package LeetCode.QuestionBase;



/**
 * 整数反转
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class The7Question {

    //方法1   转化为字符串
    public static int revert1(int x) {
        //转化为字符串
        String a = Integer.toString(x);
        //判断正负
        int b = 1;
        if(a.charAt(0) == '-') {
            a = a.substring(1);
            b = -1;
        }
        //字符数组
        char[] chars = a.toCharArray();
        char[] chars1 = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars1[chars.length - 1 - i] = chars[i];
        }
        //转化为long
        Long aLong = Long.valueOf(new String(chars1));
        //判断取值范围
        if(aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (aLong * b);
    }
    //方法2  官方的方法
    public static int revert2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;   //每次最后一位的数
            x /= 10;            //其余位数的数
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;  //判断溢出
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0; //判断溢出
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
        int l = revert2(-110);
        System.out.println(l);
    }

}
