import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) {
            return result;
        }
        for (int i = 0; i < nums.length -3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < nums.length -2;j++) {
                if (j >i+1 && nums[j-1] == nums[j]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int count = nums[i] + nums[j] + nums[left] + nums[right];
                    if (count > target) {
                        right--;
                    } else if (count < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
