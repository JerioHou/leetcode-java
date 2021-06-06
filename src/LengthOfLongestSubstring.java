import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("111111"));
        System.out.println(lengthOfLongestSubstring("abababab"));
    }



    public static int lengthOfLongestSubstring(String s){
        Set<Character> charSet = new HashSet<>();
        int len = s.length();
        int max = 0;
        int right = 0;
        for (int i = 0 ; i < len; i ++) {
            if (i > 0) {
                charSet.remove(s.charAt(i-1));
            }
            while (right < len && !charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                right++;
            }
            max = Math.max(max,charSet.size());
        }
        return max;
    }
}
