import java.awt.font.NumericShaper;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        int[] nums3 = {0};
        int[] nums4 = {3,0,0,0};
        System.out.println(new JumpGame().canJump2(nums1));
        System.out.println(new JumpGame().canJump2(nums2));
        System.out.println(new JumpGame().canJump2(nums3));
        System.out.println(new JumpGame().canJump2(nums4));
    }

    /**
     * 此方法的思路是：
     * 从后往前数，寻找第一个为0的坐标，记录该坐标indexOfZero
     * 如果该坐标不能被跨越（即：nums[indexOfZero-1] < 1,nums[indexOfZero-2] <2 ...nums[indexOfZero-i] < i）
     * 则说明不可达。
     * 如果该坐标可以被跨越，则重置indexOfZero为-1，继续遍历
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int indexOfZero = -1;
        for (int i= nums.length-2; i >=0;--i) {
            if (nums[i] == 0 && indexOfZero == -1) {
                indexOfZero = i;
            }
            if (indexOfZero != -1 && nums[i] > (indexOfZero-i)) {
                indexOfZero = -1;
            }
        }
        if (indexOfZero == -1) {
            return true;
        } else {
            return false;
        }
    }


    public boolean canJump(int[] nums) {
        return backTrack(nums,0,nums.length-1);
    }

    /**
     *  回溯算法可以解决，但时间复杂度过高
     * @param nums
     * @param curr
     * @param lastIndex
     * @return
     */
    boolean backTrack(int[] nums, int curr,int lastIndex) {
        if (curr > lastIndex || nums[curr] + curr >= lastIndex) {
            return true;
        }
        for (int i = nums[curr]; i > 0; --i) {
            if (backTrack(nums,curr+i,lastIndex)) {
                return true;
            }
        }
        return false;
    }
}
