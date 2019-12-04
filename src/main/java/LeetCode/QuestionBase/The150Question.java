package LeetCode.QuestionBase;

import java.util.Stack;

/**
 * 逆波兰表达式
 * <p>
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class The150Question {
    //通过栈的特性计算
    public static int evalRPN(String[] tokens) {
        //计算数值的栈
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                //加法
                stack.push(stack.pop()+stack.pop());
            } else if (s.equals("-")) {
                //减法
                stack.push(-stack.pop()+stack.pop());
            } else if (s.equals("*")) {
                //乘法
                stack.push(stack.pop()*stack.pop());
            } else if (s.equals("/")) {
                //除法
                Integer num1 = stack.pop();
                stack.push(stack.pop()/num1);
            } else {
                //数字    将数字放入栈中
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        String [] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = evalRPN(arr);
        System.out.println(i);
    }
}
