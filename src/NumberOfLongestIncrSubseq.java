

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfLongestIncrSubseq {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new NumberOfLongestIncrSubseq().findNumberOfLIS(nums));
    }
    // 动态规划
    public int findNumberOfLIS(int[] nums) {
        // 最长子序列的 个数
        int result = 0, n = nums.length,maxLen = 0;
        // dp[i] 表示dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度
        int[] dp = new int[n];
        //cnt[i] 表示以 nums[i] 结尾的最长上升子序列的个数
        int[] cnt = new int[n];
        for (int i = 0 ; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if (dp[j] + 1 == dp[i]) {
                        cnt[i] = cnt[j] + cnt[i];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                result = cnt[i];
            } else if (dp[i] == maxLen) {
                result += cnt[i];
            }
        }
        return result;
    }
}