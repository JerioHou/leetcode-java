/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {



    public static int firstMissingPositive(int[] nums) {
        int min = 0;
        int max = 0;
        // 负数的个数
        int count = 0;
        for (int i =0;i<nums.length;i++){
            if (nums[i] < 0) {
                count++;
                continue;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return 0;
    }
}
