/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,3,4,4,4};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }


    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int fast = 1, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
                continue;
            }
            slow++;
            if (slow != fast) {
                nums[slow] =nums[fast];
            }
            fast++;

        }
        return slow+1;
    }
}
