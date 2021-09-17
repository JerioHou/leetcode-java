import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        int maxLength = 1;
        int begin = 0;
        int n = s.length();
        if (n == 1)
            return s;
        // arr[i][j] 表示字符长 i->j 是回文字符串
        boolean[][] arr = new boolean[n][n];
        for(int i=0; i < n; i++) {
            arr[i][i] = true;
        }
        // 遍历截取的字符串长度
        // 先截取所有长度=2的，再截取长度=3的，以此类推
        char[] chars = s.toCharArray();
        int step = 2;
        for (;step <= n; step++){
            for (int i=0;i < n-1;i++){
                int j = i + step -1;
                if (j >= n) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    arr[i][j] = false;
                    continue;
                }
                // 两端字符串相当
                if (j -i <= 2) {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = arr[i+1][j-1];
                }
                if (arr[i][j]) {
                    if (j-i+1 > maxLength) {
                        begin = i;
                        maxLength = j-i+1;
                    }
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }
}
