/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        System.out.println(new JumpGame2().jump2(nums));
    }

    public int jump2(int[] nums) {
        int step = 0;
        int i = 0;
        int n = nums.length-1;
        while (i < n) {
            if (i + nums[i] >= n) {
                return ++step;
            }
            int indexOfMax = -1;
            int max = -1;
            for (int j = 1; j <=  nums[i]; j++) {
                if (nums[i+j] + j >= max) {
                    max = nums[i+j] + j;
                    indexOfMax = i+j;
                }
            }
            i = indexOfMax;
            ++step;
        }
        return step;
    }
}

