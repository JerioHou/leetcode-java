import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int curr = nums[i];
            if (curr > 0 ) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1; int right = nums.length - 1;
            while (left <  right) {
                if (right < nums.length - 1 && nums[right] == nums[right+1]) {
                    right -= 1;
                    continue;
                }
                if (curr + nums[left] + nums[right] > 0) {
                    right -= 1;
                } else if(curr + nums[left] + nums[right] < 0) {
                    left += 1;
                } else {
                    result.add(Arrays.asList(curr,nums[left],nums[right]));
                    right -= 1;
                    left += 1;
                }
            }
        }
        return result;
    }
}
