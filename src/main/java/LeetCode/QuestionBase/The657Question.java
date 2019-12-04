package LeetCode.QuestionBase;

import java.util.jar.JarEntry;

/**
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * <p>
 * 输入: "UD"
 * 输出: true
 */
public class The657Question {
    public static boolean judgeCircle(String moves) {
        int indexX = 0;
        int indexY = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                indexX += 1;
            } else if (c == 'L') {
                indexX -= 1;
            }else if (c == 'U') {
                indexY += 1;
            }else if (c == 'D') {
                indexY -= 1;
            }
        }
        if (indexX == 0 && indexY == 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean b = judgeCircle("UU");
        System.out.println(b);
    }
}
