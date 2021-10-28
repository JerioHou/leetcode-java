/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class ClimbingStairs {
    /**
     * 状态转移方程为： f(X) = f(x-1) + f(x-2)
     */
    public static int climbStairs(int n) {
        int x1 = 0 ,x2 = 0;
        int i = 1;
        int result = 1;
        while ( i <= n) {
            x2 = x1;
            x1 = result;
            result = x1 + x2;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
    }

}
