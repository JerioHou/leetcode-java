import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums,100));
    }

    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int best = 10000;
        int n = nums.length;
        for (int i = 0 ; i < n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = n -1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum-target) < Math.abs(best-target)) {
                    best = sum;
                }
                if (sum > target ) {
                    k--;
                    while (k > j &&  nums[k] ==  nums[k+1]) {
                        k--;
                    }

                } else {
                    j++;
                    while (k > j &&  nums[j] ==  nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return best;
    }
}
