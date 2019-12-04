package LeetCode.QuestionBase;


/**
 * 求平方根
 */
public class The69Question {

    //二分查找法时间复杂度：O(logN)空间复杂度：O(1)
    public static int countSqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1;
        int end = x / 2 + 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;

    }

    int a;

    //牛顿法
    public int countSqrt1(int x) {
        a = x;
        if (a == 0 || a == 1) {
            return a;
        }

        return (int)sqrt(x);

    }

    public double sqrt(double x0) {
        //f(x) = f(x0) + (x-x0)f'(x0) 得到
        double x = (x0 + a / x0) / 2;
        //迭代
        if ((int)x == (int) x0){
            return x;
        }else {
           return sqrt(x);
        }

    }

    public static void main(String[] args) {

        The69Question question = new The69Question();
        int i = question.countSqrt1(99);
        System.out.println(i);
    }
}
