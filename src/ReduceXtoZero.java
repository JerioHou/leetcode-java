/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 *
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 *
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReduceXtoZero {


    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(new ReduceXtoZero().minOperations(nums,6));
    }

    public int minOperations(int[] nums, int x) {
//        return backTrack(nums,x,0,nums.length-1,0);
        int left = 0;int right = 0;
        int maxLength = -1;
        int sum = 0;
        for (int i = 0 ; i < nums.length;i++) {
            sum += nums[i];
        }
        if (sum == x) {
            return nums.length;
        }
        int count = sum - x;
        if (count < 0) {
            return -1;
        }
        int currSum = 0;
        while (right < nums.length) {
            currSum += nums[right];
            while (currSum > count) {
                currSum -= nums[left];
                left++;
            }

            if ( currSum == count) {
                maxLength = Math.max(maxLength,right-left + 1);
            }
            right++;
        }
        return maxLength == -1 ? maxLength : nums.length-maxLength;
    }


    /**
     *  此方法超时
     * @param nums
     * @param x
     * @param left
     * @param right
     * @param currStep
     * @return
     */
    private int backTrack(int[] nums, int x,int left, int right,int currStep) {
        if (left > right) {
            return -1;
        }
        if (x - nums[left] == 0 || x - nums[right] == 0) {
            return ++currStep;
        } else if (x - nums[left] < 0 && x - nums[right] < 0) {
            return -1;
        } else if (x - nums[left] > 0 && x - nums[right] < 0) {
            return backTrack(nums,x-nums[left],++left,right,++currStep);
        } else if (x - nums[left] < 0 && x - nums[right] > 0) {
            return backTrack(nums,x-nums[right],left,--right,++currStep);
        } else {
            int a = backTrack(nums,x-nums[left],++left,right,++currStep);
            int b = backTrack(nums,x-nums[right],left,--right,currStep);
            return a == -1 ? b : (b == -1 ? a : Math.min(a,b));
        }
    }
}
