package LeetCode.QuestionBase;

/**
 * 验证回文串
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class The125Question {

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            //Character.isLetterOrDigit(char ch)  确定指定的字符是字母还是数字。
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }



    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
}
