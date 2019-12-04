package LeetCode.QuestionBase;

/**
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 *
 * 你可以按照下面的规则在平面上移动：
 *
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 *
 */
public class The1266Question {
    public int minTimeToVisitAllPoints(int[][] points) {

        int time = 0;

        for(int i = 1;i<points.length;i++){
            time += secondBetween2Points(points[i],points[i-1]);
        }
        return time;
    }
    private int secondBetween2Points(int[] pointA, int[] pointB){
        return Math.max(Math.abs(pointA[1]-pointB[1]),Math.abs(pointA[0]-pointB[0]));
    }

}
