package LeetCode.QuestionBase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class The3Question {

    //方法1   滑动窗口方法   (时间复杂度为O(n))
    public static Integer countMaxLengthMethod1(String param){
        //字符串长度;  和返回的最大长度

        int length = param.length(),ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0;end < length; end ++ ){
            char c = param.charAt(end);
            if (map.containsKey(c)){
                //c的索引和start比较
                start = Math.max(map.get(c), start);                        // 疑问:为什么要和start比较
            }
            //比较map集合中的大小
            ans = Math.max(ans, end - start + 1);
            map.put(param.charAt(end),end+1);
        }
        return ans;
    }


    //方法2  暴力法  穷举所有的子列,然后判断 没有重复元素的,然后比较大小
    // 时间复杂度O(n^3)
    public  int countMaxLengthMethod2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }






    public static void main(String[] args) {
        Integer length = countMaxLengthMethod1("aaaa");
        System.out.println(length);

    }
}
