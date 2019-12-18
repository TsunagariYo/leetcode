package LeetCode.QuestionBase;

/**
 * 求解方程
 */
public class The640Question {
    public static String solveEquation(String equation) {
        //coefficient为x的系数;constant为常数项
        int coefficient = 0, constant = 0;
        equation = equation + "#";
        Integer num = null;
        int sign = 1, left = 1;
        for (char c : equation.toCharArray()) {
            //如果c为数据
            if ('0' <= c && '9' >= c) {
                //当数字为多位的时候*10,进位
                num = (num == null) ? c - '0' : num * 10 + c - '0';
            } else if (c == 'x') {
                //得到系数
                coefficient += left * sign * (num == null ? 1 : num);
                //重置
                sign = 1;
                num = null;
            } else if (c == '+' || c == '-' || c == '#') {
               //得到常数
                if (num != null) {
                    constant += left * sign * num;
                    num = null;
                }
                sign = c == '+' ? 1 : -1;
            } else {// if (c == '=')
                if (num != null) {
                    constant += left * sign * num;
                    num = null;
                }
                left = -1;
                sign = 1;
            }
        }

        if (coefficient == 0 && constant == 0) {
            return "Infinite solutions";
        } else if (coefficient == 0 && constant != 0) {
            return "No solution";
        } else {
            return "x=" + String.valueOf(-constant / coefficient);
        }
    }

    public static void main(String[] args) {
        String s = solveEquation("x+5-3+x=6+x-2");
        System.out.println(s);
    }

}
