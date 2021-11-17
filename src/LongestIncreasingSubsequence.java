import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,1,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS_greedy(nums));
    }
    // 动态规划求解，O(n^2)
    // 定义dp[i] 为考虑前 i个元素，【以第 i 个数字结尾】的最长上升子序列的长度，注意 nums[i] 必须被选取
    public int lengthOfLIS_dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0 ; j <i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    // 贪心算法 + 二分查找
    // d[i] 表示长度为 i 的最长上升子序列的末尾元素的最小值
    public int lengthOfLIS_greedy (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] d = new int[nums.length+1];
        d[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                int l = 1 ;int r = len;
                int pos = 0;
                // 找到最后一个比num[i]小的数
                while (l <= r) {
                    int mid = (r - l) / 2 + l;
                    if (d[mid] < nums[i]) {
                        pos = mid ;
                        l = mid + 1;
                    } else {
                        r = mid -1;
                    }
                }
                d[pos+1] = nums[i];
            }
        }
        return  len;
    }
}
