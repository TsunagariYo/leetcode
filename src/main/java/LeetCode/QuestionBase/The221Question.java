package LeetCode.QuestionBase;

/**
 * @ClassName The221Question
 * @Description 最大正方形
 * @Author Administrator
 * @Date 2020/1/7 0007 10:15
 * 描述:在一个二维矩阵中找出都为1的正方形矩阵,并求出它的面积
 */
public class The221Question {
    //方法1 暴力法
    public static int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, colr = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colr; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < colr && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            sqlen++;
                        }
                    }
                    if (maxsqlen < sqlen) maxsqlen = sqlen;
                }

            }
        }
        return maxsqlen * maxsqlen;
    }

    //方法二  动态规划   关键 dp[i,j] = min(dp[i-1,j],dp[i,j-1],dp[i-1,j-1])+1   采用动态规划
    // 思路:形成一个表示每个位置形成正方形的边长的矩阵,即在一个四格的正方形中:右下的位置如果非0,则右下的值为其他三个位置的数的最小值+1决定的
    // 已达到满足动态规划的步骤
    //时间复杂度：O(mn)。
    //空间复杂度：O(mn),用了一个大小相同的矩阵 dp。
    public static int maximalSquare2(char[][] matrix) {
        int row = matrix.length, cols = row > 0 ? matrix[0].length : 0;
        int[][] dp = new int[row + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen;
    }

    //方法三  优化方法2
    //时间复杂度：O(mn)。
    //空间复杂度：O(n)，使用了一个一维数组 dp。
    // dp数组为每一行的数,然后会每到下一行,会进行更新 需要比较的三个数字是,上次dp的两个值和当前更新完成的前一个数值
    public static int maximalSquare3(char[][] matrix) {
        int row = matrix.length, cols = row > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0,prev = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen;
    }
    public static void main(String[] args) {
        char[][] arr = {{'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
        };
        System.out.println(maximalSquare3(arr));
    }
}
