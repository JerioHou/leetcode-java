/**
 *
 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(7));
    }

    private static Boolean judgeSquareSum(int c){
        int i = 0,j = (int) Math.sqrt(c);;
        while (i <= j) {
            int result = i * i + j * j;
            if (result == c) {
                return true;
            }
            if (result > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
